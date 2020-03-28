--Puebla la tabla persona_natural
INSERT INTO PERSONA_NATURAL (identificacion, nombre, apellido,numeroPago)
VALUES (1000944030, 'Alvaro', 'Uribe',1000000000000000 );

INSERT INTO PERSONA_NATURAL (identificacion, nombre, apellido,numeroPago)
VALUES (1000233896, 'Pablo', 'Castro',1000000000000222 );

INSERT INTO PERSONA_NATURAL (identificacion, nombre, apellido,numeroPago)
VALUES (1000233897, 'Jessie', 'Benedetti',1000000000000333  );

INSERT INTO PERSONA_NATURAL (identificacion, nombre, apellido,numeroPago)
VALUES (1000233898, 'Andrea', 'Rodriguez',1000000000000444  );

--Puebla la tabla cliente
INSERT INTO CLIENTE (identificacion, nombre, apellido, vinculo, numero_Pago)
VALUES (1000944001, 'Alvaro', 'Uribe','estudiante',10000000000000123 );

INSERT INTO CLIENTE (identificacion, nombre, apellido, vinculo, numero_Pago)
VALUES (1000944002, 'Juan', 'Perez', 'profesor',1000000000000002 );

INSERT INTO CLIENTE (identificacion, nombre, apellido, vinculo, numero_Pago)
VALUES (1000944003, 'Jose', 'Sanchez', 'egresado',1000000000000003 );

INSERT INTO CLIENTE (identificacion, nombre, apellido, vinculo, numero_Pago)
VALUES (1000944004, 'Javier', 'Quevedo','empleado',1000000000000004 );

--Puebla la tabla empresa
INSERT INTO EMPRESA (NIT ,registradoCamaraDeComercio ,registradoIndependenciaTurismo , nombre , web ,numeroPago)
VALUES(1000000000, 1, 1, 'TurismosAhora', 'https://www.lol.com/pagina', 1000000000000007);

INSERT INTO EMPRESA (NIT ,registradoCamaraDeComercio ,registradoIndependenciaTurismo , nombre , web ,numeroPago)
VALUES(1000000020, 1, 1, 'HotelesPerfectos', 'https://www.hotelesPerfectos.com/pagina', 1000000000000020);

INSERT INTO EMPRESA (NIT ,registradoCamaraDeComercio ,registradoIndependenciaTurismo , nombre , web ,numeroPago)
VALUES(1000000030, 1, 1, 'Empresarios', 'https://www.empresariios.com/pagina', 1000000000000030);

INSERT INTO EMPRESA (NIT ,registradoCamaraDeComercio ,registradoIndependenciaTurismo , nombre , web ,numeroPago)
VALUES(1000000040, 1, 1, 'HospedajesATuComodidad', 'https://www.HospedajesATuComodidad.com/pagina', 1000000000000040);


