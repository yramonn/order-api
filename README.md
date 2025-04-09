# 🧾 Order Service API
The Swagger  of the application is available to everyone on https://order-api-dko6.onrender.com/swagger-ui/index.html
![image](https://github.com/user-attachments/assets/a04bf14e-2f62-4fa5-af2f-029ec2f6c77e)

This application is a microservice responsible to process orders from  RabbitMQ, and persistence datas using PostgreSQL and provides APIs to manage orders.
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
- **Docker**

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
📦 Clone repository
git clone https://github.com/yramonn/order-api.git

☕ Set Up Your Environment
Make sure you have Java 17 and Maven installed and properly configured in your IDE to manage project dependencies.

🐳 Start Services with Docker
un the following command to build and start all required services:
docker-compose up --build

The Docker image is also available on Docker Hub:
🔗 https://hub.docker.com/r/yramonn/order-service

🚀 Useful Endpoints
Swagger UI (API Documentation):
http://localhost:8083/swagger-ui/index.html

RabbitMQ Management UI:
http://localhost:15672

Username: guest

Password: guest

PostgreSQL (Database Connection):

Host: localhost

Port: 5432

Database: order-db

Username: postgres

Password: admin

# Developer
Ramon Silva
https://www.linkedin.com/in/ramon--silva/

