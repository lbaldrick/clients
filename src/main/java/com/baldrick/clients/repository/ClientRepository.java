package com.baldrick.clients.repository;

import com.baldrick.clients.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public Optional<Client> findByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));

        return Optional.ofNullable(mongoTemplate.findOne(query, Client.class));
    }

    public Optional<Client> findByEmail(String email) {
        Query query = new Query();
        query.addCriteria(Criteria
                .where("email")
                .is(email));
        return Optional.ofNullable(mongoTemplate.findOne(query, Client.class));
    }

    public boolean insert(Client client) {
        if(exists(client)) {
            return false;
        }

        mongoTemplate.insert(client);
        return true;
    }

    public boolean exists(Client client) {
        Query query = new Query();
        query.addCriteria(Criteria
                .where("username")
                .is(client.getUsername())
                .orOperator(Criteria
                        .where("email")
                        .is(client.getEmail())));

        return Optional.ofNullable(mongoTemplate.findOne(query, Client.class)).isPresent();
    }

    public void updateBalance(String username, double balance) {
        Optional<Client> client = findByUsername(username);
        client.ifPresent((c) -> {
            c.setBalance(balance);
            mongoTemplate.save(c);
        });
    }

    public void updatePassword(String username, String password) {
        Optional<Client> client = findByUsername(username);
        client.ifPresent((c) -> {
            c.setPassword(password);
            mongoTemplate.save(c);
        });
    }
}
