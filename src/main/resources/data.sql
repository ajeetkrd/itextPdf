DROP TABLE IF EXISTS cities;

CREATE TABLE cities (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  population int DEFAULT NULL
);

INSERT INTO cities (name, population) VALUES
  ('Ald',100),
  ('Del',200),
  ('Blr',300),
  ('Ccu',400);