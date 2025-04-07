# 🧾 Order Service API

This application is a microservice responsible for managing orders, including user and item tracking, message processing via RabbitMQ, and data persistence using PostgreSQL.
![image](https://github.com/user-attachments/assets/33d3b620-aa1e-4b57-94f9-e80c560c513d)


---

## 🔧 Technologies Used

- **Java 17**
- **Spring Boot 3+**
  - Spring Web
  - Spring Data JPA
  - Spring AMQP
- **RabbitMQ**
- **PostgreSQL**
- **Swagger / OpenAPI**
- **Docker (optional)**

---

## 📦 Features

- ✅ Automatically creates orders from messages received via RabbitMQ
- ✅ Tracks the number of orders per user
- ✅ Calculates the total value of each order
- ✅ REST endpoints for:
  - Retrieving order total value
  - Retrieving order count by user
  - Retriebing  all orders with item details by user

---

## 🚀 Running the Project Locally

### Prerequisites

- Java 17+
- Maven
- Docker (optional for RabbitMQ and PostgreSQL)

