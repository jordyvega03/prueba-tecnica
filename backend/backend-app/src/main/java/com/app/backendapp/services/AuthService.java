package com.app.backendapp.services;

import com.app.backendapp.dto.RegisterRequest;
import com.app.backendapp.model.Usuario;
import com.app.backendapp.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Error: El usuario ya está registrado";
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setPassword(passwordEncoder.encode(request.getPassword())); // 🔥 ENCRIPTA LA CONTRASEÑA
        usuario.setRole(request.getRole().toUpperCase());

        usuarioRepository.save(usuario);
        return "Usuario registrado exitosamente";
    }
}
