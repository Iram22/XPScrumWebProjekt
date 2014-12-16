DELETE from udvalgtefag1runde;
DELETE from første_runde;
DELETE from student;
DELETE from valgfag;

INSERT into valgfag values 
(1, 'C#','LAM','helloooooooooooooooooooooooooo there'),
(2, 'Python','PELO','glædelig jul'),
(3, 'Haskel','CHU','godt nytår'),
(4, 'Games','AKA','et eller andet'),
(5, 'Android','LAM','yahoo'),
(6, 'Web Programmering','PELO','LMAO'),
(7, 'SW Design','Henrik','YOLO'),
(8, 'Grafik','Henrik','YOLO'),
(9, 'Databaser','Henrik','YOLO'),
(10, 'Test','Henrik','YOLO'),
(11, 'Arduino','Henrik','YOLO');


INSERT into student values
(1, 'Bjarke Carlsen'),
(2, 'Emil Christiansen'),
(3, 'Jesper Dahl'),
(4, 'Kenn Jacobsen'),
(5, 'Aske Rode'),
(6, 'Thor Kristensen'),
(7, 'Johan Leu'),
(8, 'Jesper Olsen'),
(9, 'Martin Olgenkjær'),
(10, 'Henrik Stavnem'),
(11, 'Nicklas Thomsen');


INSERT into første_runde values 
(1, 1, 2, 3, 5),
(2, 2, 4, 5, 3),
(3, 1, 3, 5, 2),
(4, 3, 4, 5, 1),
(5, 2, 1, 4, 5);

insert into udvalgtefag1runde values 
(1),
(2),
(5),
(7),
(4),
(9),
(10),
(11);

insert into puljer values
(1,'a'),
(7,'a'),
(5, 'b'),
(4, 'b'),
(2, 'b');

