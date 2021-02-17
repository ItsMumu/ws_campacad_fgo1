package fr.campusacad.ws.ctrl;


import fr.campusacad.ws.dao.RO.BooksRO;
import fr.campusacad.ws.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/book/")
public class BooksCtrl {


    @Autowired
    public BooksService service;

    @GetMapping ("getall")
    public List<BooksRO> getBooks () throws Exception {
        try{
            List<BooksRO> booksToReturn;
            booksToReturn = service.getBooks();
            return booksToReturn;
        }catch(Exception e){
            throw  new Exception("Récupérations des livres impossible");
        }

    }

    @PostMapping("insert")
    public BooksRO insertBook (@RequestBody BooksRO book) throws Exception {
        try{
            BooksRO bookToReturn;
            bookToReturn = service.insertBook(book);
            return bookToReturn;
        }catch(Exception e){
            throw  new Exception("Récupérations des livres impossible");
        }

    }

    @PostMapping("update")
    public void updateBook (@RequestBody BooksRO book) throws Exception {
        try{
            service.updateBook(book);

        }catch(Exception e){
            throw  new Exception("Récupérations des livres impossible");
        }

    }

    @PostMapping("delete")
    public void deleteBook (@RequestBody BooksRO book) throws Exception {
        try{
            service.deleteBook(book);

        }catch(Exception e){
            throw  new Exception("Récupérations des livres impossible");
        }

    }

    @GetMapping(path = "get/{id}")
    public BooksRO getBook (@PathVariable("id") String id) throws Exception {
        try{
            int idInt=Integer.parseInt(id);
            BooksRO bookToReturn;
            bookToReturn = service.getBook(idInt);
            return bookToReturn;

        }catch(Exception e){
            throw  new Exception("Récupérations des livres impossible");
        }

    }
}
