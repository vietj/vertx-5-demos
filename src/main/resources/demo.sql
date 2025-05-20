DROP TABLE IF EXISTS movie_details;
CREATE TABLE movie_details
(
    id           VARCHAR(12) PRIMARY KEY,
    title        VARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS movie_ratings;
CREATE TABLE movie_ratings
(
    id           VARCHAR(12),
    rating       INTEGER NOT NULL
);

INSERT INTO movie_details (id, title) VALUES ('starwars', 'Star Wars');
INSERT INTO movie_details (id, title) VALUES ('indianajones', 'Indiana Jones');
INSERT INTO movie_ratings (rating, id) VALUES (1, 'starwars');
INSERT INTO movie_ratings (rating, id) VALUES (5, 'starwars');
INSERT INTO movie_ratings (rating, id) VALUES (9, 'starwars');
INSERT INTO movie_ratings (rating, id) VALUES (10, 'starwars');
INSERT INTO movie_ratings (rating, id) VALUES (4, 'indianajones');
INSERT INTO movie_ratings (rating, id) VALUES (7, 'indianajones');
INSERT INTO movie_ratings (rating, id) VALUES (3, 'indianajones');
INSERT INTO movie_ratings (rating, id) VALUES (9, 'indianajones');
