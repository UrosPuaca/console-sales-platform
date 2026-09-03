
---

## How to Run

> Requires a Java JDK and a running MySQL database.

1. Create the database and configure connection settings (URL, username, password) in the server's external configuration file.
2. Open the three projects in your IDE (NetBeans, since these are Ant-based projects).
3. Add the **Common** project as a library/dependency to both **Server** and **Client**.
4. Start the **Server** first, then run the **Client**.
5. Log in and use the application.

---

## Documentation

📄 [Full project documentation (PDF)](UP_PS_DOK_1.pdf)

---

## Note

This project was developed as part of university coursework. It focuses on demonstrating
architecture and design patterns rather than production-grade concerns (e.g. it uses plain
`Statement` queries and a single shared DB connection, which in a production system would be
replaced by prepared statements and a connection pool).