--Puebla la tabla HOSPEDAJE
INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(1, 'ApartamentosKpos', 'CRA 16','APARTAMENTO', 250000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(2, 'ApartamentosLindos', 'CRA 12', 'APARTAMENTO',260000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(3, 'ApartamentosOK', 'CRA 13', 'APARTAMENTO',270000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion,tipoHospedaje, valorTotal)
VALUES(4, 'ApartamentosFelices', 'CRA 12','APARTAMENTO',270000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje,valorTotal)
VALUES(5, 'HabitacionFelicia', 'CRA 7','HABITACION',250000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(6, 'HabitacionNoC', 'CRA 20','HABITACION', 260000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje,valorTotal)
VALUES(7, 'HabitacionXD', 'CRA 2','HABITACION',270000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(8, 'Habitacion lol', 'CRA 1','HABITACION',270000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(55, 'city U', 'CRA 16','VIVIENDA_UNIVERSITARIA',260000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(56, 'ViviendaUniversitariaUnica', 'CRA 25','VIVIENDA_UNIVERSITARIA',270000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(57, 'ViviendaUniversitariaDos', 'CRA 18','VIVIENDA_UNIVERSITARIA',270000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(70, 'Sol caribe', 'CRA 16', 'HOTEL',260000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(71, 'Hotel Famoso', 'CRA 25','HOTEL',270000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(72, 'HotelKpo ', 'CRA 18','HOTEL',270000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(80, 'Hostal2', 'CRA 15','HOSTAL',260000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(81, 'HostalDosPorUno', 'CRA 16','HOSTAL',270000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(82, 'Hostal El mejor ', 'CRA 1','HOSTAL',270000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(83,'La Casa Mickey Mouse','CL 80','VIVIENDA', 500000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(84,'La Casita del bosque','CL 82A','VIVIENDA', 380000);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(85,'Casa chiquita','CRA 5','VIVIENDA', 250500);

--Puebla la tabla apartamento
INSERT INTO APARTAMENTO (id_apartamento, amoblado,capacidad, id_personaNatural, id_hospedaje)
VALUES(1,1,10, 1000233896, 1);

INSERT INTO APARTAMENTO (id_apartamento, amoblado,capacidad, id_personaNatural, id_hospedaje)
VALUES(2,1,10, 1000233896, 2);

INSERT INTO APARTAMENTO (id_apartamento, amoblado,capacidad, id_personaNatural, id_hospedaje)
VALUES(3,1,10, 1000944030, 3);

INSERT INTO APARTAMENTO (id_apartamento, amoblado,capacidad, id_personaNatural, id_hospedaje)
VALUES(4,1,10, 1000944030, 4);



--puebla la habitaciÃ³n
INSERT INTO HABITACION (idHabitacion, tipoHabitacion, numero, capacidad, id_personaNatural, id_vivienda_universitaria,id_hospedaje, id_hostal, idHotel)
VALUES(1,'SUITE', 15,5, 1000233898, 5, null, null, null);

INSERT INTO HABITACION (idHabitacion, tipoHabitacion, numero, capacidad, id_personaNatural, id_vivienda_universitaria,id_hospedaje, id_hostal, idHotel)
VALUES(2,'COMPARTIDA', 20,5, null,null, 6, 1, null);

INSERT INTO HABITACION (idHabitacion, tipoHabitacion, numero, capacidad, id_personaNatural, id_vivienda_universitaria,id_hospedaje, id_hostal, idHotel)
VALUES(3,'SEMISUITE', 85,5, null,null, 7, NULL, 1);

INSERT INTO HABITACION (idHabitacion, tipoHabitacion, numero, capacidad, id_personaNatural, id_vivienda_universitaria,id_hospedaje, id_hostal, idHotel)
VALUES(4,"ESTANDAR", 30,5, 1000233898,null, 8, NULL, null);


--PUEBLA VIVIENDA UNIVERSITARIA
INSERT INTO VIVIENDA_UNIVERSITARIA(idViviendaU,direccion, telefono, NIT_EMPRESA, idHospedaje)
VALUES(1, 'CR 16', 3228225845, 1000000000, 55);


INSERT INTO VIVIENDA_UNIVERSITARIA(idViviendaU,direccion, telefono, NIT_EMPRESA, idHospedaje)
VALUES(2, 'CR 25', 3228225845, 1000000020, 56);


INSERT INTO VIVIENDA_UNIVERSITARIA(idViviendaU,direccion, telefono, NIT_EMPRESA, idHospedaje)
VALUES(3, 'CR 18', 3228225845, 1000000020, 57);

--Puebla hotel
INSERT INTO HOTEL(idHotel, cantidadHabitaciones, estrellas, idHospedaje, NIT_EMPRESA)
VALUES(1, 500, 4, 70, 1000000020);

INSERT INTO HOTEL(idHotel, cantidadHabitaciones, estrellas, idHospedaje, NIT_EMPRESA)
VALUES(2, 1000, 5, 71, 1000000000);

INSERT INTO HOTEL(idHotel, cantidadHabitaciones, estrellas, idHospedaje, NIT_EMPRESA)
VALUES(3, 750, 2, 72, 1000000000);

--Publa hostal
INSERT INTO HOSTAL(idHostal, apertura, cierre, idHospedaje, NIT_EMPRESA)
VALUES(1, '08:00:00   ', '20:44:11', 80, 1000000020);

INSERT INTO HOSTAL(idHostal, apertura, cierre, idHospedaje, NIT_EMPRESA)
VALUES(2, '08:00:00', '20:00:00',81, 1000000000);

INSERT INTO HOSTAL(idHostal, apertura, cierre, idHospedaje, NIT_EMPRESA)
VALUES(3, '08:00:00   ', '24:00:00', 82, 1000000000);

--poblar servicio
INSERT INTO SERVICIO (idservicio,nombreservicio,valor,idhabitacion,idhotel,idhostal)
VALUES(1,'Internet',58000,1,2,3);

INSERT INTO SERVICIO (idservicio,nombreservicio,valor,idhabitacion,idhotel,idhostal)
VALUES(2,'Piscina',72000,3,3,3);

INSERT INTO SERVICIO (idservicio,nombreservicio,valor,idhabitacion,idhotel,idhostal)
VALUES(3,'Restaurante',30000,2,1,2);

--poblar vivienda
INSERT INTO VIVIENDA (id_vivienda,numero_habitacion,menaje,dias_usada,costocontenido,costo_inmueble,id_personaNatural,id_Hospedaje)
VALUES(1,3,'mesa-comedor',0,1500000,200000,1000233896,83);

INSERT INTO VIVIENDA (id_vivienda,numero_habitacion,menaje,dias_usada,costocontenido,costo_inmueble,id_personaNatural,id_Hospedaje)
VALUES(2,4,'cama doble, lampara de oro',10,900000,100000,1000944030,84);

INSERT INTO VIVIENDA (id_vivienda,numero_habitacion,menaje,dias_usada,costocontenido,costo_inmueble,id_personaNatural,id_Hospedaje)
VALUES(3,2,'lava-vajillas',24,85000,500000,1000944030,85);

--Puebla contrato
INSERT INTO CONTRATO (idContrato, valor, fecha_reserva, fecha_inicio, fecha_final, capacidad, idHospedaje,idCedulaCliente, NIT_EMPRESA,  cedulaPersonaNatural)
VALUES(1,500000, '25-03-2020', '25-03-2020','27-03-2020',50,1, 1000944001, 1000000020, null);

INSERT INTO CONTRATO (idContrato, valor, fecha_reserva, fecha_inicio, fecha_final, capacidad, idHospedaje,idCedulaCliente, NIT_EMPRESA, cedulaPersonaNatural)
VALUES(2,1000000, '25-03-2020', '27-03-2020','29-03-2020',5,2, 1000944002, 1000000020, null);

INSERT INTO CONTRATO (idContrato, valor, fecha_reserva, fecha_inicio, fecha_final, capacidad, idHospedaje,idCedulaCliente, NIT_EMPRESA, cedulaPersonaNatural)
VALUES(3,1000000, '25-03-2020', '27-03-2020','29-03-2020', 4, 3, 1000944002, 1000000020, null);

INSERT INTO CONTRATO (idContrato, valor, fecha_reserva, fecha_inicio, fecha_final, capacidad, idHospedaje,idCedulaCliente, NIT_EMPRESA, cedulaPersonaNatural)
VALUES(4,1000000,'25-03-2020', '28-03-2020','30-03-2020', 20,4, 1000944002, 1000000020, null);

COMMIT;