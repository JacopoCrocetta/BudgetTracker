# BE_Budgeting

## Project for your own monthly and annual budget

### HOW TO RUN

In order to start the project, run this command:

1. `docker-compose up -d`
2. `mvn clean install -DskipTests`
3. `java -jar target / BEbudgeting-0.0.1-SNAPSHOT.jar`

if you don't have docker but you have MySQL, run this command:

1. `Budget.sql` in MySQL to create the database
2. `mvn clean install -DskipTests`
3. `java -jar target / BEbudgeting-0.0.1-SNAPSHOT.jar`
