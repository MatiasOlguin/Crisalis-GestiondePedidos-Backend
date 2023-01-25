/* poblar usuarios y roles */
INSERT INTO usuarios (id, username, password) VALUES(1, 'Crisalis', '$2a$10$kLtNhyZCW4QAye1jqTQFleTNcqScAcQI7pCuFe4ediVakaePUfxuG')
INSERT INTO roles (id, role_name) VALUES(1, 'ROLE_ADMIN')
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1)

/* poblar empresas */
INSERT INTO empresas (razon_social, cuit, inicio_actividades, create_at) VALUES('Fulano S.A','27-28033514-8' ,'1900-01-01', NOW())
INSERT INTO empresas (razon_social, cuit, inicio_actividades, create_at) VALUES('Mengano S.A','27-28033514-8' ,'1950-01-01', NOW())
INSERT INTO empresas (razon_social, cuit, inicio_actividades, create_at) VALUES('Sultano S.A','27-28033514-8' ,'2000-01-01', NOW())

/* poblar personas */
INSERT INTO clientes (nombre, apellido, dni, create_at,empresa_id) VALUES('Matias', 'Olguin', '12.345.678', '2022-12-11',1)
INSERT INTO clientes (nombre, apellido, dni, create_at) VALUES('Nahuel', 'Perez', '12.345.679', NOW())
INSERT INTO clientes (nombre, apellido, dni, create_at) VALUES('Juan', 'Olguin', '12.345.678', NOW())
INSERT INTO clientes (nombre, apellido, dni, create_at) VALUES('Miguel', 'Perez', '12.345.679', NOW())
INSERT INTO clientes (nombre, apellido, dni, create_at) VALUES('Paola', 'Reynoso', '12.345.679', NOW())

/* poblar productos */
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, marca, modelo, cantidad) VALUES ('producto', '50000','Celular','Samsung','A13',2)
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, marca, modelo, cantidad) VALUES ('producto', '45000','Celular','Motorola','G22',3)
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, marca, modelo, cantidad) VALUES ('producto', '35000','Celular','Samsung','A10',4)
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, marca, modelo, cantidad) VALUES ('producto', '45000','Celular','Motorola','G12',5)
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, marca, modelo, cantidad) VALUES ('producto', '2000','Router','Huawei','ASD',2)
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, marca, modelo, cantidad) VALUES ('producto', '1500','Router','Tp-Link','ASD',3)
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, marca, modelo, cantidad) VALUES ('producto', '3000','Router','Huawei','ZXC',2)
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, marca, modelo, cantidad) VALUES ('producto', '5000','Router','Tp-Link','ZXC',3)
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, marca, modelo, cantidad) VALUES ('producto', '50000','Tablet','Samsung','A13',5)
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, marca, modelo, cantidad) VALUES ('producto', '45000','Tablet','Motorola','G22',3)
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, marca, modelo, cantidad) VALUES ('producto', '50000','Tablet','Samsung','A13',7)
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, marca, modelo, cantidad) VALUES ('producto', '45000','Tablet','Motorola','G22',9)

/* poblar servicios */
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, tipo_servicio, cargo_soporte) VALUES ('servicio', '2000','Internet', 'Móvil',500)
INSERT INTO ofertas (oferta_tipo, monto_base, descripcion, tipo_servicio) VALUES ('servicio', '1000','Internet', 'Hogar')

/*poblar pedidos */
INSERT INTO pedidos (monto_total, cliente_id,create_at, estado) VALUES (10000,1, NOW(), 'EN_REVISION')

/*poblar items*/
INSERT INTO pedidos_items (cantidad, oferta_id, pedido_id) VALUES(1,1,1)
INSERT INTO pedidos_items (cantidad, oferta_id, pedido_id) VALUES(1,4,1)