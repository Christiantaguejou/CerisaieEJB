package com.projetcerisaie.metiers.services;

import com.projetcerisaie.metiers.Entities.ClientEntity;

import java.util.List;

public interface ClientService {
    void add(ClientEntity clientEntity);
    List<ClientEntity> listClients();
}
