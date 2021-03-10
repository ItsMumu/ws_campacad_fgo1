package fr.campusacad.ws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQManager {

    @Autowired
    public BooksService service;

    public String parseValidateMessage(String string) throws Exception {
        String[] stringSplitted = string.split("_");
        String values = stringSplitted[1].replace("[","").replace("]","");
        String[] booksId = values.split(",");

        try {
            for (String id:booksId
            ) {
                service.updateStock(id);
            }
            return "Destockage réussi !";
        }catch(Exception e){
            throw new Exception("Destockage impossible");
        }



    }


}
