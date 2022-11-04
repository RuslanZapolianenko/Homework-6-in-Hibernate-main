CREATE DATABASE simplebookstore;

USE simplebookstore;

SELECT COUNT(*) FROM author;

SELECT COUNT(*) FROM book;

SELECT * FROM book;

SELECT * FROM author;

SELECT * FROM book ORDER BY author_id;

SELECT * FROM book ORDER BY id;

SELECT a.id, a.last_name, a.name, b.name AS book FROM author AS a  
LEFT JOIN book AS b ON a.id = b.author_id ORDER BY a.id;


SELECT b.author_id, a.last_name, a.name, COUNT(b.author_id) AS TotalBook FROM book AS b 
INNER JOIN author AS a ON a.id = b.author_id 
GROUP BY b.author_id;



