CREATE TABLE Cliente
    ( identificacion number, 
    nombre varchar2(255 BYTE), 
    apellido VARCHAR2(255 BYTE), 
    vinculo varchar2(255 BYTE), 
    numero_Pago number,
    CONSTRAINT CLIENTE_PK PRIMARY KEY (identificacion));

 --Creacion Tabla contrato
 CREATE TABLE CONTRATO
    (idContrato number,
    valor number,
    fecha_reserva DATE,
    fecha_inicio DATE,
    fecha_Final DATE,
    CONSTRAINT CONTRATO_PK PRIMARY KEY (IdContrato),
    idHospedaje number NOT NULL,
    idCedulaCliente number NOT NULL,
    NIT_EMPRESA number,
    cedulaPersonaNatural number);
    
Alter table CONTRATO
add constraint tiempo_apto_habita_vivienda
    CHECK(SELECT FROM HOSPEDAJE))

--Crea tabla personaNatural
CREATE TABLE PERSONA_NATURAL
    (identificacion number,
    nombre varchar2(255 BYTE),
    apellido varchar2(255 BYTE),
    numeroPago number,
    CONSTRAINT PERSONA_NATURAL PRIMARY KEY (identificacion))
;

    CREATE TABLE VIVIENDA
    (id_Vivienda number,
    numero_habitacion number,
    menaje varchar2(255 BYTE),
    dias_usada number,
    costoContenido number,
    costo_inmueble number,
    id_personaNatural number,
    id_Hospedaje number NOT NULL ,
    CONSTRAINT VIVIENDA_PK PRIMARY KEY (id_Vivienda))
;


CREATE TABLE APARTAMENTO
    (id_Apartamento number,
    amoblado number,
    capacidad number,
    id_personaNatural number,
    id_Hospedaje number NOT NULL,
    CONSTRAINT APARTAMENTO_PK PRIMARY KEY (id_Apartamento));

    CREATE TABLE HABITACION
    (idHabitacion number,
    tipoHabitacion varchar2(255 BYTE),
    numero number,
    capacidad number,
    id_personaNatural number,
    id_vivienda_universitaria number,
    id_Hospedaje number NOT NULL,
    id_hostal number,
    idHotel number,
    CONSTRAINT HABITACION_PK PRIMARY KEY (idHabitacion));
    
    --CREA TABLA SERVICIO
CREATE TABLE SERVICIO
    (idServicio number,
    nombreServicio varchar2(255 BYTE),
    valor number,
    idHabitacion number,
    idHotel number,
    idHostal number,
    CONSTRAINT SERVICIO_PK PRIMARY KEY (idServicio));
    
    CREATE TABLE EMPRESA
    (NIT number,
    registradoCamaraDeComercio number,
    registradoIndependenciaTurismo number,
    nombre varchar2(255 byte),
    web varchar2(266 byte),
    numeroPago number,
    CONSTRAINT EMPRESA_PK PRIMARY KEY (NIT));
    
    CREATE TABLE HOSPEDAJE
    (idHospedaje number,
    nombre varchar2(255 byte),
    direccion varchar2(255 byte),
    valorTotal number,
    tipoHospedaje varChar2(255 byte),
    CONSTRAINT hospedaje_PK PRIMARY KEY (idHospedaje)
    );
alter table
add constraint CK_TIPOHOSPEDAJE
check( tipoHospedaje in ('APARTAMENTO', 'VIVIENDA', 'VIVIENDA_UNIVERSITARIA', 'HOTEL', 'HOSTAL', 'HABITACION'));

CREATE TABLE VIVIENDA_UNIVERSITARIA
    (idViviendaU number,
    direccion varchar2(255 byte),
    telefono number,
    NIT_EMPRESA number,
    idHospedaje number not null,
    CONSTRAINT vivienda_universidad_PK PRIMARY KEY (idViviendaU));

    CREATE TABLE HOTEL
    (IdHotel number,
    cantidadHabitaciones number,
    estrellas number,
    idHospedaje number not null,
    NIT_EMPRESA number,
    CONSTRAINT hotel_PK PRIMARY KEY (IdHotel));

    CREATE TABLE HOSTAL
    (IdHostal number,
    apertura TIME,
    cierre TIME,
    idHospedaje number not null,
    NIT_EMPRESA number,
    CONSTRAINT hostal_PK PRIMARY KEY (IdHostal));

