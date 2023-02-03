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
INSERT INTO productos (monto_base, descripcion, marca, modelo, cantidad) VALUES (50000,'Celular','Samsung','A13',2)
INSERT INTO productos (monto_base, descripcion, marca, modelo, cantidad) VALUES (45000,'Celular','Motorola','G22',3)
INSERT INTO productos (monto_base, descripcion, marca, modelo, cantidad) VALUES (35000,'Celular','Samsung','A10',4)
INSERT INTO productos (monto_base, descripcion, marca, modelo, cantidad) VALUES (45000,'Celular','Motorola','G12',5)
INSERT INTO productos (monto_base, descripcion, marca, modelo, cantidad) VALUES (2000,'Router','Huawei','ASD',2)
INSERT INTO productos (monto_base, descripcion, marca, modelo, cantidad) VALUES (1500,'Router','Tp-Link','ASD',3)
INSERT INTO productos (monto_base, descripcion, marca, modelo, cantidad) VALUES (3000,'Router','Huawei','ZXC',2)
INSERT INTO productos (monto_base, descripcion, marca, modelo, cantidad) VALUES (5000,'Router','Tp-Link','ZXC',3)
INSERT INTO productos (monto_base, descripcion, marca, modelo, cantidad) VALUES (40000,'Tablet','Samsung','A13',5)
INSERT INTO productos (monto_base, descripcion, marca, modelo, cantidad) VALUES (45000,'Tablet','Motorola','G22',3)
INSERT INTO productos (monto_base, descripcion, marca, modelo, cantidad) VALUES (50000,'Tablet','Samsung','A13',7)
INSERT INTO productos (monto_base, descripcion, marca, modelo, cantidad) VALUES (45000,'Tablet','Motorola','G22',9)

/* poblar servicios */
INSERT INTO servicios (monto_base, descripcion, tipo) VALUES (2000,'Internet', 'Móvil')
INSERT INTO servicios (monto_base, descripcion, tipo) VALUES (1000,'Internet', 'Hogar')
INSERT INTO servicios (monto_base, descripcion, tipo) VALUES (2000,'Telefonia', 'Móvil')
INSERT INTO servicios (monto_base, descripcion, tipo) VALUES (1000,'Telefonia', 'Hogar')