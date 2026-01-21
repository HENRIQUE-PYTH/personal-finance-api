# Personal Finance API

## 📌 Description
This project is a REST API for personal financial management.
It allows users to register financial transactions (income and expenses), manage debts, and retrieve a financial summary with total income, total expenses, and current balance.

The balance is not stored in the database. Instead, it is calculated dynamically based on the user's financial transactions, ensuring data consistency.

---

## 🧠 Features
- User registration and listing
- Financial transaction management (income and expenses)
- Debt registration linked to users
- Financial summary with total income, total expenses, and balance
- Validation of user ownership over resources

---

## 🏗️ Architecture
The application follows a layered architecture:
- **Controller layer**: Handles HTTP requests and responses
- **Service layer**: Contains business rules
- **Repository layer**: Manages database access
- **DTOs and Mappers**: Separate API contracts from domain entities

---

## 🛠️ Technologies Used
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Bean Validation (Jakarta Validation)
- Maven

---

## 🔗 Main Endpoints

### Users
- `POST /usuarios` – Create a user
- `GET /usuarios` – List all users
- `GET /usuarios/{id}` – Get user by ID

### Transactions
- `POST /usuarios/{usuarioId}/lancamentos` – Register a transaction
- `GET /usuarios/{usuarioId}/lancamentos` – List user transactions

### Debts
- `POST /usuarios/{usuarioId}/dividas` – Register a debt
- `GET /usuarios/{usuarioId}/dividas/{id}` – Get debt by ID (user scoped)

### Financial Summary
- `GET /usuarios/{usuarioId}/resumo` – Get financial summary (income, expenses, balance)

---

## ▶️ How to Run the Project

### Prerequisites
- Java 21
- MySQL
- Maven

### Steps
1. Clone the repository
2. Configure the database connection in `application.properties`
3. Run the application using:
   ```bash
   mvn spring-boot:run
   The API will be available at: http://localhost:8080
