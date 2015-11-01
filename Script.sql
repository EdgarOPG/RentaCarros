

CREATE DATABASE RENTA;

USE RENTA;

DROP TABLE IF EXISTS FACTURAS;

DROP TABLE IF EXISTS VEHICULO;

DROP TABLE IF EXISTS CLIENTES;

DROP TABLE IF EXISTS EMPLEADOS;

DROP TABLE IF EXISTS USUARIOS;

CREATE TABLE EMPLEADOS
(
	ID_EMPLEADO          INTEGER AUTO_INCREMENT,
    USUARIO				 VARCHAR(15) NULL,
    CONTRASENIA			 VARCHAR(20) NULL,
	NOMBRE               VARCHAR(40) NULL,
	FECHA_NACIMIENTO     DATE NOT NULL,
	DIRECCION            VARCHAR(50) NULL,
	EMAIL                VARCHAR(40) NULL,
	TELEFONO             VARCHAR(15) NULL,
	TELEFONO_CASA        VARCHAR(20) NULL,
	ROL_DEFINITION		 BOOLEAN NULL,
	PRIMARY KEY (ID_EMPLEADO)
);

CREATE TABLE CLIENTES (
    ID_CLIENTE INTEGER AUTO_INCREMENT,
    NOMBRE VARCHAR(40) NULL,
    TELEFONO VARCHAR(15) NULL,
    DIRECCION VARCHAR(50) NULL,
    CIUDAD VARCHAR(15) NULL,
    FECHA_NACIMIENTO DATE NULL,
    REFERENCIA VARCHAR(50) NULL,
    NUMERO_DE_LICENCIA VARCHAR(30) NULL,
    PRIMARY KEY (ID_CLIENTE)
);

CREATE TABLE VEHICULO (
    ID_VEHICULO INTEGER AUTO_INCREMENT,
    MARCA VARCHAR(30) NULL,
    MODELO VARCHAR(30) NULL,
    COLOR VARCHAR(20) NULL,
    TRANSMISION VARCHAR(20) NULL,
    PRECIO_RENTA FLOAT NULL,
    TANQUE FLOAT NULL,
    ESTADO BOOLEAN NULL,
    PRIMARY KEY (ID_VEHICULO)
);

CREATE TABLE FACTURAS (
    ID_FACTURA INTEGER NOT NULL AUTO_INCREMENT,
    ID_EMPLEADO INTEGER NOT NULL,
    ID_CLIENTE INTEGER NOT NULL,
    ID_VEHICULO INTEGER NOT NULL,
    FECHA DATE NULL,
    FECHA_ENTREGA DATE NULL,
    PRIMARY KEY (ID_FACTURA),
    CONSTRAINT R_1 FOREIGN KEY (ID_EMPLEADO)
        REFERENCES EMPLEADOS (ID_EMPLEADO),
    CONSTRAINT R_2 FOREIGN KEY (ID_CLIENTE)
        REFERENCES CLIENTES (ID_CLIENTE),
    CONSTRAINT R_3 FOREIGN KEY (ID_VEHICULO)
        REFERENCES VEHICULO (ID_VEHICULO)
);