ALTER TABLE Cliente
	ADD CONSTRAINT CK_Vinculo 
	CHECK (vinculo IN ('estudiante', 'profesor', 'egresado', 'empleado', 'padre_estudiante', 'profesor_invitado', 'registrado_evento'))
ENABLE;

alter table Cliente
 add constraint CK_identifiacion_cliente
 check (identificacion>=1000000 and identificacion<=9999999999)
ENABLE;
 

 alter table Cliente
 add constraint CK_numero_pago_cliente
 check (numero_pago>=1000000000000000 and numero_pago<=99999999999999999999)
 enable;

--Reglas de la tabla contrato 
ALTER TABLE CONTRATO
   ADD CONSTRAINT FK_idHospedaje FOREIGN KEY (idHospedaje)
      REFERENCES HOSPEDAJE (idHospedaje)
      ON DELETE CASCADE  
;
ALTER TABLE CONTRATO
   ADD CONSTRAINT FK_idCedulaCliente FOREIGN KEY (idCedulaCliente)
        REFERENCES CLIENTE (identificacion)
        ON DELETE CASCADE
;

ALTER TABLE CONTRATO
   ADD CONSTRAINT FK_NIT_empresa FOREIGN KEY (NIT_EMPRESA)
        REFERENCES EMPRESA (NIT)
        ON DELETE CASCADE
;

ALTER TABLE CONTRATO
   ADD CONSTRAINT FK_idPersonaNatural FOREIGN KEY (cedulaPersonaNatural)
        REFERENCES PERSONA_NATURAL (identificacion)
        ON DELETE CASCADE
;



alter table PERSONA_NATURAL
 add constraint CK_identifiacion
 check (identificacion>=1000000 and identificacion<=9999999999)
ENABLE;
 
 alter table PERSONA_NATURAL
 add constraint CK_numero_pago
 check (numeropago>=1000000000000000 and numeropago<=99999999999999999999)
 enable;
 

--reglas vivienda

ALTER TABLE VIVIENDA
   ADD CONSTRAINT FK_idHospedaje_vivienda FOREIGN KEY (id_hospedaje)
      REFERENCES HOSPEDAJE (idHospedaje)
      ON DELETE CASCADE  
;
ALTER TABLE VIVIENDA
   ADD CONSTRAINT FK_idCedulaCliente_vivienda FOREIGN KEY (id_personaNatural)
        REFERENCES PERSONA_NATURAL (identificacion)
        ON DELETE CASCADE
;


--reglas apartamento
ALTER TABLE APARTAMENTO
   ADD CONSTRAINT FK_idHospedaje_apartamento FOREIGN KEY (id_hospedaje)
      REFERENCES HOSPEDAJE (idHospedaje)
      ON DELETE CASCADE  
;
ALTER TABLE APARTAMENTO
   ADD CONSTRAINT FK_idCedulaCliente_apartamento FOREIGN KEY (id_personaNatural)
        REFERENCES PERSONA_NATURAL (identificacion)
        ON DELETE CASCADE
;

ALTER TABLE APARTAMENTO
    ADD CONSTRAINT amoblado_boolean
    CHECK(amoblado = 1 or amoblado = 0);
    


    
ALTER TABLE HABITACION
	ADD CONSTRAINT CK_TipoHabitacion 
	CHECK (tipoHabitacion IN ('SUITE', 'SEMISUITE', 'ESTANDAR', 'COMPARTIDA', 'CASA'))
ENABLE;

ALTER TABLE HABITACION
   ADD CONSTRAINT FK_idHospedaje_habitacion FOREIGN KEY (id_hospedaje)
      REFERENCES HOSPEDAJE (idHospedaje)
      ON DELETE CASCADE  
