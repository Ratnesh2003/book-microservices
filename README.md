<br />
<div align="center" id="readme-top">
    
<a href="https://github.com/othneildrew/Best-README-Template">
    <img src="https://i.ibb.co/7SVSHcc/logo.png" alt="Logo" width="80" height="80">
  </a>

  <h1 align="center">Book Microservices</h1>

  <p align="center">
    A microservice application built using Spring Boot and Spring Cloud.
    <br />
  </p>
</div>



<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#introduction">Introduction</a>
      <ul>
        <li><a href="#list-of-microservices">List of microservices</a></li>
      </ul>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#services-ports">Services Ports</a>
    </li>
    <li><a href="#usage">Usage</a>
    <ul>
          <li><a href="#book-service">Book Service</a></li>
            <li><a href="#inventory-service">Inventory Service</a></li>
            <li><a href="#loan-service">Loan Service</a></li>
    </ul>
    </li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
  </ol>
</details>



## Introduction


This application showcases the use of Spring Cloud for a microservice application. It is a basic application for a bookstore platform. Admins can manage books and their availability in the inventory. They can also lend books to users and facilitate book returns.

### List of microservices
* [Book Service](https://github.com/Ratnesh2003/book-microservices/tree/master/book-service) : Add and modify information about books.
* [Inventory Service](https://github.com/Ratnesh2003/book-microservices/tree/master/inventory-service) : Update availability of books.
* [Loan Service](https://github.com/Ratnesh2003/book-microservices/tree/master/loan-service) : Lend and receive books from users.
* [Notification Service](https://github.com/Ratnesh2003/book-microservices/tree/master/notification-service) : To send notifications about books and loans.
* [Discovery Server](https://github.com/Ratnesh2003/book-microservices/tree/master/discovery-server) : Eureka service discovery server.
* [API Gateway](https://github.com/Ratnesh2003/book-microservices/tree/master/api-gateway) : API Gateway to route requests to microservices.

Each of the microservice has its own `README` file with detailed information about the service.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With


* [![SpringBoot][SpringBoot]][SpringBoot-url]
* [![Prometheus][Prometheus]][Prometheus-url]
* [![Grafana][Grafana]][Grafana-url]
* [![Cassandra][Cassandra]][Cassandra-url]
* [![Mongodb][Mongodb]][Mongodb-url]
* [![Postgresql][Postgresql]][Postgresql-url]
* [![Docker][Docker]][Docker-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Screenshots
This section shows the screenshots of some of the additional tools and services used in the application.

<p align="center">
    <img src="https://i.ibb.co/gznpfB3/eureka.png" alt="eureka" width="49%">
    <img src="https://i.ibb.co/n32vQdd/prometheus.png" alt="prometheus" width="49%">
</p>
<p align="center">
    <img src="https://i.ibb.co/Cn4vD9w/prometheus-2.png" alt="monitoring" width="49%">
    <img src="https://i.ibb.co/hV8XSBp/keycloak.png" alt="keycloak" width="49%">
</p>
<p align="center">
    <img src="https://i.ibb.co/dGRK7cv/zipkin.png" alt="zipkin" width="49%">
    <img src="https://i.ibb.co/mRKXvXZ/zipkin-tracing.png" alt="tracing" width="49%">
</p>

<p align="right">(<a href="#readme-top">back to top</a>)</p>




## Getting Started


### Prerequisites

* [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Docker](https://www.docker.com/)

### Installation

- Make a copy of the `.env.example` file and rename it to `.env`. Fill in the environment variables in the file.

    ```sh
  cp .env.example .env
  ```
- Run the following command to run the docker-compose file.

    ```sh
  docker-compose up -d
  ```
- Now you can start each of the microservice using the following command inside each of the microservice directory.

    ```sh
  ./mvnw spring-boot:run
  ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Services Ports

- Microservices:
    * `Book Service` : 8282
    * `Inventory Service` : 8383
    * `Loan Service` : 8484
    * `Notification Service` : 8585
    * `Discovery Server` : 8761
    * `API Gateway` : 8080
    * `Apache Kafka`: 9092
<br/><br/>
- Metrics and Monitoring:
    * `Keycloak` : 8181
    * `Zipkin` : 9411
    * `Prometheus` : 9090
    * `Grafana` : 3000
<br/><br/>
- Databases:
    * `Cassandra` : 9042
    * `MongoDB` : 27017
    * `PostgreSQL` : 5432




## Usage

This section shows how to use the services provided by the application.

### Book Service
This service is used to manage books. Admins can add, modify and delete books from the database. The service uses `MongoDB` as the database.
<br/>
_Complete documentation [here](https://github.com/Ratnesh2003/book-microservices/tree/master/book-service)._


### Inventory Service
This service is used to manage the availability of books. Admins can update the availability of books in the inventory. The service uses `PostgreSQL` as the database.
<br/>
_Complete documentation [here](https://github.com/Ratnesh2003/book-microservices/tree/master/inventory-service)._

### Loan Service
This service is used to lend and receive books from users. Admins can lend books to users and receive books from users. The service uses `Cassandra` as the database.
<br/>
_Complete documentation [here](https://github.com/Ratnesh2003/book-microservices/tree/master/loan-service)._

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Roadmap

- [x] Add documentation for each of the microservices.
- [ ] Add gmail smtp server for sending emails in notification service.
- [ ] Add redis for caching and improving performance.
- [ ] Add rate limiting for the API Gateway.
- [ ] Add more events for the notification service.

<p align="right">(<a href="#readme-top">back to top</a>)</p>




## Contributing

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the`enhancement`tag.

1. Fork the Project
2. Create your Feature Branch <br/>
`git checkout -b feature/new_feature`
3. Commit your Changes <br/>
`git commit -m 'Add new_feature'`
4. Push to the Branch <br/>
`git push origin feature/new_feature`
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>







[SpringBoot]: https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=Spring&logoColor=white
[SpringBoot-url]: https://nextjs.org/
[ApacheKafka.js]: https://img.shields.io/badge/Apache%20Kafka-000?style=for-the-badge&logo=apachekafka
[React-url]: https://reactjs.org/
[Prometheus]: https://img.shields.io/badge/Prometheus-grey?style=for-the-badge&logo=prometheus
[Prometheus-url]: https://vuejs.org/
[Grafana]: https://img.shields.io/badge/Grafana-black?style=for-the-badge&logo=grafana
[Grafana-url]: https://angular.io/
[Cassandra]: https://img.shields.io/badge/Apache%20Cassandra-white?style=for-the-badge&logo=apachecassandra
[Cassandra-url]: https://svelte.dev/
[Mongodb]: https://img.shields.io/badge/MongoDB-black?style=for-the-badge&logo=mongodb
[Mongodb-url]: https://laravel.com
[Postgresql]: https://img.shields.io/badge/postgresql-white?style=for-the-badge&logo=postgresql&logoColor=blue
[Postgresql-url]: https://getbootstrap.com
[Docker]: https://img.shields.io/badge/docker-blue?style=for-the-badge&logo=docker&logoColor=white
[Docker-url]: https://jquery.com 

<!--
https://ibb.co/BLd5ZqS
https://ibb.co/J5h4GMK
https://ibb.co/yB4HdHK
https://ibb.co/fdR4hWY
https://ibb.co/9VNKd6x
https://ibb.co/njk3F7h
https://ibb.co/8z3pPvv
https://ibb.co/YtJ8wdN
https://ibb.co/K0t8T74
https://ibb.co/86H8XBw
https://ibb.co/7SDRgRM
https://ibb.co/W0XjS1F
https://ibb.co/hV09jcG
https://ibb.co/5XQqgv6
https://ibb.co/DtzHfCs
-->