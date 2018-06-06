-- MySQL Workbench Synchronization
-- Generated: 2018-06-05 22:13
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Melina Carniel

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `dbescola` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `dbescola`.`Escola` (
  `idEscola` INT(11) NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL DEFAULT NULL,
  `Endereço` VARCHAR(45) NULL DEFAULT NULL,
  `Telefone` VARCHAR(45) NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idEscola`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `dbescola`.`Cursos` (
  `idCursos` INT(11) NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL DEFAULT NULL,
  `Descrição` VARCHAR(45) NULL DEFAULT NULL,
  `Escola_id` INT(11) NOT NULL,
  `Alunos_id` INT(11) NOT NULL,
  `Início` DATE NULL DEFAULT NULL,
  `Término` DATE NULL DEFAULT NULL,
  `Período` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCursos`, `Escola_id`, `Alunos_id`),
  INDEX `fk_Cursos_Escola_idx` (`Escola_id` ASC),
  INDEX `fk_Cursos_Alunos1_idx` (`Alunos_id` ASC),
  CONSTRAINT `fk_Cursos_Escola`
    FOREIGN KEY (`Escola_id`)
    REFERENCES `dbescola`.`Escola` (`idEscola`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cursos_Alunos1`
    FOREIGN KEY (`Alunos_id`)
    REFERENCES `dbescola`.`Alunos` (`idAlunos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `dbescola`.`Alunos` (
  `idAlunos` INT(11) NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `Cursos_id` INT(11) NOT NULL,
  PRIMARY KEY (`idAlunos`, `Cursos_id`),
  INDEX `fk_Alunos_Cursos1_idx` (`Cursos_id` ASC),
  CONSTRAINT `fk_Alunos_Cursos1`
    FOREIGN KEY (`Cursos_id`)
    REFERENCES `dbescola`.`Cursos` (`idCursos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `dbescola`.`Nota` (
  `idNota` INT(11) NOT NULL AUTO_INCREMENT,
  `Alunos_id` INT(11) NOT NULL,
  `Cursos_id` INT(11) NOT NULL,
  `Nota` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`idNota`, `Alunos_id`, `Cursos_id`),
  INDEX `fk_Nota_Alunos1_idx` (`Alunos_id` ASC),
  INDEX `fk_Nota_Cursos1_idx` (`Cursos_id` ASC),
  CONSTRAINT `fk_Nota_Alunos1`
    FOREIGN KEY (`Alunos_id`)
    REFERENCES `dbescola`.`Alunos` (`idAlunos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Nota_Cursos1`
    FOREIGN KEY (`Cursos_id`)
    REFERENCES `dbescola`.`Cursos` (`idCursos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
