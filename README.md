# Food Delivery Fee calculator project.

This is a Food delivery calculator project related to an internship homework task. 

Main technologies used:
- Spring boot with Java 17
- H2 Database

## Components
The project includes an REST interface which allows to request delivery fee calculation and manipulate the data that hold Regional base fees
The weather data is requested from https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php every 15 minutes after the hour has passed using Cronjob scheduler.
The application uses data from Tallinn-Harku (City of Tallinn), Tartu-Tõravere (city of Tartu) and Pärnu stations.
The fee calculating logic testing is automated and repository functionalities testing are automated, have not managed to make tests work for other components.


##To run the application

```cd ../path/to/project```
```java -jar target/fooddelivery-0.0.1-SNAPSHOT.jar```

## Or run with docker
```cd ../path/to/project```
```docker compose up```

