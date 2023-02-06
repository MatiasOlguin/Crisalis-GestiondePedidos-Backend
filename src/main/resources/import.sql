/* poblar usuarios */
INSERT INTO usuarios (username, password) VALUES ('Crisalis', '12345')

/* poblar empresas */
INSERT INTO empresas (borrado, razon_social, cuit, inicio_actividades, create_at) VALUES(false, 'Empresa A','27-28033514-8' ,'1900-01-01', NOW())
INSERT INTO empresas (borrado, razon_social, cuit, inicio_actividades, create_at) VALUES(false, 'Empresa B','27-28033514-8' ,'1950-01-01', NOW())
INSERT INTO empresas (borrado, razon_social, cuit, inicio_actividades, create_at) VALUES(false, 'Empresa C','27-28033514-8' ,'2000-01-01', NOW())

/* poblar personas */
INSERT INTO clientes (borrado, nombre, apellido, dni, create_at,empresa_id) VALUES(false, 'Matias', 'Olguin', '12345678', '2022-12-11',1)
INSERT INTO clientes (borrado, nombre, apellido, dni, create_at) VALUES(false, 'Nahuel', 'Perez', '12345679', NOW())
INSERT INTO clientes (borrado, nombre, apellido, dni, create_at) VALUES(false, 'Juan', 'Olguin', '12345678', NOW())
INSERT INTO clientes (borrado, nombre, apellido, dni, create_at) VALUES(false, 'Miguel', 'Perez', '12345679', NOW())
INSERT INTO clientes (borrado, nombre, apellido, dni, create_at) VALUES(false, 'Paola', 'Reynoso', '12345679', NOW())

/* poblar productos */
INSERT INTO productos (borrado, monto_base, descripcion, marca, modelo, cantidad) VALUES (false, 50000,'Celular','Samsung','A13',2)
INSERT INTO productos (borrado, monto_base, descripcion, marca, modelo, cantidad) VALUES (false, 45000,'Celular','Motorola','G22',3)
INSERT INTO productos (borrado, monto_base, descripcion, marca, modelo, cantidad) VALUES (false, 35000,'Celular','Samsung','A10',4)
INSERT INTO productos (borrado, monto_base, descripcion, marca, modelo, cantidad) VALUES (false, 45000,'Celular','Motorola','G12',5)
INSERT INTO productos (borrado, monto_base, descripcion, marca, modelo, cantidad) VALUES (false, 2000,'Router','Huawei','ASD',2)
INSERT INTO productos (borrado, monto_base, descripcion, marca, modelo, cantidad) VALUES (false, 1500,'Router','Tp-Link','ASD',3)
INSERT INTO productos (borrado, monto_base, descripcion, marca, modelo, cantidad) VALUES (false, 3000,'Router','Huawei','ZXC',2)
INSERT INTO productos (borrado, monto_base, descripcion, marca, modelo, cantidad) VALUES (false, 5000,'Router','Tp-Link','ZXC',3)
INSERT INTO productos (borrado, monto_base, descripcion, marca, modelo, cantidad) VALUES (false, 40000,'Tablet','Samsung','A13',5)
INSERT INTO productos (borrado, monto_base, descripcion, marca, modelo, cantidad) VALUES (false, 45000,'Tablet','Motorola','G22',3)
INSERT INTO productos (borrado, monto_base, descripcion, marca, modelo, cantidad) VALUES (false, 50000,'Tablet','Samsung','A13',7)
INSERT INTO productos (borrado, monto_base, descripcion, marca, modelo, cantidad) VALUES (false, 45000,'Tablet','Motorola','G22',9)

/* poblar servicios */
INSERT INTO servicios (borrado, monto_base, descripcion, tipo) VALUES (false, 2000,'Internet', 'Móvil')
INSERT INTO servicios (borrado, monto_base, descripcion, tipo) VALUES (false, 1000,'Internet', 'Hogar')
INSERT INTO servicios (borrado, monto_base, descripcion, tipo) VALUES (false, 2000,'Telefonia', 'Móvil')
INSERT INTO servicios (borrado, monto_base, descripcion, tipo) VALUES (false, 1000,'Telefonia', 'Hogar')