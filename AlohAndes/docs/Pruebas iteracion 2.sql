--Pruebas
--Las pruebas se desarrollan teniendo en cuenta la población de las tablas
--ya desarrolladas.

--Pruebas de unicidad de tuplas. Para cada tabla:
--A:se encuentran en el .sql que puebla las tablas.
--B
INSERT INTO PERSONA_NATURAL (identificacion, nombre, apellido,numeroPago)
VALUES (1000944030, 'Alvaro', 'Uribe',1000000000000000 );

INSERT INTO CLIENTE (identificacion, nombre, apellido, vinculo, numero_Pago)
VALUES (1000944001, 'Alvaro', 'Uribe','estudiante',10000000000000123 );

INSERT INTO EMPRESA (NIT ,registradoCamaraDeComercio ,registradoIndependenciaTurismo , nombre , web ,numeroPago)
VALUES(1000000000, 1, 1, 'TurismosAhora', 'https://www.lol.com/pagina', 1000000000000007);

INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(2, 'ApartamentosLindos', 'CRA 12', 'APARTAMENTO',260000);

INSERT INTO APARTAMENTO (id_apartamento, amoblado,capacidad, id_personaNatural, id_hospedaje)
VALUES(1,1,10, 1000233896, 1);

INSERT INTO HABITACION (idHabitacion, tipoHabitacion, numero, capacidad, id_personaNatural, id_vivienda_universitaria,id_hospedaje, id_hostal, idHotel)
VALUES(1,'SUITE', 15,5, 1000233898, 5, null, null, null);

INSERT INTO VIVIENDA_UNIVERSITARIA(idViviendaU,direccion, telefono, NIT_EMPRESA, idHospedaje)
VALUES(1, 'CR 16', 3228225845, 1000000000, 55);

INSERT INTO HOTEL(idHotel, cantidadHabitaciones, estrellas, idHospedaje, NIT_EMPRESA)
VALUES(1, 500, 4, 70, 1000000020);

INSERT INTO HOSTAL(idHostal, apertura, cierre, idHospedaje, NIT_EMPRESA)
VALUES(1, '8  ', '24', 80, 1000000020);

INSERT INTO SERVICIO (idservicio,nombreservicio,valor,idhabitacion,idhotel,idhostal)
VALUES(1,'Internet',58000,1,2,3);

INSERT INTO VIVIENDA (id_vivienda,numero_habitacion,menaje,dias_usada,costocontenido,costo_inmueble,id_personaNatural,id_Hospedaje)
VALUES(1,3,'mesa-comedor',0,1500000,200000,1000233896,83);

INSERT INTO CONTRATO (idContrato, valor, fecha_final, fecha_inicio, idHospedaje,idCedulaCliente, NIT_EMPRESA, cedulaPersonaNatural)
VALUES(1,500000, '25-03-2020','27-03-2020',1, 1000944001, 1000000020, null);
--C se encuentra en el archivo .txt adjunto


--Pruebas de integridad con FK
--A:se encuentran en el .sql que puebla las tablas.
--B
INSERT INTO APARTAMENTO (id_apartamento, amoblado,capacidad, id_personaNatural, id_hospedaje)
VALUES(15,1,10, 12, 1);

INSERT INTO HABITACION (idHabitacion, tipoHabitacion, numero, capacidad, id_personaNatural, id_vivienda_universitaria,id_hospedaje, id_hostal, idHotel)
VALUES(15,'SUITE', 15,5, 12, 5, null, null, null);

INSERT INTO VIVIENDA_UNIVERSITARIA(idViviendaU,direccion, telefono, NIT_EMPRESA, idHospedaje)
VALUES(2000, 'CR 16', 3228225845, 12, 55);

INSERT INTO HOTEL(idHotel, cantidadHabitaciones, estrellas, idHospedaje, NIT_EMPRESA)
VALUES(2000, 500, 4, 32, 8);

INSERT INTO SERVICIO (idservicio,nombreservicio,valor,idhabitacion,idhotel,idhostal)
VALUES(1,'Internet',58000,1,50000,3);

INSERT INTO VIVIENDA (id_vivienda,numero_habitacion,menaje,dias_usada,costocontenido,costo_inmueble,id_personaNatural,id_Hospedaje)
VALUES(1,3,'mesa-comedor',0,1500000,200000,2,5000);

INSERT INTO CONTRATO (idContrato, valor, fecha_final, fecha_inicio, idHospedaje,idCedulaCliente, NIT_EMPRESA, cedulaPersonaNatural)
VALUES(4,1000000, '28-03-2020','30-03-2020',4, 1, 1, null);

INSERT INTO HOSTAL(idHostal, apertura, cierre, idHospedaje, NIT_EMPRESA)
VALUES(3, '6  ', '24', 82, 1000000000);



--Pruebas de los CHECK que no son foreign key
-- Se toma en cuenta las
INSERT INTO APARTAMENTO (id_apartamento, amoblado,capacidad, id_personaNatural, id_hospedaje)
VALUES(85,20,10,1000233896, 1);
--No se puede tener una cedula con menos de 7 digitos
INSERT INTO PERSONA_NATURAL (identificacion, nombre, apellido,numeroPago)
VALUES (1000, 'Alvaro', 'Uribe',1000000000000000 );
--No se puede tener un  número de pago menor a 16 digitos
INSERT INTO PERSONA_NATURAL (identificacion, nombre, apellido,numeroPago)
VALUES (1000944200, 'Alvaro', 'Uribe',10000 );
--No se puede tener una cedula con menos de 10 digitos
INSERT INTO EMPRESA (NIT ,registradoCamaraDeComercio ,registradoIndependenciaTurismo , nombre , web ,numeroPago)
VALUES(20, 1, 1, 'TurismosAhora', 'https://www.lol.com/pagina', 1000000000000007);
--No se puede tener un  número de pago menor a 16 digitos
INSERT INTO EMPRESA (NIT ,registradoCamaraDeComercio ,registradoIndependenciaTurismo , nombre , web ,numeroPago)
VALUES(1000000080, 1, 1, 'TurismosAhora', 'https://www.lol.com/pagina', 20);
--Se tiene que tener una URL valida
INSERT INTO EMPRESA (NIT ,registradoCamaraDeComercio ,registradoIndependenciaTurismo , nombre , web ,numeroPago)
VALUES(1000000080, 1, 1, 'TurismosAhora', 'NOC', 20);
--Tiene que pertenecer a la enumeración
INSERT INTO HOSPEDAJE (idHospedaje,nombre, direccion, tipoHospedaje, valorTotal)
VALUES(40, 'ApartamentosLindos', 'CRA 12', 'NOC',260000);
--Tiene que pertenecer a la enumeración
INSERT INTO HABITACION (idHabitacion, tipoHabitacion, numero, capacidad, id_personaNatural, id_vivienda_universitaria,id_hospedaje, id_hostal, idHotel)
VALUES(30,'NOC', 15,5, 1000233898, 5, null, null, null);
--Las estrellas tienen que ser menor o igual a cinco
INSERT INTO HOTEL(idHotel, cantidadHabitaciones, estrellas, idHospedaje, NIT_EMPRESA)
VALUES(50, 500, 20, 70, 1000000020);
--las hora del hostal tiene que ser militar, no puede ser mayor a 24
INSERT INTO HOSTAL(idHostal, apertura, cierre, idHospedaje, NIT_EMPRESA)
VALUES(60, '80  ', '50', 80, 1000000020);


