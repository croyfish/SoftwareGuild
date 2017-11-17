USE Northwind;
 
SELECT CompanyName, City, Country
FROM Customers
WHERE Country = 'USA';

Use Northwind;

SELECT City
FROM Customers
WHERE Country != 'Canada' AND Country != 'USA';
