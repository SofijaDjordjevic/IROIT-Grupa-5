📚 Bookstore App 

This project is a simple Spring Boot–based application built as part of a training workflow.
The repository demonstrates a complete development process, including feature branching, pull requests, automated testing, and continuous integration.

🚀 Project Overview

The goal of this project is to practice:

- Working with Git branching strategies

- Creating and reviewing pull requests

- Writing unit tests and integration tests

- Using Mockito and MockMVC for test isolation

- Setting up GitHub Actions for continuous integration

- Preparing the project for containerization with Docker (future step)

The application is a minimal Bookstore system built with Spring Boot and Maven.

🗂️ Branching Workflow

The repository contains two main branches:

- main – the stable branch containing production-ready code

- INT-1 – the feature/practice branch used for:

  - Creating and merging pull requests
  
  - Testing CI workflow
  
  - Experimenting with new features

This setup was used to simulate a real collaborative environment and practice proper Git workflows.

🧪 Testing

The project includes an expanded test suite containing:

✔ Unit Tests

- Written using JUnit 5

- Mocking dependencies with Mockito

- Verifying service-layer logic in isolation

✔ Integration Tests

- Using MockMVC to test API endpoints

- Loading minimal application context

- Verifying full request–response flow

The intention is to ensure both individual components and the entire system behave correctly.

⚙️ Continuous Integration (GitHub Actions)

A GitHub Actions CI pipeline was added to automate the build and testing process.

The workflow includes:

- Checking out the repository

- Setting up Java 17

- Running mvn clean verify

- Executing both unit and integration tests

- Ensuring the project builds successfully before changes are merged

This provides consistent validation for every push and pull request.

🛠️ Technologies Used

- Java 17

- Spring Boot

- Maven

- JUnit 5

- Mockito

- MockMVC

- GitHub Actions

- (Future scope) Docker

📌 Purpose of the Project

This repository was created as part of an educational workflow to help understand:

- Clean development practices

- Test-driven and integration-driven development

- CI/CD basics

- Proper Git organization

- How a real-world Spring Boot project is structured

It serves as a compact but complete example of a professional backend workflow.
