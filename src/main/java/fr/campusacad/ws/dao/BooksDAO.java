package fr.campusacad.ws.dao;

import fr.campusacad.ws.dao.RO.AutorRO;
import fr.campusacad.ws.dao.RO.BooksRO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksDAO extends JpaRepository<BooksRO, Long> {

    @Modifying
    @Query(value = "UPDATE public.book set nom =:nom, auteur =:auteur, date =:date where id = :id", nativeQuery = true)
    public void updateBook(@Param("nom") String nom, @Param("auteur") AutorRO auteur, @Param("date") String date, @Param("id") int id);

    @Query("select b from BooksRO b where b.id = :id")
    public BooksRO findBookById(@Param("id") int id);

    @Modifying
    @Query(value = "DELETE FROM public.book WHERE id = :id" , nativeQuery = true)
    public void deleteBook(@Param("id") int id);
}
