package com.InsuranceManagementplateform.demo.clientService.service;

import com.InsuranceManagementplateform.demo.clientService.requestData.ClientRequestData;
import com.InsuranceManagementplateform.demo.clientService.responseData.ClientResponseData;

import java.util.List;

public interface ClientService {

    List<ClientResponseData> getAllClients();

    ClientResponseData getClientById(int id);

    ClientResponseData createClient(ClientRequestData clientRequestData);

    ClientResponseData updateClient(int id ,ClientRequestData clientRequestData);

    String deleteClient(int id);
}
