DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  time_stamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE ITEMS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE ORDERS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  cart_id INT NOT NULL,
  item_id INT NOT NULL,
  user_id INT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE CARTS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_id INT NOT NULL,
  is_purchases BOOL NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO USERS (name, username, password) VALUES
  ('bharath', 'bharath', 'password'),
  ('sa', 'sa', 'sa'),
  ('test', 'testuser', 'testpass');

INSERT INTO ITEMS (name) VALUES
  ('item1'),
  ('item2');

INSERT INTO ORDERS (cart_id, item_id, user_id) VALUES
  (1, 1, 1),
  (1, 2, 1),
  (1, 2, 2),
  (1, 2, 2);

INSERT INTO CARTS (user_id, is_purchases) VALUES
  (1, false),
  (2, true);