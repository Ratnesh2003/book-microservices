# Book Service

## Introduction
This is the Book Service for the Book Microservices application. It uses `MongoDB` as the database to store information about books.

## API Endpoints

1. **Add Book**
    - **URL:** `/api/book/`
    - **Method:** `POST`
    - **Request Body:**
        ```json
        {
            "name": "Head First Java",
            "author": "Kathy Sierra",
            "description": "Best Java programming book.",
            "price": 400
        }
        ```
2. **Get Book**
    - **URL:** `/api/book/{id}`
    - **Method:** `GET`
3. **Get All Books**
    - **URL:** `/api/book/all`
    - **Method:** `GET`
    - **Request Parameter:** `pageIndex`, `pageSize`, `sortBy`, `sortOrder`
4. **Update Book**
    - **URL:** `/api/book/update/{id}`
    - **Method:** `PUT`
    - **Request Body:**
        ```json
        {
            "name": "Head First Java",
            "author": "Kathy Sierra",
            "description": "Best Java programming book.",
            "price": 400
        }
        ```
5. **Delete Book**
    - **URL:** `/api/book/{id}`
    - **Method:** `DELETE`
6. **Exists By ID**
    - **URL:** `/api/book/exists/{id}`
    - **Method:** `GET`

## Dependencies
1. `Inventory Service` - To remove book from inventory when deleted. 

## Screenshots
<p align="center">
<img src="https://ucarecdn.com/5d013626-b050-4a94-a50d-8b85b3248cbd/create_book.png" alt="create-book">
<img src="https://ucarecdn.com/dda9acb7-d521-4ca4-bc83-b34ce999b02e/fetch_all_books.png" alt="fetch-all-books">
</p>


## Port
The Book Service runs on port `8282`.
