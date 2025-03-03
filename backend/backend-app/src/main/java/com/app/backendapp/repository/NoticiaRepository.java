package com.app.backendapp.repository;

import com.app.backendapp.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    List<Noticia> findTop5ByOrderByFechaPublicacionDesc();
    List<Noticia> findTop3ByOrderByFechaPublicacionDesc();
}