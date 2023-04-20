package com.InsuranceManagementplateform.demo.clientService.service;

import com.InsuranceManagementplateform.demo.clientService.constant.Constants;
import com.InsuranceManagementplateform.demo.clientService.entity.Client;
import com.InsuranceManagementplateform.demo.clientService.exception.EntityNotFoundException;
import com.InsuranceManagementplateform.demo.clientService.repository.ClientRepository;
import com.InsuranceManagementplateform.demo.clientService.requestData.ClientRequestData;
import com.InsuranceManagementplateform.demo.clientService.responseData.ClientResponseData;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository ;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientResponseData> getAllClients() {

        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(client -> mapToDto(client)).collect(Collectors.toList());
    }

    @Override
    public ClientResponseData getClientById(int id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return mapToDto(client.get());
    }

    @Override
    public ClientResponseData createClient(ClientRequestData clientRequestData) {
        Client client = mapToEntity(clientRequestData);

        Client save = clientRepository.save(client);
        return mapToDto(save);
    }

    @Override
    public ClientResponseData updateClient(int id, ClientRequestData updateData) {
        Optional<Client> clientDataById = clientRepository.findById(id);
        if (clientDataById.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Client client = clientDataById.get();

        client.setName(updateData.getName());
        client.setDob(updateData.getDob());
        client.setAddress(updateData.getAddress());
        client.setContactInformation(updateData.getContactInformation());

        clientRepository.save(client);
        return mapToDto(client);
    }

    @Override
    public String deleteClient(int id) {
        Optional<Client> byId = clientRepository.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Client client = byId.get();
        clientRepository.delete(client);
        return Constants.DELETE_MESSAGE ;
    }

    // METHOD TO CONVERT REQUEST OBJECT INTO ENTITY OBJECT
    private Client mapToEntity(ClientRequestData clientRequestData) {

        Client client = new Client();


        if (clientRequestData.getName() != null) {
            client.setName(clientRequestData.getName().trim());
        }

        if (clientRequestData.getDob() != null) {
            client.setDob(clientRequestData.getDob());
        }

        if (clientRequestData.getAddress()!=null) {
            client.setAddress(clientRequestData.getAddress().trim());
        }

        if (clientRequestData.getContactInformation()!=null) {
            client.setContactInformation(clientRequestData.getContactInformation().trim());
        }

        return client ;
    }

    // METHOD TO CONVERT ENTITY OBJECT INTO RESPONSE OBJECT
    private ClientResponseData mapToDto(Client client) {

        ClientResponseData clientResponseData = new ClientResponseData();
        if (client.getId()!=0) {
            clientResponseData.setId(client.getId());
        }

        if (client.getName()!=null) {
            clientResponseData.setName(client.getName());
        }

        if (client.getDob()!=null) {
            clientResponseData.setDob(client.getDob());
        }

        if (client.getAddress()!=null) {
            clientResponseData.setAddress(client.getAddress());
        }

        if (client.getContactInformation()!=null) {
            clientResponseData.setContactInformation(client.getContactInformation());
        }

        if (client.getPolicies()!=null) {
            clientResponseData.setPolicies(client.getPolicies());
        }

        return clientResponseData ;
    }
}
