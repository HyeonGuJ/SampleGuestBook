CREATE SCHEMA `guestbook` ;

CREATE TABLE `guestbook`.`message` (
  `idMessage` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `date` DATETIME NOT NULL,
  `modifiedDate` DATETIME NULL,
  `text` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`idMessage`),
  UNIQUE INDEX `idMessage_UNIQUE` (`idMessage` ASC));
