
Create database Ancianos;
USE Ancianos;


CREATE TABLE if not exists asistentes (
    id_asistente INT PRIMARY KEY auto_increment,
    nombre VARCHAR(50),
    especialidad VARCHAR(50),
    telefono VARCHAR(50),
    direccion VARCHAR(100),
    email VARCHAR(50)
);


CREATE TABLE if not exists personas (
    id_persona INT PRIMARY KEY auto_increment,
    nombre VARCHAR(50),
    direccion VARCHAR(100),
    telefono VARCHAR(15),
    email VARCHAR(50),
    dni VARCHAR(20),
    fecha_nacimiento VARCHAR(10)
);


CREATE TABLE if not EXISTS padecimientos (
    id_padecimiento INT auto_increment PRIMARY KEY,
    nombre_padecimiento VARCHAR(50),
    descripcion TEXT,
    gravedad VARCHAR(20)
);


CREATE TABLE if not EXISTS padecimientos_personas (
    id_persona INT,
    id_padecimiento INT,
    PRIMARY KEY (id_persona, id_padecimiento),
    FOREIGN KEY (id_persona) REFERENCES personas(id_persona),
    FOREIGN KEY (id_padecimiento) REFERENCES padecimientos(id_padecimiento)
);

CREATE TABLE if not EXISTS asistentes_personas (
    id_persona INT,
    id_asistente INT,
    PRIMARY KEY (id_persona, id_asistente),
    FOREIGN KEY (id_persona) REFERENCES personas(id_persona),
    FOREIGN KEY (id_asistente) REFERENCES asistentes(id_asistente)
);
