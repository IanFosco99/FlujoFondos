-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-12-2025 a las 20:12:28
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
-- Base de datos: `flujo_fondos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cheque_propio`
--

CREATE TABLE `cheque_propio` (
  `id_cheque` bigint(20) NOT NULL,
  `nro_cheque` bigint(14) NOT NULL,
  `importe_cheque` decimal(16,2) NOT NULL,
  `fecha_cobro_cheque` date NOT NULL,
  `estado_cheque` int(1) NOT NULL DEFAULT 0 COMMENT 'cobrado 1 / por cobrar 0',
  `observacion_cheque` varchar(150) DEFAULT NULL,
  `titular_destino` bigint(20) DEFAULT NULL COMMENT 'hacia donde va(id_cliente_proveedor)',
  `uso_cheque` varchar(10) DEFAULT NULL,
  `id_cuenta_salida` bigint(20) NOT NULL,
  `fecha_entrega_cheque` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `cheque_propio`
--

INSERT INTO `cheque_propio` (`id_cheque`, `nro_cheque`, `importe_cheque`, `fecha_cobro_cheque`, `estado_cheque`, `observacion_cheque`, `titular_destino`, `uso_cheque`, `id_cuenta_salida`, `fecha_entrega_cheque`) VALUES
(1, 123123, 120000.00, '2025-10-22', 1, '', 1, '', 1, '2025-11-22'),
(2, 1234, 2800.00, '2025-10-31', 1, 'venta contado', 2, '', 1, '2025-11-22'),
(5, 122, 2000.00, '2025-11-16', 1, '', 3, NULL, 1, '2025-11-28'),
(6, 22, 25000.00, '2025-11-21', 1, 'venta', 3, '', 1, '2025-11-28'),
(7, 150600, 870000.00, '2025-12-11', 1, 'Pago de Materiales', 1, NULL, 3, '2025-12-14'),
(11, 500600, 3500000.00, '2025-12-11', 1, 'Pago de Sueldos', 2, NULL, 4, '2025-12-10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cheque_tercero`
--

CREATE TABLE `cheque_tercero` (
  `id_cheque` bigint(20) NOT NULL,
  `nro_cheque` bigint(14) NOT NULL,
  `importe_cheque` decimal(16,2) NOT NULL,
  `fecha_cobro_cheque` date NOT NULL,
  `estado_cheque` int(1) NOT NULL DEFAULT 0 COMMENT 'cobrado 1 / por cobrar 0',
  `observacion_cheque` varchar(150) DEFAULT NULL,
  `fecha_entrega_cheque` date DEFAULT NULL,
  `titular_cheque` bigint(20) NOT NULL COMMENT 'de donde viene(id_cliente_proveedor)',
  `titular_destino` bigint(20) DEFAULT NULL COMMENT 'hacia donde va(id_cliente_proveedor)',
  `uso_cheque` varchar(10) DEFAULT NULL,
  `id_cuenta_entrada` bigint(20) NOT NULL,
  `id_cuenta_salida` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `cheque_tercero`
--

INSERT INTO `cheque_tercero` (`id_cheque`, `nro_cheque`, `importe_cheque`, `fecha_cobro_cheque`, `estado_cheque`, `observacion_cheque`, `fecha_entrega_cheque`, `titular_cheque`, `titular_destino`, `uso_cheque`, `id_cuenta_entrada`, `id_cuenta_salida`) VALUES
(3, 2520, 289000.00, '2025-12-15', 1, 'Cobro Cliente Perez Juan', '2025-12-14', 1, 3, NULL, 2, 6),
(4, 3558, 750000.00, '2025-12-17', 1, 'Cobro Deuda 2025', '2025-12-14', 3, 4, NULL, 2, 4);

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
  `tipo_cliente_proveedor` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `cliente_proveedores`
--

INSERT INTO `cliente_proveedores` (`id_cliente_proveedor`, `nom_razon_social`, `dni_cuit`, `telefono`, `email`, `tipo_cliente_proveedor`) VALUES
(1, 'Juan Perez', 1234565432, '123132133', 'momn@gmail.com', 'Proveedor'),
(2, 'Jose Rodriguez', 123123213, '2131231231', 'sadad@sada.com', 'Cliente'),
(3, 'HoodS Burguer', 46042631, '03476600093', 'Augusto11805@gmail.com', 'Cliente'),
(4, 'Sol Ramirez', 44178222, '3476355560', 'solramirez835@gmail.com', 'Proveedor');

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

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`id_cuenta`, `cod_concepto`, `nom_concepto`, `clas_concepto`, `id_movimiento`, `ingreso`) VALUES
(1, '1.01', 'Venta de Contado', 'Operativo', 1, '1'),
(2, '1.02', 'Ventas en Cta.Cte.', 'Operativo', 2, '1'),
(3, '1.03', 'Proveedores', 'Operativo', 3, '0'),
(4, '1.04', 'Sueldos y Cs. Sociales', 'Operativo', 2, '0'),
(6, '2.01', 'Inversion en Bienes de Uso', 'Inversion', 4, '0'),
(7, '3.01', 'Prestamos Recibidos', 'Financiacion', 1, '1');

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
  `id_cheque` bigint(20) NOT NULL DEFAULT 0,
  `id_cheque_tercero` bigint(20) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `flujos_mov`
--

INSERT INTO `flujos_mov` (`id_flujo_mov`, `fecha_mov`, `id_movimiento`, `id_cuenta`, `importe`, `observaciones_mov`, `id_cheque`, `id_cheque_tercero`) VALUES
(1, '2025-12-10', 1, 1, 158000.00, 'Venta de Mercaderias', 0, 0),
(2, '2025-12-10', 2, 2, 250000.00, 'Mercaderia en CtaCte', 0, 0),
(4, '2025-12-10', 1, 7, 500000.00, 'MUFC', 0, 0),
(5, '2025-12-11', 4, 3, -356000.00, 'Impuestos diciembre', 0, 0),
(6, '2025-12-10', 4, 3, 875000.00, 'Compra AA', 0, 0),
(10, '2025-12-14', 4, 2, 289000.00, '-', 0, 3),
(11, '2025-12-14', 4, 6, -289000.00, '-', 0, 3),
(13, '2025-12-14', 3, 3, -870000.00, 'Salida de cheque propio', 7, 0),
(14, '2025-12-14', 2, 2, 750000.00, '-', 0, 4),
(15, '2025-12-14', 2, 4, -750000.00, '-', 0, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `id_movimiento` bigint(20) NOT NULL,
  `desc_movimiento` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`id_movimiento`, `desc_movimiento`) VALUES
(1, 'Caja'),
(2, 'Banco El Tornillo Cta Cte'),
(3, 'Cheques a Cobrar'),
(4, 'Cheques Emitidos');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cheque_propio`
--
ALTER TABLE `cheque_propio`
  ADD PRIMARY KEY (`id_cheque`);

--
-- Indices de la tabla `cheque_tercero`
--
ALTER TABLE `cheque_tercero`
  ADD PRIMARY KEY (`id_cheque`);

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
  ADD KEY `id_cheque` (`id_cheque`),
  ADD KEY `id_cheque_tercero` (`id_cheque_tercero`);

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`id_movimiento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cheque_propio`
--
ALTER TABLE `cheque_propio`
  MODIFY `id_cheque` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `cheque_tercero`
--
ALTER TABLE `cheque_tercero`
  MODIFY `id_cheque` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `cliente_proveedores`
--
ALTER TABLE `cliente_proveedores`
  MODIFY `id_cliente_proveedor` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  MODIFY `id_cuenta` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `flujos_mov`
--
ALTER TABLE `flujos_mov`
  MODIFY `id_flujo_mov` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `id_movimiento` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
