CREATE TABLE USER(
    id INT NOT NULL auto_increment, 
    name VARCHAR(50) NOT NULL,
	pass VARCHAR(64) NOT NULL,
    joining_date DATE NOT NULL,
      email VARCHAR(30) NOT NULL ,
    PRIMARY KEY (id)
);