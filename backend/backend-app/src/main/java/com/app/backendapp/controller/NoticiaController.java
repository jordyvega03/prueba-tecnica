package com.app.backendapp.controller;

import com.app.backendapp.model.Noticia;
import com.app.backendapp.services.NoticiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {

    private final NoticiaService noticiaService;

    public NoticiaController(NoticiaService noticiaService){
        this.noticiaService = noticiaService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<List<Noticia>> obtenerNoticias() {
        return ResponseEntity.ok(noticiaService.obtenerNoticias());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public ResponseEntity<Noticia> obtenerDetalle(@PathVariable Long id) {
        return ResponseEntity.ok(noticiaService.obtenerDetalleNoticia(id));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/recomendadas")
    public ResponseEntity<List<Noticia>> obtenerRecomendadas() {
        return ResponseEntity.ok(noticiaService.obtenerNoticiasRecomendadas());
    }
}
