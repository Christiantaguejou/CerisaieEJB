package com.projetcerisaie.metiers.dao;

import com.projetcerisaie.metiers.Entities.ClientEntity;

import java.util.List;

public interface ClientDao {
    void add(ClientEntity clientEntity);
    List<ClientEntity> listClients();

}