;
ALTER TABLE HABITACION
   ADD CONSTRAINT FK_idCedulaCliente_habitacion FOREIGN KEY (id_personaNatural)
        REFERENCES PERSONA_NATURAL (identificacion)
	ON DELETE CASCADE
;

ALTER TABLE HABITACION
   ADD CONSTRAINT FK_hostal_habitacion FOREIGN KEY (id_hostal) 
      REFERENCES HOSTAL (idHostal)
      ON DELETE CASCADE  
;
        
ALTER TABLE HABITACION
   ADD CONSTRAINT FK_viviendaU_habitacion FOREIGN KEY (id_vivienda_universitaria)
      REFERENCES VIVIENDA_UNIVERSITARIA (idViviendaU)
      ON DELETE CASCADE  
;
ALTER TABLE HABITACION
   ADD CONSTRAINT FK_idHotel_habitacion FOREIGN KEY (idHotel)
        REFERENCES HOTEL (idHotel);
        
        

        
ALTER TABLE SERVICIO
   ADD CONSTRAINT FK_idhabitacion_servicio FOREIGN KEY (idHabitacion)
        REFERENCES HABITACION (idHabitacion);

ALTER TABLE SERVICIO
   ADD CONSTRAINT FK_idHostal_servicio FOREIGN KEY (idHostal)
        REFERENCES HOSTAL (idHostal);

ALTER TABLE SERVICIO
   ADD CONSTRAINT FK_idHotel_SERVICIO FOREIGN KEY (idHotel)
        REFERENCES HOTEL (idHotel);
        
    

ALTER TABLE EMPRESA
    ADD CONSTRAINT camaraComer_boolean
    CHECK(registradoCamaraDeComercio = 1 or registradoCamaraDeComercio = 0);

ALTER TABLE EMPRESA
    ADD CONSTRAINT independenciaTuris_boolean
    CHECK(registradoIndependenciaTurismo = 1 or registradoIndependenciaTurismo = 0);
ALTER TABLE EMPRESA
    ADD CONSTRAINT web_check
    CHECK(web like 'https://%.co%');
    
 alter table EMPRESA
 add constraint CK_NIT_empresa
 check (NIT>=1000000000 and NIT<=9999999999)
 enable;
 
  alter table EMPRESA
 add constraint CK_numero_pago_empresa
 check (numeroPago>=1000000000000000 and numeroPago<=99999999999999999999)
 enable;
 
 
 
    
ALTER TABLE VIVIENDA_UNIVERSITARIA
   ADD CONSTRAINT FK_NIT_viviendaU FOREIGN KEY (NIT_EMPRESA)
        REFERENCES EMPRESA (NIT)
        ON DELETE CASCADE
;
ALTER TABLE VIVIENDA_UNIVERSITARIA
   ADD CONSTRAINT FK_hospedaje_viviendaU FOREIGN KEY (idHospedaje)
        REFERENCES HOSPEDAJE (idHospedaje)
        ON DELETE CASCADE
;



ALTER TABLE HOTEL
   ADD CONSTRAINT FK_hospedaje_hotel FOREIGN KEY (IDHospedaje)
        REFERENCES HOSPEDAJE (idHospedaje)
        ON DELETE CASCADE
;

ALTER TABLE HOTEL
   ADD CONSTRAINT FK_NIT_hotel FOREIGN KEY (NIT_EMPRESA)
        REFERENCES EMPRESA (NIT)
        ON DELETE CASCADE
;

ALTER TABLE HOTEL
    ADD CONSTRAINT estrellas_regla 
    CHECK(estrellas  >= 0 AND ESTRELLAS <= 5);

ALTER TABLE HOSTAL
   ADD CONSTRAINT FK_hospedaje_hostal FOREIGN KEY (IDHospedaje)
        REFERENCES HOSPEDAJE (idHospedaje)
        ON DELETE CASCADE
;

ALTER TABLE HOSTAL
   ADD CONSTRAINT FK_NIT_hostal FOREIGN KEY (NIT_EMPRESA)
        REFERENCES EMPRESA (NIT)
        ON DELETE CASCADE
;