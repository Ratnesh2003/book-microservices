# Loan Service

## Introduction
This is the Loan Service for the Book Microservices application. It uses `Apache Cassandra` as the database to store information about book loans.

## API Endpoints
1. **Create Loan**
    - **URL:** `/api/loan/`
    - **Method:** `POST`
    - **Request Body:**
        ```json
        {
            "userId": 21153063,
            "userName": "ratnesh2003",
            "bookId": "65f92518366de22d08200cec"
        }
        ```
2. **Get All Loans**
    - **URL:** `/api/loan/all`
    - **Method:** `GET`
    - **Request Parameter:** `pageIndex`, `pageSize`, `sortBy`, `sortOrder`

3. **Get Loan By ID**
    - **URL:** `/api/loan/{id}`
    - **Method:** `GET`

4. **Return Loan**
    - **URL:** `/api/loan/return/{id}`
    - **Method:** `PUT`

5. **Delete Loan**
    - **URL:** `/api/loan/{id}`
    - **Method:** `DELETE`

6. **Get User Loans**
    - **URL:** `/api/loan/user/{userId}`
    - **Method:** `GET`

## Dependencies
1. `Inventory Service` - To check if the book is available in the inventory while creating a loan.
2. `Inventory Service` - To update the availability of the book in the inventory while creating and returning a loan.

## Screenshots
<p align="center">
<img src="https://i.ibb.co/drjw421/create-loan.png">
<img src="https://i.ibb.co/0yNhgLj/get-all-loans.png">
</p>

## Port
The Loan Service runs on port `8484`.