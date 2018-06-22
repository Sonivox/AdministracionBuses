-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-06-2018 a las 15:43:14
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `buses`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `buses`
--

CREATE TABLE `buses` (
  `parada` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `tiempo` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `precio` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `viajes` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `inicio` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `final` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `color` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `buses`
--

INSERT INTO `buses` (`parada`, `nombre`, `tiempo`, `precio`, `tipo`, `viajes`, `inicio`, `final`, `color`) VALUES
(NULL, '90 F', '10', '0.20', '', '', '', '', NULL),
(NULL, '90 FA', '12', '0.20', '', '', '', '', NULL),
(NULL, 'Ruta 2', '10', '0.25', '', '', '', '', NULL),
(NULL, 'Ruta 11', '10', '0.25', '', '', '', '', NULL),
('UGB', 'Ruta 11', '10', '0.25', '', '', '', '', NULL),
('UGB', 'Ruta 2', '10', '0.25', '', '', '', '', NULL),
('UGB', '90 F', '10', '0.20', '', '', '', '', NULL),
('METROCENTRO', '90 F', '10', '0.20', '', '', '', '', NULL),
('METROCENTRO', '90 FA', '12', '0.20', '', '', '', '', NULL),
('METROCENTRO', 'Ruta 11', '10', '0.25', '', '', '', '', NULL),
(NULL, 'Ruta 8', '1:41:00', '0.25', 'Microbús', '7', '5:00 am', '6:00 pm', '#ff0000'),
(NULL, 'Ruta 3', '1:30:00', '0.25', 'Microbús', '9', '5:00 am', '6:00 pm', '#660099'),
(NULL, 'Ruta 90', '2:00:00', '0.20', 'Bus', '7', '5:05 am', '4:45 pm', '#cc3300'),
(NULL, 'Ruta 88', '1:40:00', '0.25', 'Bus', '8', '5:25 am', '6:15 pm', '#33ffff'),
('METROCENTRO', 'Ruta 5', '1:00:00', '0.25', 'Microbús', '7', '5:00 am', '5:00 pm', '#ff3333'),
('PARQUE', 'Ruta 11', '2:00:00', '0.25', 'Microbús', '6', '5:00 am', '6:15 pm', '#ff33'),
('UES', 'asdfg', '', '', 'Bus', '', ' am', ' am', ''),
('UES', '90F', '1:18:00', '0.25', 'Bus', '2|', '10:00:00 am', '10:00:00 am', '#330066'),
('UES', '90f', '12:00:00', '0.25', 'Bus', '12', '12:00:00 am', '12:00:00 am', '#ffffff'),
('UES', '90f', '12:00:22', '0.25', 'Bus', '12', '12:00:00 am', '12:00:22 am', '#333300'),
('UES', '12', '12:00:00', '0.|25', 'Bus', '12', '12:00:00 am', '12:00:00 am', '#ccff00'),
('UES', '12', '12:00:00', '0.25', 'Bus', '12', '12:00:00 am', '12:00:00 am', '#33ff00'),
('UES', '11', '12:00:00', '0.25', 'Bus', '12', '12:00:00 am', '12:00:00 am', '#33ff33'),
('UES', '12', '12:00:00', '0.25', 'Bus', '12', '12:00:00 am', '12:00:00 am', '#ff33cc'),
('UES', '1234', '12:00:00', '0.25', 'Bus', '12', '12:00:00 am', '12:00:00 am', '#ff33cc'),
('UES', '90F', '1:40', '0.25|', 'Bus', '12', '11:00:00 am', '12:00:00 am', '#66ff'),
('UES', '90F', '1:40', '0.25|', 'Bus', '12', '11:00:00 am', '12:00:00 am', '#66ff');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paradas`
--

CREATE TABLE `paradas` (
  `nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `paradas`
--

INSERT INTO `paradas` (`nombre`) VALUES
('UES'),
('METROCENTRO'),
('PARQUE'),
('UES'),
('UNIVO'),
('WEA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registros`
--

CREATE TABLE `registros` (
  `ID` int(5) NOT NULL,
  `evento` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `registros`
--

INSERT INTO `registros` (`ID`, `evento`) VALUES
(1, '12'),
(2, '1234'),
(3, 'Añadido Bus Ruta: 90F Costo: 0.25| En la Parada: UES'),
(4, 'Añadida Parada: WEA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) DEFAULT NULL,
  `clave` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `clave`, `tipo`) VALUES
(1, '1122', 'Administrador');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `registros`
--
ALTER TABLE `registros`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD KEY `id_usuario` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `registros`
--
ALTER TABLE `registros`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
