# API Gateway

## Introduction
This is the API Gateway for the Book Microservices application. It is built using Spring Cloud Gateway. It routes requests to the respective microservices.

## Mappings
The API Gateway has the following mappings:
* `/api/book/**` : Routes to the Book Service.
* `/api/inventory/**` : Routes to the Inventory Service.
* `/api/loan/**` : Routes to the Loan Service.
* `/eureka/web` : Routes to the Eureka Dashboard.
## Port
The API Gateway runs on port `8080`.