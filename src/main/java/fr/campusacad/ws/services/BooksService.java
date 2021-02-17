package fr.campusacad.ws.services;

import fr.campusacad.ws.dao.BooksDAO;
import fr.campusacad.ws.dao.RO.BooksRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    public BooksDAO dao;

    public List<BooksRO> getBooks(){
        List<BooksRO> listOfBooks;

        listOfBooks = dao.findAll();
        return listOfBooks;
    }

    public BooksRO insertBook(BooksRO book){
        BooksRO bookToReturn = new BooksRO();
        bookToReturn = dao.save(book);
        return bookToReturn;
    }

    @Transactional
    public void updateBook(BooksRO book){

       dao.updateBook(book.getNom(), book.getAuteur(), book.getDate(), book.getId());

    }

    @Transactional
    public void deleteBook(BooksRO book){
        dao.deleteBook(book.getId());
    }

    public BooksRO getBook(int id){
        BooksRO bookToReturn;

        bookToReturn = dao.findBookById(id);

        return bookToReturn;
    }

}
