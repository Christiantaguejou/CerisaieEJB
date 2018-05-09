package com.projetcerisaie.metiers.services;

import com.projetcerisaie.metiers.Entities.ClientEntity;
import com.projetcerisaie.metiers.dao.ClientDao;
import com.projetcerisaie.metiers.dao.ClientDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService{
    @Autowired
    private ClientDao clientDao = new ClientDaoImp();


    @Override
    public void add(ClientEntity client) {
        clientDao.add(client);
    }

    @Override
    public List<ClientEntity> listClients() {
        return clientDao.listClients();
    }

}
