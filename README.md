# Character API

## Overview

This project is a RESTful API built using Spring Boot, Spring Data JPA, and PostgreSQL.

The purpose of this API is to manage characters for a website. The API allows users to create, read, update, delete, search, and filter characters stored in the database.

Each character contains the following fields:

characterId (auto-generated)

name

description

universe

species

For the category requirement in this project, the universe field is used as the category.

## Technology Stack

Java

Spring Boot

Spring Data JPA

Hibernate

PostgreSQL (Neon.tech)

Maven

HTML

JavaScript

Fetch API

## Installation

Clone the repository

git clone https://github.com/KERATO-1/character-api.git

Go into the project folder

cd character-api

Configure the database connection

Edit this file:

src/main/resources/application.properties

Add your PostgreSQL connection information:

spring.datasource.url=jdbc:postgresql://HOST:5432/neondb
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD
spring.jpa.hibernate.ddl-auto=update

Run the application

./mvnw spring-boot:run

The API will start at:

http://localhost:8080

## API Endpoints

### Get All Characters

Returns all characters in the database.

GET /characters

Example:

http://localhost:8080/characters

### Get Character by ID

Returns a specific character using its ID.

GET /characters/{id}

Example:

http://localhost:8080/characters/1

### Create a Character

Adds a new character to the database.

POST /characters

Example request body:

{
  "name": "Naruto Uzumaki",
  "description": "A ninja who wants to become Hokage.",
  "universe": "Naruto",
  "species": "Human"
}

Example response:

{
  "characterId": 1,
  "name": "Naruto Uzumaki",
  "description": "A ninja who wants to become Hokage.",
  "universe": "Naruto",
  "species": "Human"
}

### Update a Character

Updates an existing character.

PUT /characters/{id}

Example request body:

{
  "name": "Naruto Uzumaki",
  "description": "Future Hokage",
  "universe": "Naruto",
  "species": "Human"
}

### Delete a Character

Deletes a character from the database.

DELETE /characters/{id}

Example:

http://localhost:8080/characters/1

### Get Characters by Category

Returns characters based on universe.

GET /characters/category/{universe}

Example:

http://localhost:8080/characters/category/Naruto

### Search Characters by Name

Returns characters whose names contain a substring.

GET /characters/search?name=substring

Example:

http://localhost:8080/characters/search?name=Nar

## Error Handling

### Invalid ID

If an ID does not exist, the API returns 404 Not Found.

Example:

GET http://localhost:8080/characters/999

Response:

404 Not Found

### Missing Required Fields

If required fields are missing, the API returns 400 Bad Request.

Example request:

{
  "name": "Bad Character"
}

Response:

400 Bad Request

## Testing

The API was tested using Bruno.

Tests performed:

Create character (POST)

Get all characters (GET)

Get character by ID (GET)

Update character (PUT)

Delete character (DELETE)

Category filtering

Name search

Error handling (400 and 404 responses)

## Assignment 4: Web Application (MVC / Frontend)

### Overview

This project was extended into a full-stack web application by adding a browser-based frontend using HTML, JavaScript, and the Fetch API.

The frontend allows users to interact with the backend API through a web interface instead of using tools like Bruno or Postman.

All data displayed in the UI is dynamically fetched from the database (no hardcoded data).

### Frontend Location

All frontend files are located in:

src/main/resources/static

### Web Pages

#### Home Page

Displays all characters.

http://localhost:8080/index.html

#### Character Details Page

Displays one character using its ID.

http://localhost:8080/details.html?id=1

#### Create Page

Form used to create a new character.

http://localhost:8080/create.html

#### Update Page

Form used to update an existing character.

http://localhost:8080/update.html?id=1

### Web App Features

The web application supports full CRUD functionality:

View all characters on the homepage

View a single character’s details

Create a new character using a form

Update an existing character using a form

Delete a character from the homepage

All operations are performed using JavaScript fetch() to communicate with the backend API.

## Demo Videos

### Assignment 3 (API Demo)

A demo video showing the API being tested using Bruno is included.

Demo Video Link:
https://uncg-my.sharepoint.com/:v:/r/personal/gnhassan_uncg_edu/Documents/Screen%20Recording%202026-03-06%20at%2011.47.01%20PM-1.mov?csf=1&web=1&e=cj0Uzq

### Assignment 4 (Web App Demo)

A demo video Link: