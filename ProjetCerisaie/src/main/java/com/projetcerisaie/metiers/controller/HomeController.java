package com.projetcerisaie.metiers.controller;

import com.projetcerisaie.metiers.Entities.ClientEntity;
import com.projetcerisaie.metiers.Entities.SejourEntity;
import com.projetcerisaie.metiers.dao.GeneralOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
    @RequestMapping(value = "index.htm", method = RequestMethod.GET)
    public ModelAndView Afficheindex(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "insererClient.htm")
    public View insererAdherent(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "listerAdherent.htm";
        try {
            GeneralOperations generalOperations = new GeneralOperations();
            generalOperations.insert(constructClientEntity(request));
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur.htm";
        }

        return new RedirectView(destinationPage);
    }
    @RequestMapping(value = "insererSejour.htm")
    public View insererSejour(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "listerAdherent.htm";
        try {
            GeneralOperations generalOperations = new GeneralOperations();
            generalOperations.insert(constructSejourEntity(request));
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur.htm";
        }

        return new RedirectView(destinationPage);
    }

    @RequestMapping(value = "inscriptionClient.htm")
    public ModelAndView inscriptionClient(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "";
        try {
            destinationPage = "inscriptionClient";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }
    @RequestMapping(value = "reservationSejour.htm")
    public ModelAndView reservationSejour(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "";
        try {
            destinationPage = "reservationSejour";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    private ClientEntity constructClientEntity(HttpServletRequest request) {
        ClientEntity client = new ClientEntity();
        client.setNomCli(request.getParameter("nom"));
        client.setNumPieceCli(Integer.parseInt(request.getParameter("numPieceCli")));
        client.setAdrRueCli(request.getParameter("adresse"));
        client.setCpCli(Integer.parseInt(request.getParameter("codePostal")));
        client.setVilleCli(request.getParameter("ville"));
        client.setPieceCli(request.getParameter("pieceCli"));
        return client;
    }
    private SejourEntity constructSejourEntity(HttpServletRequest request) {
        SejourEntity sejour = new SejourEntity();

        return sejour;
    }
    //TODO ajouter colonne disponibilite a emplacement et penser à espace client
    //TODO tarif en fonction de la durée du sejour


}