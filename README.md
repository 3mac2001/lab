
# Технология разработки программного обеспечения
# Лабораторная работа №1: создание микросервиса на Spring Boot с базой данных
## Ефимов Алексей Геннадьевич, Группа 3МАС2001
## Цель лабораторной работы: 
Ознакомится с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов).

Приложение представляет микросервис, реализующий CRUD пример телефонной базы.
Для работы приложения требуется запущенная база данных PostgreSQL. 
#### Подготовка и настройка сервера баз данных
Подготовка базы данных для добавления к Spring-приложению. Чтобы запустить Postgres Docker-контейнер, необходимо выполнить следующие команды в Docker Quickstart Terminal:

` docker run -e POSTGRES_PASSWORD=root -p 5432:5432` 
 
В файле <code>./src/main/resources/application.properties</code> указываются настройки подключения к базе данных и учётные данные:
  * в параметре <code>spring.datasource.username = </code> надо указать имя пользователя для доступа к базе данных (postgres).
  * в параметре <code>spring.datasource.password = </code> пароль для доступа к базе данных (root). 
  * В параметре <code>spring.datasource.url = </code> необходимо указать адрес для доступа к базе данных, например для доступа к базе данных запущенной на локальном компьютере значение будет <code>jdbc:postgresql://localhost:5432/postgres</code>, для базы данных запущенной в docker на локальной машине IP адрес требуется изменить.   

Настройка базы данных осуществляется с помощью файла <code>./src/main/resources/schema.sql</code>. Для этого необходимо выполнить команду <code>psql -h <адрес_БД> -p <порт_БД> -U <имя_пользователя> -d public -f "schema.sql"</code> .  
Тестовые данные для БД находятся в <code> ./src/main/resources/data.sql </code> . Для этого необходимо выполнить команду <code>psql -h <адрес_БД> -p <порт_БД> -U <имя_пользователя> -d public -f "data.sql"</code>.    
#### Клонирование репозитария.
Для клонирования репозитория надо выполнить команду <code>git clone  git clone https://github.com/3mac2001/Lab.git
Для запуска сборки из консоли потребуется установка Maven и настройка операционной системы. Сборка приложения осуществляется при помощи автоматической системы сборки проектов Maven. 
Для сборки необходимо выполнить команду mvn package -Dmaven.test.skip=true(с пропуском тестирования) находясь в директории проекта. После окончания выполнения команды появится папка target в которой находится скомпилированный код и файл labaapi-1.0.jar.
#### Сборка и запуск Docker-образа 
Для сборки Docker образа следует выполнить команду <code> docker build -t labaapi:latest . </code> находясь в директории с <code>Dockerfile</code> и собранным <code>labaapi-1.0.jar</code> .  
Запуск осуществляется командой <code>docker run -p 8080:8080 labaapi:v1 </code>, в формате {порт внешний}:{порт в Docker}.  
#### Примеры запросов к labaapi:
Формат JSON: {name: "string", department: "string ",callnumber: integer, room: integer}
##### Получить список всех результатов: 
<code>curl -X GET http://127.0.0.1:8080/api/v1/results</code>
В ответ будет получен JSON со всеми записями. 
##### Получить запись по id: 
<code>curl -X GET http://127.0.0.1:8080/api/v1/results/{id}</code> 
В ответ будет получен JSON ответ с информацией о пользователе. 
##### Добавить запись: 
<code>curl -X POST http://127.0.0.1:8080/api/v1/results -d ‘{«name»: «Имя″, "department": "Отдел", "room": 101, "callnumber": 155}’ -H «Content-Type:application/json» 
##### Удалить запись: 
<code>curl -X POST http://127.0.0.1:8080/api/v1/results/{id}</code>
В ответ будет получен статус <code>204 No Content</code>.
##### Также приложение возвращает значение hostname: 
<code>curl -X GET http://127.0.0.1:8080/api/v1/status</code>
В ответ будет получен JSON в виде <code>{hostname: "hostname"}</code>. 

# Лабораторная работа №3: CI/CD и деплой приложения в Heroku
# Цель работы: 
## Целью лабораторной работы является знакомство с CI/CD и его реализацией на примере Travis CI и Heroku.

