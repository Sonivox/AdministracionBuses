-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-06-2018 a las 05:55:42
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `datosbuses`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `buses`
--

CREATE TABLE `buses` (
  `parada` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codigo` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `tiempo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `precio` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `viajes` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `inicio` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `final` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `color` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `empresario` varchar(150) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `buses`
--

INSERT INTO `buses` (`parada`, `codigo`, `nombre`, `tiempo`, `precio`, `tipo`, `viajes`, `inicio`, `final`, `color`, `empresario`) VALUES
('PARQUE', 'MB002', 'ruta 2', '55 minutos', '0.25', 'Microbús', '8', '5:05 am', '6:05 pm', '#3366ff', 'Juan Perez'),
('UES', 'B0090F', 'Ruta 90 F', '1 hora 29 minutos', '0.20', 'Bus', '7', '5:00 am', '6:00 am', '#ff0000', 'Hernandez Rivera');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `id_usuario` int(11) DEFAULT NULL,
  `clave` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` varchar(25) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`id_usuario`, `clave`, `tipo`) VALUES
(6689, '7064', 'Usuario'),
(7370, '9980', 'Usuario'),
(8601, '3478', 'Usuario'),
(6792, '6648', 'Usuario'),
(4455, '809', 'Usuario'),
(469, '9920', 'Usuario'),
(589, '4934', 'Usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paradas`
--

CREATE TABLE `paradas` (
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `paradas`
--

INSERT INTO `paradas` (`nombre`) VALUES
('METROCENTRO'),
('UES'),
('UNIVO'),
('CENTRO'),
('PARQUE'),
('WOW'),
('WOWX2'),
('WOWX3'),
('XDDDD'),
(';C'),
('HOLA'),
('HOLAX2'),
('HELLO'),
('IHHH'),
(';VVV'),
('ASDASDASDAS'),
('DASDNASD'),
('W'),
('A'),
('ASDAS'),
('AEW'),
('B');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro`
--

CREATE TABLE `registro` (
  `ID` int(5) NOT NULL,
  `evento` varchar(300) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `registro`
--

INSERT INTO `registro` (`ID`, `evento`) VALUES
(1, 'Añadida Parada: CENTRO'),
(2, 'Añadida Parada: PARQUE'),
(3, 'Añadido Microbús Ruta: Ruta 2 Costo: 0.25 En la Parada: PARQUE'),
(4, 'Modificado Bus: MB002a los siguientes valores Ruta: Ruta 3'),
(5, 'Modificado Bus: MB002a los siguientes valores Ruta: Ruta 33'),
(6, 'Modificado Bus: MB002a los siguientes valores Ruta: Ruta 333'),
(7, 'Modificado Bus: MB002a los siguientes valores Ruta: Ruta 20'),
(8, 'Parada Añadida: WOW'),
(9, 'Parada Añadida: WOWX2'),
(10, 'Parada Añadida: WOWX3'),
(11, 'Parada Añadida: XDDDD'),
(12, 'Parada Añadida: ;C'),
(13, 'Parada Añadida: HOLA'),
(14, 'Parada Añadida: HOLAX2'),
(15, 'Parada Añadida: HELLO'),
(16, 'Modificado Bus: MB002a los siguientes valores Ruta: Ruta 223123123'),
(17, 'Modificado Bus: MB002a los siguientes valores Ruta: Ruta 223'),
(18, 'Modificado Bus: MB002a los siguientes valores Ruta: Ruta 222'),
(19, 'Parada Añadida: IHHH'),
(20, 'Parada Añadida: ;VVV'),
(21, 'Parada Añadida: ASDASDASDAS'),
(22, 'Parada Añadida: DASDNASD'),
(23, 'Modificado Bus: MB002a los siguientes valores Ruta: ruta 222'),
(24, 'Parada Añadida: W'),
(25, 'Modificado Bus: MB002a los siguientes valores Ruta: ruta 2'),
(26, 'Parada Añadida: A'),
(27, 'Parada Añadida: ASDAS'),
(28, 'Parada Añadida: AEW'),
(29, 'Parada Añadida: B'),
(30, 'Añadido Bus Ruta: Ruta 90 F Costo: 0.20 En la Parada: UES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(150) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`) VALUES
(469, 'Roberto Maltez'),
(589, 'Ronald Rodriguez'),
(3812, 'Albery'),
(4455, 'Juan Perez'),
(6689, 'Arteaga'),
(6792, 'Bryan Alexander'),
(7370, 'Albery Arteaga Martinez'),
(8601, 'Irvin Isaac Ayala Garcia');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `registro`
--
ALTER TABLE `registro`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
