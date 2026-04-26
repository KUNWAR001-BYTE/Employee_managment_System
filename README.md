# Employee Management System 

A backend REST API built with **Java** and **Spring Boot** for managing employee records. Supports full CRUD operations, input validation, and search functionality using an H2 in-memory database.

---

##  Tech Stack

| Technology | Usage |
|---|---|
| Java | Core programming language |
| Spring Boot | Backend framework |
| H2 Database | In-memory database |
| Spring Data JPA | Database interaction |
| Maven | Dependency management |
| Postman | API testing |

---

##  Features

- ✅ Add a new employee
- ✅ View all employees
- ✅ View employee by ID
- ✅ Update employee details
- ✅ Delete employee
- ✅ Input validation on all fields

---

##  Project Structure

```
src/
├── main/
│   ├── java/com/example/SpringBoot_web/
│   │   ├── Employee_controler.java      # REST Controller
│   │   ├── EmployeeService.java         # Business Logic
│   │   ├── EmployeEntity.java           # Entity/Model
│   │   └── SpringBootWebApplication.java # Main class
│   └── resources/
│       └── application.properties       # App configuration
└── test/
```

---

##  How to Run

### Prerequisites
- Java 17+
- Maven
- IntelliJ IDEA (recommended)

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/KUNWAR001-BYTE/Employee_managment_System.git
   cd Employee_managment_System
   ```

2. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   Or simply run `SpringBootWebApplication.java` from IntelliJ IDEA.

3. **Access H2 Console (optional)**
   ```
   URL: http://localhost:8080/h2-console
   JDBC URL: jdbc:h2:mem:testdb
   ```

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/employees` | Add a new employee |
| GET | `/employees` | Get all employees |
| GET | `/employees/{id}` | Get employee by ID |
| GET | `/employees/search?name={name}` | Search employee by name |
| PUT | `/employees/{id}` | Update employee details |
| DELETE | `/employees/{id}` | Delete an employee |

---

## Sample Request (Add Employee)

**POST** `/employees`

```json
{
  "name": "Raj Kunwar Rai",
  "department": "Engineering",
  "email": "raj@example.com",
  "salary": 50000
}
```

---

## Author

**Raj Kunwar Rai**
- GitHub: [@KUNWAR001-BYTE](https://github.com/KUNWAR001-BYTE)
- LinkedIn: [Raj Kunwar Rai](https://www.linkedin.com/in/raj-kunwar-rai-aba9a323a/)
- LeetCode: [Raj__00](https://leetcode.com/u/Raj__00/)
