ALTER TABLE employees
ALTER COLUMN birth TYPE DATE USING to_date(to_char(birth, '99999999'), 'DDMMYYYY');


