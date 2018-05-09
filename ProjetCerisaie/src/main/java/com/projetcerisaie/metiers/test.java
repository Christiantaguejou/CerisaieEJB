package com.projetcerisaie.metiers;

import com.projetcerisaie.metiers.Entities.ClientEntity;
import com.projetcerisaie.metiers.services.ClientService;
import com.projetcerisaie.metiers.services.ClientServiceImp;

public class test {
    public static void main(String[] args) {


        ClientService personService = new ClientServiceImp();

        // Add Persons
        personService.add(new ClientEntity(14, "Bora","12",12,"12","12",12));

    }
}
