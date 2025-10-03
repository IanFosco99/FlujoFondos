-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-08-2025 a las 00:27:22
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `flujofondos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cheque`
--

CREATE TABLE `cheque` (
  `id_cheque` bigint(20) NOT NULL,
  `nro_cheque` int(14) NOT NULL,
  `importe_cheque` decimal(16,2) NOT NULL,
  `fecha_cobro_cheque` date NOT NULL,
  `tipo_cheque` varchar(10) NOT NULL,
  `estado_cheque` int(1) NOT NULL DEFAULT 0 COMMENT 'cobrado 1 / por cobrar 0',
  `observacion_cheque` varchar(150) DEFAULT NULL,
  `fecha_entrega_cheque` date NOT NULL,
  `titular_cheque` bigint(20) DEFAULT NULL COMMENT 'de donde viene(id_cliente_proveedor)',
  `titular_destino` bigint(20) DEFAULT NULL COMMENT 'hacia donde va(id_cliente_proveedor)',
  `uso_cheque` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_proveedores`
--

CREATE TABLE `cliente_proveedores` (
  `id_cliente_proveedor` bigint(20) NOT NULL,
  `nom_razon_social` varchar(200) DEFAULT NULL,
  `dni_cuit` int(11) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `tipo_cliente_proveedor` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE `cuentas` (
  `id_cuenta` bigint(20) NOT NULL,
  `cod_concepto` varchar(50) DEFAULT NULL,
  `nom_concepto` varchar(100) DEFAULT NULL,
  `clas_concepto` varchar(50) DEFAULT NULL,
  `id_movimiento` bigint(20) DEFAULT NULL,
  `ingreso` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flujos_mov`
--

CREATE TABLE `flujos_mov` (
  `id_flujo_mov` bigint(20) NOT NULL,
  `fecha_mov` date NOT NULL,
  `id_movimiento` bigint(20) NOT NULL DEFAULT 0,
  `id_cuenta` bigint(20) NOT NULL DEFAULT 0,
  `importe` decimal(16,2) NOT NULL DEFAULT 0.00,
  `observaciones_mov` varchar(200) NOT NULL DEFAULT '0',
  `id_cheque` bigint(20) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `id_movimiento` bigint(20) NOT NULL,
  `desc_movimiento` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente_proveedores`
--
ALTER TABLE `cliente_proveedores`
  ADD PRIMARY KEY (`id_cliente_proveedor`);

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`id_cuenta`),
  ADD KEY `id_movimiento` (`id_movimiento`);

--
-- Indices de la tabla `flujos_mov`
--
ALTER TABLE `flujos_mov`
  ADD PRIMARY KEY (`id_flujo_mov`),
  ADD KEY `id_movimiento` (`id_movimiento`),
  ADD KEY `id_cuenta` (`id_cuenta`),
  ADD KEY `id_cheque` (`id_cheque`);

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`id_movimiento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente_proveedores`
--
ALTER TABLE `cliente_proveedores`
  MODIFY `id_cliente_proveedor` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  MODIFY `id_cuenta` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `flujos_mov`
--
ALTER TABLE `flujos_mov`
  MODIFY `id_flujo_mov` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `id_movimiento` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
