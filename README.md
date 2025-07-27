
# Service Object Model API Framework

A scalable API test automation framework built using **Java**, **Rest Assured**, and **TestNG**, implementing the **Service Object Model (SOM)** design pattern. This project is designed to simplify and structure REST API testing with maintainability and reusability in mind.

---

## 🚀 Design Patterns Used

| Pattern                    | Purpose |
|---------------------------|---------|
| **Lazy-loaded Singleton** | Ensures `RequestSpecification` or `TokenManager` is initialized only once when needed. |
| **Enum Singleton**        | Provides thread-safe singleton with serialization protection for token management eg: SPotifyConstants. |
| **Builder Pattern**       | Used to create complex request payloads with readable and flexible object creation. - eg:requestModels |
| **Factory Pattern**       | For creating service class and specification objects cleanly and centrally. |

---

## 🧱 Features

- Java + Rest Assured based testing
- TestNG as the test runner
- SOM (Service Object Model) to structure test flow
- Token management via Singleton pattern
- Factory class for `RequestSpecification`
- Reusable `BaseTest` class setup
- Test data handled via JSON payloads
- Clear separation between services, tests, and constants

---

## 📁 Project Structure

```
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── factory
│   │   │   ├── pojo
│   │   │   ├── services
│   │   │   ├── utils
│   ├── test
│   │   ├── java
│   │   │   ├── tests
│   │   │   └── base
```

---

## 🛠 Tech Stack

- Java 11+
- Rest Assured
- TestNG
- Jackson (for JSON <-> POJO)
- Maven

---

## 🧪 How to Run Tests

```bash
mvn clean test
```

You can customize `testng.xml` for selective execution.

---

## 🔑 Authentication

Token is generated once using `TokenManager` and shared across services using:
```java
.header("Authorization", "Bearer " + TokenManager.getToken())
```

---

## 🧪 Sample Test (Search Test)
```java
public class SearchTest extends BaseTest {
    @Test
    public void searchArtistTest() {
        SearchService searchService = ServiceFactory.getSearchService();
        Response response = searchService.searchArtist("A R Rahman");
        response.then().statusCode(200);
    }
}
```

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

---

## 📌 Author

**Krishna Kumar**  
[GitHub](https://github.com/Krishna9566)  
[LinkedIn](https://www.linkedin.com/in/krishna-kumar-qa)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
