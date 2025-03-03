CREATE DATABASE IF NOT EXISTS NoticiasDB;
USE NoticiasDB;

CREATE TABLE USUARIO (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE CATEGORIA (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE NOTICIA (
    id_noticia INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    imagen VARCHAR(255),
    descripcion TEXT NOT NULL,
    cuerpo TEXT NOT NULL,
    fecha_publicacion DATE NOT NULL,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES CATEGORIA(id_categoria)
);

CREATE TABLE RECOMENDACION (
    id_recomendacion INT AUTO_INCREMENT PRIMARY KEY,
    id_noticia_principal INT,
    id_noticia_recomendada INT,
    FOREIGN KEY (id_noticia_principal) REFERENCES NOTICIA(id_noticia),
    FOREIGN KEY (id_noticia_recomendada) REFERENCES NOTICIA(id_noticia)
);
