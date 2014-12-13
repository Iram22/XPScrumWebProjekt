DELETE from udvalgtefag1runde;
DELETE from første_runde;
DELETE from student;
DELETE from valgfag;

INSERT into valgfag values 
(1, 'C#','LAM','helloooooooooooooooooooooooooo there'),
(2, 'Python','PELO','glædelig jul'),
(3, 'Haskel','CHU','godt nytår'),
(4, 'Gaming','AKA','et eller andet'),
(5, 'Android','LAM','yahoo'),
(6, 'Python','TOR','hahahahahahaha'),
(7, 'WebProgrammering','PELO','LMAO'),
(8, 'Grafik','Henrik','YOLO');


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
(5),
(6),
(7),
(8);

insert into puljer values
(1,'a'),
(2,'a'),
(3, 'a'),
(4, 'b'),
(5, 'b'),
(6, 'b');
