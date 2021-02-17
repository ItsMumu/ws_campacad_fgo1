package fr.campusacad.ws.ctrl;


import fr.campusacad.ws.dao.RO.AutorRO;
import fr.campusacad.ws.dao.RO.BooksRO;
import fr.campusacad.ws.services.AutorService;
import fr.campusacad.ws.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/autor/")
public class AutorCtrl {

    @Autowired
    public AutorService service;

    @GetMapping("getall")
    public List<AutorRO> getAutors () throws Exception {
        try{
            List<AutorRO> AutorsToReturn;
            AutorsToReturn = service.getAutors();
            return AutorsToReturn;
        }catch(Exception e){
            throw  new Exception("Récupérations des livres impossible");
        }

    }
}
