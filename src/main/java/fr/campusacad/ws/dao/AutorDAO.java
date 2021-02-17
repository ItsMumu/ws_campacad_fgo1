package fr.campusacad.ws.dao;


import fr.campusacad.ws.dao.RO.AutorRO;
import fr.campusacad.ws.dao.RO.BooksRO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorDAO extends JpaRepository<AutorRO, Long> {
}
