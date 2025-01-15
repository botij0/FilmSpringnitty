![image](https://github.com/user-attachments/assets/eb285892-5221-422c-a720-cbe6ec567186)

---

FilmAffinity based web application built with java, microservices architecture, Spring Boot, Thymeleaf, Eureka and Cloud Gateway; in addition to MySQL databases for the microservices.

Here is a [DEMO Video](https://www.youtube.com/watch?v=7moXJkMgZ-Q) if you want to see the full operation of the application.

## Contents
1. [Execution](#execution)
   - [Microservices](#microservices)
   - [Database](#db)

3. [How It Works](#how-it-works)
   - [Architecture](#architecture)
   - [BBDD Structure](#bbdd-structure)

## Execution

### Microservices
> [!NOTE]
> To run each microservice, it is recommended to open each folder in a java IDE (e.g. [IntellijIDEA (https://www.jetbrains.com/idea/)), except for `bdd` and run each one from there.

### DB

> [!IMPORTANT]
> You need to have installed [MySQL](https://www.mysql.com/)

Inside the `bdd/` folder there is an `.sql` script wich creates the databases needed.

## How It Works

In this section the analysis and design of the web application is discussed in depth.

### Architecture

Due to the nature of the implementation, the application consists of 5 microservices, the Eureka server, the Frontend client, the Gateway and the moviesActors and usersCritics microservices. 

In addition, the Model-View-Controller pattern has been applied for the development of the project. Here is a visual scheme of the architecture:

![Architecture Scheme](https://github.com/user-attachments/assets/db2989c8-abb3-407e-9c19-605c915faa9d)

Each of them is described below.

#### peliculasActores

The `peliculasActores` microservice uses JPA and REST services to be able to manage the data with the database and which are requested by the Frontend client via REST. It allows 
various operations such as querying, saving, editing and deleting the requested data. To access the microservice the following address is used: `http://localhost:8001`

#### usuariosCriticas

The user microservice `usuariosCriticas` also uses JPA and REST services to be able to manage the data with the database and that are requested by the Frontend client via REST. the data with the database and that are requested by the Frontend client via REST. It various operations such as querying, saving, editing and deleting the requested data. the requested data. To access the microservice the address: `http://localhost:8002` is used.

#### Gateway

The `Gateway` microservice simply makes it easier for the frontend client to make requests for the microservices. corresponding to the microservices. It will simply request the data with a specific url for each microservice without relying on the ip:port of the other microservices, it only has to worry about the ip:port of the only have to worry about the ip:port of the Gateway microservice. 

#### Eureka Server

The `Eureka Server` microservice simply allows us to keep track of the microservices of the application. This server serves as an address manager, registration manager and discovery of deployed and removed microservices, where each microservice must be configured as a Eureka client and send a request requesting registration on that server at startup. To access the microservice the address: `http://localhost:8761/` is used. 

#### clienteFrontend

The microservice of the Frontend client is in charge of consuming the data provided by the moviesActors and usersCritics microservices (using REST) and displaying them to the client thanks to a presentation layer developed with Thymeleaf. To access the microservice use the address: `http://localhost:9000/cpeliculas/`

### BBDD Structure

The application consists of two microservices that each require a database. These microservices are: moviesActors and usersCritics. 

To store the movies and actors data, a MySQL database has been created, which consists of three tables. For a better understanding the following model is attached: 

![E/R Scheme](https://github.com/user-attachments/assets/826e63b2-eb80-4d60-90a9-08179faa0e19)

As can be seen, both the `movies` and `actors` tables store fields relating to these respectively, while the `movies_has_actors` table allows us to relate the actors to the movies and vice versa through a `Many to Many` relationship.  

It has been decided to store also an image of each actor because it can be very convenient for the customer to identify them in a visual way in addition to the other data. 

To store the data related to users and reviews, another database has been created in MySQL, which consists of four tables. For a better understanding the following model is attached: 

![E/R Scheme](https://github.com/user-attachments/assets/08906479-5d6d-4775-bcf0-dbea4b1f6490)


In this database we use the table nomenclature used by Spring Security for the management of users and roles, that is why we have it in English. 

As you can see in the image, users and authorities have a many to many relationship through the table `users_has_authorities`. Finally comment that the table users table has a one to many relationship with the critics table. 

