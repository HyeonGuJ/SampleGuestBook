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

  
  INSERT INTO `guestbook`.`message` (`email`, `password`, `date`, `modifiedDate`, `text`) 
  VALUES ('hi@naver.com', '3211', '2016-12-12', '2016-12-13', 'HI');
  