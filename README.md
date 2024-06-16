# Spring Boot Social Fitness Web App Backend

## Overview
This repository contains the backend implementation for a social fitness web application built using Spring Boot. It provides various RESTful APIs to manage users, fitness activities, social interactions, and more. 

## Features
- **User Management**: Registration, authentication, and profile management.
- **Fitness Activities**: CRUD operations for workouts, exercises, and tracking progress.
- **Social Interaction**: Follow friends, share activities, and view fitness feeds.
- **Security**: Implemented with Spring Security for authentication and authorization.
- **Database Integration**: Uses MySQL for persistent data storage.
- **Testing**: Includes unit and integration tests to ensure robustness.
- **Posting and Sharing**: Users can share posts and videos.
- **Interaction**: Users can comment on and like relevant posts.
- **Profile Management**: Users can manage their own posts and view other user profiles.
- **Following System**: Users can follow others and view posts across different profiles.
- **Comment Management**: Users can delete and update their comments.
- **Messaging**: Users can send internal messages through a message box system.

## Project Structure
- **src/main/java/com/socialfitness**: Contains the main application code.
  - **config**: Configuration files for CORS and other settings.
  - **controller**: REST controllers handling HTTP requests.
  - **exceptions**: Custom exceptions for user management and other functionalities.
  - **models**: Entity classes representing database tables.
  - **repository**: Data access layer using Spring Data JPA.
  - **request**: Classes for handling incoming requests.
  - **response**: Classes for formatting outgoing responses.
  - **service**: Business logic and service layer.

## Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/Chanuth-silva10/spring-boot-social-fitness-web-app-backend-new.git
   ```
2. Navigate to the project directory:
   ```bash
   cd spring-boot-social-fitness-web-app-backend-new
   ```
3. Build the project:
   ```bash
   ./mvnw clean install
   ```
4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
5. Access the application at `http://localhost:8080`

## Dependencies
Spring Boot
Spring Security
Spring Data JPA
MySQL
Maven
Spring Socket
