-- Creación de tablas
CREATE TABLE Alumno (
    id_alumno SERIAL PRIMARY KEY,
    dni VARCHAR(20) UNIQUE,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE Carrera (
    id_carrera SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    facultad VARCHAR(100)
);

CREATE TABLE HistorialAcademico (
    id_historial SERIAL PRIMARY KEY,
    id_alumno INT,
    id_carrera INT,
    version_plan VARCHAR(20),
    FOREIGN KEY (id_alumno) REFERENCES Alumno(id_alumno),
    FOREIGN KEY (id_carrera) REFERENCES Carrera(id_carrera)
);

CREATE TABLE Materia (
    id_materia SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    anio INT
);

CREATE TABLE Correlatividad (
    id_correlatividad SERIAL PRIMARY KEY,
    id_materia INT NOT NULL,
    id_materia_requerida INT NOT NULL,
    FOREIGN KEY (id_materia) REFERENCES Materia(id_materia),
    FOREIGN KEY (id_materia_requerida) REFERENCES Materia(id_materia)
);

CREATE TABLE Docente (
    id_docente SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL
);

CREATE TABLE Comision (
    id_comision SERIAL PRIMARY KEY,
    id_materia INT NOT NULL,
    id_docente INT NOT NULL,
    FOREIGN KEY (id_materia) REFERENCES Materia(id_materia),
    FOREIGN KEY (id_docente) REFERENCES Docente(id_docente)
);

CREATE TABLE Examen (
    id_examen SERIAL PRIMARY KEY,
    id_materia INT NOT NULL,
    fecha DATE,
    cupo INT,
    FOREIGN KEY (id_materia) REFERENCES Materia(id_materia)
);

CREATE TABLE InscripcionExamen (
    id_inscripcion SERIAL PRIMARY KEY,
    id_alumno INT NOT NULL,
    id_examen INT NOT NULL,
    fecha_inscripcion DATE,
    FOREIGN KEY (id_alumno) REFERENCES Alumno(id_alumno),
    FOREIGN KEY (id_examen) REFERENCES Examen(id_examen)
);

CREATE TABLE Pago (
    id_pago SERIAL PRIMARY KEY,
    id_alumno INT,
    monto DECIMAL(10,2),
    fecha_pago DATE,
    estado VARCHAR(50),
    FOREIGN KEY (id_alumno) REFERENCES Alumno(id_alumno)
);

/* Inserción de Registros */
INSERT INTO Alumno (dni, nombre, apellido, email)
VALUES ('40111222', 'Juan', 'Perez', 'juan@gmail.com');

/* Consulta de Registros */
SELECT * FROM Alumno;

/* Borrado de Registros */
DELETE FROM Alumno
WHERE id_alumno = 1;