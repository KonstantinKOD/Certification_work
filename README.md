1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы, а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).

    ![my code](Code.png)

2. Создать директорию, переместить файл туда

    ![my code](Code2.png)

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.

    ![my code](code3.png)

4. Установить и удалить deb-пакет с помощью dpkg.

5. Выложить историю команд в терминале ubuntu

    ![my code](code4.png)
    ![my code](code5.png)

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы.

    ![my code](code6.png)

7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”

    ![my code](code7.png)

8. Создать таблицы с иерархией из диаграммы в БД

###
    CREATE TABLE abstract_animal
    (
        id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
        group_animal VARCHAR(20)
    );

    CREATE TABLE type_animals
    (
        id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
        name VARCHAR(50),
        fk_group INT REFERENCES abstract_animal (id)
    );

    CREATE TABLE exist_animal
    (
        id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
        name_of_anml VARCHAR(50),
        bird_day date,
        fk_type INT REFERENCES type_animal (id),
        fk_command INT REFERENCES commands (id)
    );

    CREATE TABLE commands
    (
        id int primary key auto_increment,
        name VARCHAR(100)
    );

9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения

###
    INSERT INTO abstract_animal (group_animal) VALUE ("домашний питомец");
    INSERT INTO abstract_animal (group_animal) VALUE ("Вьючное животное");

    INSERT INTO type_animals (name, fk_group) VALUE ("Собака", 1);
    INSERT INTO type_animals (name, fk_group) VALUE ("Кошка", 1);
    INSERT INTO type_animals (name, fk_group) VALUE ("Хомяк", 1);
    INSERT INTO type_animals (name, fk_group) VALUE ("Лошадь", 2);
    INSERT INTO type_animals (name, fk_group) VALUE ("Верблюд", 2);
    INSERT INTO type_animals (name, fk_group) VALUE ("Осел", 2);

    INSERT INTO exist_animal (name_of_anml, bird_day, fk_type, fk_command) VALUE("цезарь", '2020-02-22', 1, 1);
    INSERT INTO exist_animal (name_of_anml, bird_day, fk_type, fk_command) VALUE("Булинг", '2019-12-09', 1, 2);
    INSERT INTO exist_animal (name_of_anml, bird_day, fk_type, fk_command) VALUE("Муся", '2018-04-29', 2, 3);
    INSERT INTO exist_animal (name_of_anml, bird_day, fk_type, fk_command) VALUE("Симба", '2021-06-03', 2, 12);
    INSERT INTO exist_animal (name_of_anml, bird_day, fk_type, fk_command) VALUE("Бусинка", '2020-08-13', 3, 9);
    INSERT INTO exist_animal (name_of_anml, bird_day, fk_type, fk_command) VALUE("Борщ", '2022-12-23', 3, 7);
    INSERT INTO exist_animal (name_of_anml, bird_day, fk_type, fk_command) VALUE("Гоща", '2015-05-01', 4, 14);
    INSERT INTO exist_animal (name_of_anml, bird_day, fk_type, fk_command) VALUE("Плотва", '2017-10-30', 4, 22);
    INSERT INTO exist_animal (name_of_anml, bird_day, fk_type, fk_command) VALUE("Верблюжик", '2016-01-24', 5, 23);
    INSERT INTO exist_animal (name_of_anml, bird_day, fk_type, fk_command) VALUE("Пустыня", '2013-07-02', 5, 16);
    INSERT INTO exist_animal (name_of_anml, bird_day, fk_type, fk_command) VALUE("Гречка", '2015-05-04', 6, 5);
    INSERT INTO exist_animal (name_of_anml, bird_day, fk_type, fk_command) VALUE("Левитация", '2015-02-03', 6, 20);

    INSERT INTO commands (name) VALUE/*1*/("Сидеть");
    INSERT INTO commands (name) VALUE/*2*/("Лежать");
    INSERT INTO commands (name) VALUE/*3*/("Голос");
    INSERT INTO commands (name) VALUE/*4*/("Гулять");
    INSERT INTO commands (name) VALUE/*5*/("Пелвать");
    INSERT INTO commands (name) VALUE/*6*/("Есть");
    INSERT INTO commands (name) VALUE/*7*/("Спать");
    INSERT INTO commands (name) VALUE/*8*/("Фу!");
    INSERT INTO commands (name) VALUE/*9*/("Взять! (работает как 'АВАДАКЕДАВРА')");
    INSERT INTO commands (name) VALUE/*10*/("Взять (работает как просто что-то взять в пасть)");
    INSERT INTO commands (name) VALUE/*11*/("Брось");
    INSERT INTO commands (name) VALUE/*12*/("Прыжок");
    INSERT INTO commands (name) VALUE/*13*/("Кушать");
    INSERT INTO commands (name) VALUE/*14*/("Кружить");
    INSERT INTO commands (name) VALUE/*15*/("Бегать за хвостом");
    INSERT INTO commands (name) VALUE/*16*/("Открыть дверь");
    INSERT INTO commands (name) VALUE/*17*/("Рядом");
    INSERT INTO commands (name) VALUE/*18*/("Играть");
    INSERT INTO commands (name) VALUE/*20*/("Умри");
    INSERT INTO commands (name) VALUE/*21*/("Рысью");
    INSERT INTO commands (name) VALUE/*22*/("Галоп");
    INSERT INTO commands (name) VALUE/*23*/("Марш");

10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

###
    USE human_friends;
    DELETE FROM exist_animal WHERE fk_type = 5
    LIMIT 100;

    CREATE TABLE horse_donkey
    AS SELECT * FROM exist_animal WHERE fk_type = 4
    UNION SELECT * FROM exist_animal WHERE fk_type = 6;

    SELECT * FROM exist_animal;

    