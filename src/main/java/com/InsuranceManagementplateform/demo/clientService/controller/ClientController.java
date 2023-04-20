package com.InsuranceManagementplateform.demo.clientService.controller;


import com.InsuranceManagementplateform.demo.clientService.requestData.ClientRequestData;
import com.InsuranceManagementplateform.demo.clientService.responseData.ClientResponseData;
import com.InsuranceManagementplateform.demo.clientService.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "/clients")
    public ResponseEntity<List<ClientResponseData>> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping(path = "/clients/{id}")
    public ResponseEntity<ClientResponseData> getClientById(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/clients")
    public ResponseEntity<ClientResponseData> createClient(@RequestBody ClientRequestData clientRequestData) {
        return new ResponseEntity<>(clientService.createClient(clientRequestData), HttpStatus.CREATED);
    }

    @PutMapping(path = "/clients/{id}")
    public ResponseEntity<ClientResponseData> updateClient(@PathVariable(name = "id") int id, @RequestBody ClientRequestData clientRequestData) {
        return new ResponseEntity<>(clientService.updateClient(id, clientRequestData), HttpStatus.OK);
    }

    @DeleteMapping(path = "/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(clientService.deleteClient(id), HttpStatus.OK);
    }
}
