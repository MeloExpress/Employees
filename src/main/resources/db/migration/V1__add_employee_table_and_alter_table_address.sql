CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE employees (
  id SERIAL PRIMARY KEY,
  employee_code UUID DEFAULT uuid_generate_v4(),
  name VARCHAR(100) NOT NULL,
  cpf VARCHAR(11) UNIQUE NOT NULL,
  rg VARCHAR(20) UNIQUE NOT NULL,
  cnh VARCHAR(20) UNIQUE NOT NULL,
  birth INTEGER,
  gender VARCHAR(1),
  occupation VARCHAR(50),
  zipCode VARCHAR(8),
  street VARCHAR(150),
  number VARCHAR(8),
  neighborhood VARCHAR(50),
  city VARCHAR(50),
  state VARCHAR(50),
  country VARCHAR(50)
);


