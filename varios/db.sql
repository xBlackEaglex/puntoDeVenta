-- MySQL Script generated by MySQL Workbench
-- sáb 01 oct 2022 13:12:18
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tiendabd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tiendabd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tiendabd` DEFAULT CHARACTER SET latin1 ;
USE `tiendabd` ;

-- -----------------------------------------------------
-- Table `tiendabd`.`Tienda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendabd`.`Tienda` (
  `idTienda` INT NOT NULL AUTO_INCREMENT,
  `N_tienda` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(45) NOT NULL,
  `Encargado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTienda`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiendabd`.`Ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendabd`.`Ventas` (
  `idVentas` INT NOT NULL AUTO_INCREMENT,
  `Fecha` DATE NOT NULL,
  `Tienda_idTienda` INT NOT NULL,
  PRIMARY KEY (`idVentas`),
  INDEX `fk_Ventas_Tienda_idx` (`Tienda_idTienda` ASC) VISIBLE,
  CONSTRAINT `fk_Ventas_Tienda`
    FOREIGN KEY (`Tienda_idTienda`)
    REFERENCES `tiendabd`.`Tienda` (`idTienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiendabd`.`D_ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendabd`.`D_ventas` (
  `idD_ventas` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(45) NOT NULL,
  `Precio` FLOAT NOT NULL,
  `Cantidad` FLOAT NOT NULL,
  `Sub_total` FLOAT NULL,
  `Total` FLOAT NULL,
  `Ventas_idVentas` INT NOT NULL,
  PRIMARY KEY (`idD_ventas`),
  INDEX `fk_D_ventas_Ventas1_idx` (`Ventas_idVentas` ASC) VISIBLE,
  CONSTRAINT `fk_D_ventas_Ventas1`
    FOREIGN KEY (`Ventas_idVentas`)
    REFERENCES `tiendabd`.`Ventas` (`idVentas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiendabd`.`Proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendabd`.`Proveedor` (
  `idProveedor` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Empresa` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(45) NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiendabd`.`Compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendabd`.`Compras` (
  `idCompras` INT NOT NULL AUTO_INCREMENT,
  `Fechas` DATE NOT NULL,
  `Tienda_idTienda` INT NOT NULL,
  `Proveedor_idProveedor` INT NOT NULL,
  PRIMARY KEY (`idCompras`),
  INDEX `fk_Compras_Tienda1_idx` (`Tienda_idTienda` ASC) VISIBLE,
  INDEX `fk_Compras_Proveedor1_idx` (`Proveedor_idProveedor` ASC) VISIBLE,
  CONSTRAINT `fk_Compras_Tienda1`
    FOREIGN KEY (`Tienda_idTienda`)
    REFERENCES `tiendabd`.`Tienda` (`idTienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compras_Proveedor1`
    FOREIGN KEY (`Proveedor_idProveedor`)
    REFERENCES `tiendabd`.`Proveedor` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiendabd`.`D_compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendabd`.`D_compras` (
  `idD_compras` INT NOT NULL AUTO_INCREMENT,
  `Descripción` VARCHAR(45) NOT NULL,
  `Costo` FLOAT NOT NULL,
  `Cantidad` FLOAT NOT NULL,
  `Importe` FLOAT NULL,
  `Compras_idCompras` INT NOT NULL,
  PRIMARY KEY (`idD_compras`),
  INDEX `fk_D_compras_Compras1_idx` (`Compras_idCompras` ASC) VISIBLE,
  CONSTRAINT `fk_D_compras_Compras1`
    FOREIGN KEY (`Compras_idCompras`)
    REFERENCES `tiendabd`.`Compras` (`idCompras`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiendabd`.`Productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendabd`.`Productos` (
  `idProductos` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(45) NOT NULL,
  `Costo` FLOAT NOT NULL,
  `Precio` FLOAT NOT NULL,
  `Existencia` FLOAT NULL,
  `Proveedor_idProveedor` INT NOT NULL,
  PRIMARY KEY (`idProductos`),
  INDEX `fk_Productos_Proveedor1_idx` (`Proveedor_idProveedor` ASC) VISIBLE,
  CONSTRAINT `fk_Productos_Proveedor1`
    FOREIGN KEY (`Proveedor_idProveedor`)
    REFERENCES `tiendabd`.`Proveedor` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
