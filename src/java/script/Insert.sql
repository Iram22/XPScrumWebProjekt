DELETE from udvalgtefag1runde;
DELETE from første_runde;
DELETE from student;
DELETE from valgfag;

INSERT into valgfag values 
(1, 'C#'),
(2, 'Python'),
(3, 'Haskel'),
(4, 'Gaming'),
(5, 'Android');

INSERT into student values
(1, 'Dino'),
(2, 'Iram'),
(3, 'Hanan'),
(4, 'Mehmet'),
(5, 'Ahmed'),
(6, 'Chris'),
(7, 'Lida');


INSERT into første_runde values 
(1, 1, 2, 3, 5),
(2, 2, 4, 5, 3),
(3, 1, 3, 5, 2),
(4, 3, 4, 5, 1),
(5, 2, 1, 4, 5);

insert into udvalgtefag1runde values 
(1),
(2),
(3),
(5);

