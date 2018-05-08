package com.projetcerisaie.metiers.services;

import com.projetcerisaie.metiers.Entities.ClientEntity;
import com.projetcerisaie.metiers.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImp implements ClientService{
    @Autowired
    private ClientDao clientDao;

    @Transactional
    @Override
    public void add(ClientEntity client) {
        clientDao.add(client);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientEntity> listClients() {
        return clientDao.listClients();
    }

}
