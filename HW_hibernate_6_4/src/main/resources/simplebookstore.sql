CREATE DATABASE simplebookstore;

USE simplebookstore;

SELECT * FROM author;

SELECT * FROM book;

SELECT * FROM authors_books;

SELECT COUNT(*) FROM author;

SELECT COUNT(*) FROM book;

SELECT COUNT(*) FROM authors_books;

SELECT * FROM book ORDER BY id;

SELECT * FROM book ORDER BY id;

SELECT * FROM authors_books WHERE author_id = 1;

SELECT a.id, a.last_name, a.name, b.name AS book FROM author AS a
                                                          LEFT JOIN book AS b ON a.id = b.id ORDER BY a.id;

SELECT b.id, a.last_name, a.name, COUNT(b.id) AS TotalBook FROM book AS b
                                                                    INNER JOIN author AS a ON a.id = b.id
GROUP BY b.id;

SELECT * FROM author ORDER BY last_name;