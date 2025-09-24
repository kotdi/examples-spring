--Создаем таблицу для пользователей
create table users (
    user_id             serial  not null,
    user_name           text    not null,
    user_middle_name    text,
    user_last_name      text,
    user_birthday       timestamp,
    constraint pk_user_id primary key (user_id)
);
insert into users (user_name, user_middle_name, user_last_name, user_birthday) values
('Иван', 'Иванович', 'Иванов', '1990-10-10 05:00:00');