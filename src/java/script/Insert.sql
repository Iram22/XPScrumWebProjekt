DELETE from første_runde;
DELETE from student;
DELETE from valgfag;

INSERT into valgfag values (1, 'C#');
INSERT into valgfag values (2, 'Python');
INSERT into valgfag values (3, 'Haskel');
INSERT into valgfag values (4, 'Gaming');
INSERT into valgfag values (5, 'Android');

INSERT into student values (1, 'Dino');
INSERT into student values (2, 'Iram');
INSERT into student values (3, 'Hanan');
INSERT into student values (4, 'Mehmet');
INSERT into student values (5, 'Ahmed');
INSERT into student values (6, 'Chris');
INSERT into student values (7, 'Lida');


INSERT into første_runde values (1, 1, 2, 3, 5);
INSERT into første_runde values (2, 2, 4, 5, 3);
INSERT into første_runde values (3, 1, 3, 5, 2);
INSERT into første_runde values (4, 3, 4, 5, 1);
INSERT into første_runde values (5, 2, 1, 4, 5);

