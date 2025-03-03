package com.app.backendapp.services;

import com.app.backendapp.model.Noticia;
import com.app.backendapp.repository.NoticiaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepository noticiaRepository;

    public NoticiaService(NoticiaRepository noticiaRepository) {
        this.noticiaRepository = noticiaRepository;
    }

    public List<Noticia> obtenerNoticias() {
        return noticiaRepository.findTop5ByOrderByFechaPublicacionDesc();
    }

    public Noticia obtenerDetalleNoticia(Long id){
        return noticiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el noticia encontrado"));
    }

    public List<Noticia> obtenerNoticiasRecomendadas() {
        return noticiaRepository.findTop3ByOrderByFechaPublicacionDesc();
    }
}
