use classicmodels;

SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.'; 

-- explain query
EXPLAIN SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.'; 

-- thêm chỉ mục 
ALTER TABLE customers ADD INDEX idx_customerName(customerName);
EXPLAIN SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.'; 

-- add index 
ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);
EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';

-- xoá chỉ mục index
ALTER TABLE customers DROP INDEX idx_full_name;