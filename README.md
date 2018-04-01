# todo-app
todo application

Go to todo-app/todo-backend/

Run the following command to start backend services

mvn spring-boot:run

Go to browser and open the following url to add data into database. Here we are using h2 database.

http://localhost:8000/todo-api/h2-console/

run the following sample queries in it.

DROP TABLE IF EXISTS TODO;
CREATE TABLE TODO(TODO_ID INT PRIMARY KEY, TITLE VARCHAR(255), DESCRIPTION VARCHAR(255), STATUS VARCHAR(255));
INSERT INTO TODO VALUES (1, 'Book flight ticket', 'Need to book a flight ticket to go Dubai, 'Incomplete');
INSERT INTO TODO VALUES (2, 'Order Dinner', 'Need to order pizza for dinner', 'Completed');

Go to todo-app/todo-frontend

Run the following command to start front end

 npm run start