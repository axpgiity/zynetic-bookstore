### 📄 `Akshansh Pandey - Backend Development - Java Spring Boot`

```markdown
#  Bookstore API – Spring Boot + PostgreSQL

A RESTful API for managing a bookstore with JWT-based authentication, built using Java, Spring Boot, and PostgreSQL.

---

## Features

- **User Authentication** (JWT)
  - Signup / Login
  - Secured Book APIs
- **Book Management (CRUD)**
  - Create / Read / Update / Delete books
- **Filtering & Search**
  - Filter by author, category, rating
  - Search by title (partial match)
- **Error Handling**
  - Input validation
  - Proper HTTP status codes

---

## Setup Instructions

1. Create a PostgreSQL database (e.g. `bookstoredb`)
2. Add your credentials in `application.properties`:

```properties
spring.application.name=bookStore

spring.datasource.url=jdbc:postgresql://localhost:5432/BOOK_STORE
spring.datasource.username=postgres
spring.datasource.password=230705

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

logging.level.org.springframework.security = debug
```

3. Build and Run the application:
```bash
./mvnw spring-boot:run
```

---

##  Auth API

### Signup
```bash
curl -X POST http://localhost:8080/auth/signup \
  -H "Content-Type: application/json" \
  -d '{"email":"user@example.com", "password":"pass123"}'
```

### Login
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"user@example.com", "password":"pass123"}'
```

---

##  Book API (Use token in Authorization header)

### Create Book
```bash
curl -X POST http://localhost:8080/books \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{"title":"Book","author":"Author","category":"Fiction","price":300,"rating":4.5,"publishedDate":"2023-01-01"}'
```

### Get All / Get by ID / Update / Delete
```bash
GET    /books
GET    /books/{id}
PUT    /books/{id}
DELETE /books/{id}
```

---

## 🔍 Filters & Search

- `/books?author=...`
- `/books?category=...`
- `/books?rating=...`
- `/books?search=keyword`

---

## 🖼️ Screenshots

- ✅ **Register**  
  ![Register](https://github.com/user-attachments/assets/8cc0d1dd-e18b-4403-8a05-fa1e865d13e4)

- ✅ **Login**  
  ![Login](https://github.com/user-attachments/assets/9707467e-845a-41f5-ae5b-57675fc383cf)

- ✅ **Add Book**  
  ![Upload](https://github.com/user-attachments/assets/6f81138b-5252-49c9-94ba-01512fd2cfd4)

- ✅ **Delete Book**  
  ![Delete](https://github.com/user-attachments/assets/75363763-1445-4279-bc43-02742255f3a6)

- ✅ **Search**  
  ![Search](https://github.com/user-attachments/assets/f5ae4bd9-6940-47c6-b695-f712a495cd51)

- ✅ **Get All Books**  
  ![Get Read All](https://github.com/user-attachments/assets/f51436b7-b77e-4aba-a1d7-196fa06c57cc)


