A simple, containerized Spring Boot application that manages Software Engineer profiles using Spring Data JPA, PostgreSQL, Docker, and RESTful APIs.

# ✨ Features
- CRUD operations for Software Engineer entities (Create, Read, Update, Delete)

- REST API endpoints for easy integration and testing

- PostgreSQL integration via Spring Data JPA

- Dockerized for simple local deployment

- API testing using IntelliJ HTTP Client (httpRequest.http)

# 🛠️ Tech Stack
- Java 17

- Spring Boot 3.x

- Spring Data JPA

- PostgreSQL

- Docker & Docker Compose

# 📂 Project Structure

├── src/main/java/com/project/SpringBootApi
│   ├── controllers            # REST controllers
│   ├── entities               # JPA entities
│   ├── repositories           # Spring Data JPA repositories
│   ├── services               # Business logic layer
│   └── SpringBootApiApplication.java  # Main Spring Boot class
├── src/main/resources
│   └── application.properties # App configuration
├── docker-compose.yml         # Docker setup
├── httpRequest.http           # API testing (IntelliJ HTTP Client)
└── pom.xml                    # Maven configuration


# 🚀 Getting Started
- Prerequisites
Java 17+
Docker & Docker Compose
Run with Docker
docker-compose up --build
The application will be available at:
http://localhost:8080

# 📬 API Endpoints

Method	Endpoint	Description
GET	/api/software-engineers	Get all software engineers
POST	/api/software-engineers	Create new engineer
GET	/api/software-engineers/{id}	Get engineer by ID
PUT	/api/software-engineers/{id}	Update engineer
DELETE	/api/software-engineers/{id}	Delete engineer
You can test these using httpRequest.http or any REST client.

# 🐳 Docker Compose Services
app – Spring Boot API (port 8080)

db – PostgreSQL (port 5432)
