USE proyectoDB;

-- Insertar datos en la tabla usuarios
INSERT INTO usuarios (nombre, apellido, correo, contrasenia, telefono, imagen)
VALUES 
  ('Juan', 'Perez', 'juan@example.com', 'contrasenia1', '123456789', 'imagen1.jpg'),
  ('Maria', 'Gomez', 'maria@example.com', 'contrasenia2', '987654321', 'imagen2.jpg'),
  ('Pedro', 'Martinez', 'pedro@example.com', 'contrasenia3', '456123789', 'imagen3.jpg'),
  ('Laura', 'Lopez', 'laura@example.com', 'contrasenia4', '789456123', 'imagen4.jpg');

-- Insertar datos en la tabla publicaciones
INSERT INTO publicaciones (usuario_id, tipo_publicacion, fecha_publicacion, contenido)
VALUES 
  (1, 'foto', '2024-06-01', 'Hola a todos!'),
  (2, 'video', '2024-05-30', 'Nuevo video en mi canal!'),
  (3, 'texto', '2024-05-28', 'Este es un post de prueba'),
  (4, 'foto', '2024-05-26', 'Una foto bonita');

-- Insertar datos en la tabla seguidores
INSERT INTO seguidores (seguidor_id, seguido_id)
VALUES 
  (1, 2),
  (2, 3),
  (3, 4),
  (4, 1);

-- Insertar datos en la tabla notificaciones
INSERT INTO notificaciones (usuario_id, fecha_notificacion, tipo_notificacion)
VALUES 
  (1, '2024-06-02', "push"),
  (2, '2024-06-01', "a"),
  (3, '2024-05-31',"b"),
  (4, '2024-05-30',"c");
