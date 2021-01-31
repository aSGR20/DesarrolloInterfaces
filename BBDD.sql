-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-01-2021 a las 18:24:24
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `desarrollodeinterfaces`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `DNI_Cliente` varchar(15) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Teléfono` int(9) NOT NULL,
  `Domicilio` varchar(45) NOT NULL,
  `Correo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`DNI_Cliente`, `Nombre`, `Apellidos`, `Teléfono`, `Domicilio`, `Correo`) VALUES
('123456788G', 'Pepe', 'Fernandez', 657893240, 'wasd', NULL),
('12345679K', 'Pepe', 'Ortega', 618942341, 'Frederic', NULL),
('23568790F', 'Juan', 'Ortega', 123456789, 'HolaQTal', NULL),
('47898923T', 'Ejemplo', 'Ejémpleza', 232423454, 'aa casaaae', 'ejemplo@ejemplo.com'),
('66666666S', 'Satanásaa', 'Avernowasd', 123456789, 'Hades', 'infierno.inc@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mecánico`
--

CREATE TABLE `mecánico` (
  `DNI_Usuario` varchar(15) NOT NULL,
  `Es_Jefe` tinyint(4) NOT NULL,
  `Especialidad` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mecánico`
--

INSERT INTO `mecánico` (`DNI_Usuario`, `Es_Jefe`, `Especialidad`) VALUES
('48593066B', 1, 'Lechuzas pardas'),
('99948352R', 0, 'Altramuces');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propuestas`
--

CREATE TABLE `propuestas` (
  `DNI_Cliente` varchar(15) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Marca` varchar(45) NOT NULL,
  `Modelo` varchar(45) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  `Fecha_Entrada` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `propuestas`
--

INSERT INTO `propuestas` (`DNI_Cliente`, `Nombre`, `Marca`, `Modelo`, `Tipo`, `Fecha_Entrada`) VALUES
('[66666666S', 'Satanásaa', 'Ford', 'Fiesta', 'Coche', '4/7/2020'),
('47898923T', 'Ejemplo', 'Rome', 'Nissan', 'Coche', '12/03/2020'),
('12345679K', 'Pepe', 'Ford', 'Fiesta', 'Coche', '4/7/2020'),
('66666666S', 'Satanásaa', 'Citroen', 'C3', 'Coche', '3/8/2020'),
('23568790F', 'Juan', 'Ford', 'Focus', 'Coche', '02/12/2020'),
('123456788G', 'Pepe', 'Citroen', 'C3', 'Coche', '3/8/2020'),
('12345679K', 'Pepe', 'Ford', 'Focus', 'Coche', '02/12/2020'),
('12345679K', 'Pepe', 'Rome', 'Nissan', 'Coche', '12/03/2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reparación`
--

CREATE TABLE `reparación` (
  `NumIncidencia` int(11) NOT NULL,
  `DNI_Cliente` varchar(15) NOT NULL,
  `DNI_Usuario` varchar(15) DEFAULT NULL,
  `Problema` varchar(45) NOT NULL,
  `Coste` int(11) DEFAULT NULL,
  `Tiempo_Estimado` varchar(45) NOT NULL,
  `Piezas` varchar(45) DEFAULT NULL,
  `Teléfono` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `DNI_Usuario` varchar(15) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Contraseña` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `NUSS` varchar(45) NOT NULL,
  `SueldoBase` int(11) NOT NULL,
  `Correo` varchar(45) DEFAULT NULL,
  `Profesión` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`DNI_Usuario`, `Usuario`, `Contraseña`, `Nombre`, `Apellidos`, `NUSS`, `SueldoBase`, `Correo`, `Profesión`) VALUES
('35253647T', 'venta', 'usuario', 'Cristina', 'Ferrer', '8987987436424', 1300, 'cookiesaregreat@yahoo.com', 'Ventas'),
('48593066B', 'elMakina', 'PaNdA', 'Daniel', 'Ramírez', '5728492048593', 1200, 'correo@gmail.com', 'Mecánico'),
('57394853G', 'jefazo', '1234', 'Pepe', 'Viyuelas', '574839402', 1500, 'pepe@pepe.com', 'Jefe'),
('99948352R', 'uSUARIO', '1234', 'Roque', 'Roca', '6768768768', 1100, 'rocaroque@gmail.com', 'Mecánico_Jefe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehículo`
--

CREATE TABLE `vehículo` (
  `Num_Serial` int(11) NOT NULL,
  `Modelo` varchar(45) NOT NULL,
  `Marca` varchar(45) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  `Precio` int(11) NOT NULL,
  `Fecha_Entrada` varchar(10) NOT NULL,
  `Anyo` int(4) NOT NULL,
  `Kilometros` int(10) NOT NULL,
  `Combustible` varchar(45) NOT NULL,
  `Inf_Adicional` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vehículo`
--

INSERT INTO `vehículo` (`Num_Serial`, `Modelo`, `Marca`, `Tipo`, `Precio`, `Fecha_Entrada`, `Anyo`, `Kilometros`, `Combustible`, `Inf_Adicional`) VALUES
(1, 'Focus', 'Ford', 'Coche', 16000, '02/12/2020', 2, 23000, 'Gasolina', NULL),
(123, 'wasd', 'wasd', 'asd', 123, '02/12/2020', 0, 0, '', NULL),
(1234, 'Nissan', 'Rome', 'Coche', 90, '12/03/2020', 0, 0, '', NULL),
(4567, 'kill', 'metro', 'Coche', 90000, '03/12/2020', 2, 23000, 'Diésel', NULL),
(4829382, 'C3', 'Citroen', 'Coche', 7000, '3/8/2020', 0, 0, '', 'hola'),
(48920903, 'Honda', 'Honda', 'Moto', 2000, '12/3/2020', 0, 0, '', 'Lleva mucho tiempo sin venderse'),
(83495092, 'Fiesta', 'Ford', 'Coche', 5000, '4/7/2020', 0, 0, '', 'Está un poco cascado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `Num_Serial` int(11) NOT NULL,
  `DNI_Cliente` varchar(15) NOT NULL,
  `DNI_Usuario` varchar(15) NOT NULL,
  `Beneficios` int(11) NOT NULL,
  `Plazo` varchar(45) DEFAULT NULL,
  `Fecha` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`Num_Serial`, `DNI_Cliente`, `DNI_Usuario`, `Beneficios`, `Plazo`, `Fecha`) VALUES
(1, '66666666S', '35253647t', 16000, '80 dias', '16/1/2021'),
(123, '66666666S', '35253647t', 123, '20 días', '16/1/2021'),
(1234, '12345679K', '35253647t', 90, '20 días', '19/1/2021'),
(1234, '66666666S', '35253647t', 90, '', '20/1/2021'),
(4567, '12345679K', '35253647t', 90000, '0 dias', '19/1/2021'),
(48920903, '47898923T', '35253647t', 2000, '23 dias', '19/1/2021'),
(83495092, '47898923T', '35253647T', 5000, '40 días', '18/1/2021'),
(83495092, '66666666S', '35253647t', 5000, '', '17/1/2021');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`DNI_Cliente`);

--
-- Indices de la tabla `mecánico`
--
ALTER TABLE `mecánico`
  ADD PRIMARY KEY (`DNI_Usuario`);

--
-- Indices de la tabla `reparación`
--
ALTER TABLE `reparación`
  ADD PRIMARY KEY (`NumIncidencia`),
  ADD KEY `DNI_Cliente3` (`DNI_Cliente`),
  ADD KEY `DNI_Usuario3` (`DNI_Usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`DNI_Usuario`),
  ADD UNIQUE KEY `Usuario_UNIQUE` (`Usuario`),
  ADD UNIQUE KEY `NUSS_UNIQUE` (`NUSS`),
  ADD UNIQUE KEY `Correo_UNIQUE` (`Correo`);

--
-- Indices de la tabla `vehículo`
--
ALTER TABLE `vehículo`
  ADD PRIMARY KEY (`Num_Serial`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`Num_Serial`,`DNI_Cliente`,`DNI_Usuario`),
  ADD KEY `DNI_Cliente_idx` (`DNI_Cliente`),
  ADD KEY `DNI_Usuario_idx` (`DNI_Usuario`),
  ADD KEY `DNI_Cliente2_idx` (`DNI_Cliente`),
  ADD KEY `DNI_Usuario2_idx` (`DNI_Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `reparación`
--
ALTER TABLE `reparación`
  MODIFY `NumIncidencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `mecánico`
--
ALTER TABLE `mecánico`
  ADD CONSTRAINT `DNI_Usuario` FOREIGN KEY (`DNI_Usuario`) REFERENCES `usuario` (`DNI_Usuario`);

--
-- Filtros para la tabla `reparación`
--
ALTER TABLE `reparación`
  ADD CONSTRAINT `DNI_Cliente3` FOREIGN KEY (`DNI_Cliente`) REFERENCES `cliente` (`DNI_Cliente`),
  ADD CONSTRAINT `DNI_Usuario3` FOREIGN KEY (`DNI_Usuario`) REFERENCES `usuario` (`DNI_Usuario`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `DNI_Cliente2` FOREIGN KEY (`DNI_Cliente`) REFERENCES `cliente` (`DNI_Cliente`),
  ADD CONSTRAINT `DNI_Usuario2` FOREIGN KEY (`DNI_Usuario`) REFERENCES `usuario` (`DNI_Usuario`),
  ADD CONSTRAINT `Num_Serial` FOREIGN KEY (`Num_Serial`) REFERENCES `vehículo` (`Num_Serial`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
