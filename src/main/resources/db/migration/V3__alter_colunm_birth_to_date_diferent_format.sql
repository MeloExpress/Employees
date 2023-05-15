ALTER TABLE employees
ALTER COLUMN birth TYPE DATE USING to_date(to_char(birth, 'DD/MM/YYYY'), 'DD/MM/YYYY');

