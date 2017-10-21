package com.baldrick.clients.controller;

import com.baldrick.clients.dto.CreateClientRequestDto;
import com.baldrick.clients.model.Client;
import com.baldrick.clients.service.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@RestController
@RequestMapping(path = "/create")
public class CreateClientController {

    private static final Logger LOGGER = Logger.getLogger(CreateClientController.class);

    @Autowired
    ClientService clientService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addClient(@RequestBody CreateClientRequestDto createClientRequestDto) {
        LOGGER.info("Called addClient");
        String username = createClientRequestDto.getUsername();
        long utc = ZonedDateTime.now(ZoneOffset.UTC).toEpochSecond();

        clientService.createClient(new Client(username, username,
                createClientRequestDto.getPassword(), createClientRequestDto.getEmail(), createClientRequestDto.getFirstName(),
                createClientRequestDto.getLastName(), Long.valueOf(createClientRequestDto.getDateOfBirth()), utc, 0.00));
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(status);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        LOGGER.info("Called test");
        return "successful";
    }
}
