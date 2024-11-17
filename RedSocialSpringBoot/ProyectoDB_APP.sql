drop database proyectoDB;
CREATE DATABASE proyectoDB;
USE proyectoDB;

-- Crear tabla usuarios sin la clave foránea problematica
CREATE TABLE IF NOT EXISTS usuarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(30),
  apellido VARCHAR(30),
  correo VARCHAR(30),
  contrasenia VARCHAR(30),
  telefono VARCHAR(30),
  imagen VARCHAR(40)
);

-- Crear tabla publicaciones con clave foránea hacia usuarios
CREATE TABLE IF NOT EXISTS publicaciones (
  id INT PRIMARY KEY AUTO_INCREMENT,
  usuario_id INT NOT NULL,
  tipo_publicacion VARCHAR(20),
  fecha_publicacion VARCHAR(20),
  contenido VARCHAR(20),
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- Crear tabla seguidores
-- Usamos dos claves foráneas hacia la tabla usuarios para representar la relación muchos a muchos
CREATE TABLE IF NOT EXISTS seguidores (
  id INT PRIMARY KEY AUTO_INCREMENT,
  seguidor_id INT NOT NULL,
  seguido_id INT NOT NULL,
  FOREIGN KEY (seguidor_id) REFERENCES usuarios(id) ON DELETE CASCADE,
  FOREIGN KEY (seguido_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- Crear tabla notificaciones con clave foránea hacia usuarios
CREATE TABLE IF NOT EXISTS notificaciones (
  id INT PRIMARY KEY AUTO_INCREMENT,
  usuario_id INT NOT NULL,
  fecha_notificacion DATE,
  tipo_notificacion VARCHAR(30),
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);


