insert into AUTHORS (FIRSTNAME, SURNAME)
values ('Джордж', 'Оруэлл'),
       ('Стивен', 'Кинг'),
       ('Фёдор', 'Достоевский');

insert into GENRE (title)
values ('роман'),
       ('детектив'),
       ('фантастика');

insert into BOOKS (title, AUTHOR_ID, GENRE_ID)
values ('Любовь в большом городе', 1, 1),
       ('Улицы рахбитых фонарей',2 , 2),
       ('За гранью реальности', 3, 3);
