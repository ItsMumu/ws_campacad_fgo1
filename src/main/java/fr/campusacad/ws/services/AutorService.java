package fr.campusacad.ws.services;


import fr.campusacad.ws.dao.AutorDAO;
import fr.campusacad.ws.dao.RO.AutorRO;
import fr.campusacad.ws.dao.RO.BooksRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    public AutorDAO dao;

    public List<AutorRO> getAutors () {
        List<AutorRO> listOfAutors;

        listOfAutors = dao.findAll();
        return listOfAutors;
    }

}
