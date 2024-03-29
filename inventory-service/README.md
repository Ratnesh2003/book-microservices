# Inventory Service

## Introduction
This is the Inventory Service for the Book Microservices application. It uses `PostgreSQL` as the database to store information about book availability.

## API Endpoints
1. **Add Book in Inventory**
    - **URL:** `/api/inventory/`
    - **Method:** `POST`
    - **Request Body:**
        ```json
        {
            "bookId": "65f92518366de22d08200cec",
            "quantity": 10
        }
        ```
2. **Get Book Availability**
    - **URL:** `/api/inventory/{bookId}/availability`
    - **Method:** `GET`

3. **Update Book Availability**
    - **URL:** `/api/inventory/`
    - **Method:** `PUT`
    - **Request Body:**
        ```json
        {
            "bookId": "65d122b8c065dc5c13efe008",
            "quantity": 5
        }
        ```
4. **Delete Book from Inventory**
    - **URL:** `/api/inventory/{bookId}`
    - **Method:** `DELETE`

## Dependencies
`Book Service` - To check if the book exists in the database while adding it in the inventory.

## Screenshots
<p align="center">
<img src="https://ucarecdn.com/46e71139-c58e-4bbb-bdd8-cc5fff926d2e/inventory_book.png">
<img src="https://ucarecdn.com/52017c2d-bd29-472d-8a5b-61d90956d4db/availability.png">
</p>

## Port
The Inventory Service runs on port `8383`.