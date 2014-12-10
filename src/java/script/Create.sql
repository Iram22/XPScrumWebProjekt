DROP TABLE udvalgtefag1runde;
DROP TABLE puljer;
DROP TABLE første_runde;
DROP TABLE student;
DROP TABLE valgfag;

Create TABLE valgfag(
    id INTEGER NOT NULL PRIMARY KEY,
    fag VARCHAR(20)
);

Create TABLE student(
    id INTEGER NOT NULL PRIMARY KEY,
    navn VARCHAR(20)
);

Create TABLE første_runde(
    studentId INTEGER REFERENCES student(id) NOT NULL PRIMARY KEY,
    første_prioritetA INTEGER REFERENCES valgfag(id),
    anden_prioritetA INTEGER REFERENCES valgfag(id),
    første_prioritetB INTEGER REFERENCES valgfag(id),
    anden_prioritetB INTEGER REFERENCES valgfag(id)
    
);

Create TABLE puljer(
 valgfagId INTEGER REFERENCES valgfag(id) NOT NULL primary key,
 pulje varchar(20)
);

Create Table udvalgtefag1runde(
 valgfagId INTEGER REFERENCES valgfag(id) NOT NULL primary key
);




  select * from puljer
