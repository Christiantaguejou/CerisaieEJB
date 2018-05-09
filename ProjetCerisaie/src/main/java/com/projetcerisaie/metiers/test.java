package com.projetcerisaie.metiers;

import com.projetcerisaie.metiers.Entities.ClientEntity;
import com.projetcerisaie.metiers.dao.GeneralOperations;
import com.projetcerisaie.metiers.meserreurs.MonException;

public class test {
    public static void main(String[] args) throws MonException {

        GeneralOperations generalOperations = new GeneralOperations();

        // Add Persons
        generalOperations.delete(new ClientEntity("Bor4","12",12,"12","12",12));

    }
}
