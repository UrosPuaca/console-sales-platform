# Console Sales Platform

> **Academic / University Project** — built for a software engineering course to demonstrate client-server architecture, design patterns, and layered application design.

A client-server desktop application for managing console sales — invoices, customers, and sellers. Built in Java with a multithreaded socket server, a generic repository layer, and a Swing desktop client.

## Overview

The system is split into three independent modules that communicate over TCP sockets:

- **Common** — shared domain models and the communication protocol (Request/Response objects, operation enum). Used by both client and server.
- **Server** — multithreaded socket server that processes client requests, applies business logic, and persists data to a relational database.
- **Client** — Swing desktop application (forms + controllers) that sends requests to the server and displays results.

A request flows from a client form, through the network layer, to the server, where it is executed as a system operation against the database, and the result travels back to the client.

## Architecture & Design Patterns

The project was built to demonstrate several core software engineering concepts:

- **Multithreaded server** — the server accepts connections in a loop and spawns one dedicated thread per connected client, allowing multiple clients to be served in parallel.
- **Template Method** — an abstract generic operation defines a fixed transactional skeleton (preconditions, begin transaction, execute, commit/rollback); concrete operations fill in only the variable steps.
- **Repository pattern** — data access is abstracted behind a repository interface, so business logic does not depend on database details.
- **Generic CRUD** — a single generic repository handles all tables; each domain object describes how it maps to the database, so adding a new entity requires no changes to the data layer.
- **Singleton** — used for the controller, database connection factory, and configuration.
- **MVC (client side)** — forms (View), controllers (Controller), and domain/table models (Model) are cleanly separated.

## Tech Stack

- **Java** (Swing for the desktop UI)
- **Java Sockets** for client-server communication
- **Object serialization** for transferring requests/responses
- **JDBC** for database access
- **Relational database** (MySQL)

## Project Structure

- `UP_PS_ZAJEDNICKI/` — Common (shared domain models + communication protocol)
- `UP_PS_SERVER/` — Server (socket server, system operations, repository, DB access)
- `UP_PS_KLIJENT/` — Client (Swing forms, controllers, table models)

## How to Run

Requires a Java JDK and a running MySQL database.

1. Create the database and configure connection settings (URL, username, password) in the server's external configuration file.
2. Open the three projects in your IDE (NetBeans, since these are Ant-based projects).
3. Add the **Common** project as a library/dependency to both **Server** and **Client**.
4. Start the **Server** first, then run the **Client**.
5. Log in and use the application.

## Documentation

[Full project documentation (PDF)](UP_PS_DOK_1.pdf)

## Note

This project was developed as part of university coursework. It focuses on demonstrating architecture and design patterns rather than production-grade concerns (e.g. it uses plain Statement queries and a single shared DB connection, which in a production system would be replaced by prepared statements and a connection pool).
