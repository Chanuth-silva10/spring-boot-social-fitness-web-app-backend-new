# 🏋️ Spring Boot Social Fitness Web App Backend

## 📋 Overview
A comprehensive backend implementation for a social fitness web application built with Spring Boot. This application provides RESTful APIs for users to share their fitness journey, connect with others, track workout goals, share meal plans, and engage in a fitness-focused social community.

## ✨ Features

### 🔐 Authentication & User Management
- **User Registration & Login**: Secure JWT-based authentication
- **Profile Management**: Complete user profile with images and personal details
- **Following System**: Follow/unfollow other users
- **User Search**: Find users by name or email

### 📱 Social Features
- **Posts**: Share fitness-related content with images and videos
- **Reels**: Short video content sharing
- **Comments**: Comment on posts, meal plans, workout goals, and status updates
- **Likes**: Like posts, comments, meal plans, and workout goals
- **Following Feed**: View content from followed users

### 🏃‍♂️ Fitness Tracking
- **Workout Goals**: Set and track fitness goals (distance, push-ups, weight lifting)
- **Workout Status**: Share current workout achievements
- **Meal Plans**: Share and discover healthy meal plans with recipes
- **Dietary Preferences**: Customize meal plans based on dietary needs

### 💬 Interaction System
- **Multi-type Comments**: Comment on posts, meal plans, goals, and status updates
- **Like System**: Like various types of content
- **Social Engagement**: Build a community around fitness goals

## 🏗️ Project Structure
```
src/main/java/com/socialfitness/socialfitness/
├── 📁 config/           # JWT, Security, CORS configurations
├── 📁 controller/       # REST API controllers
├── 📁 exceptions/       # Custom exception handling
├── 📁 models/          # JPA entity classes
├── 📁 repository/      # Data access layer
├── 📁 request/         # Request DTOs
├── 📁 response/        # Response DTOs
└── 📁 service/         # Business logic layer
```

## 🔗 API Endpoints

### Authentication
- `POST /auth/signup` - User registration
- `POST /auth/signin` - User login

### User Management
- `GET /api/users` - Get all users
- `GET /api/users/{userId}` - Get user by ID
- `GET /api/users/profile` - Get current user profile
- `PUT /api/users` - Update user profile
- `PUT /api/users/follow/{userId}` - Follow/unfollow user
- `GET /api/users/search?query={query}` - Search users
- `DELETE /api/users/{userId}` - Delete user

### Posts
- `POST /api/posts` - Create new post
- `GET /api/posts` - Get all posts
- `GET /api/posts/{postId}` - Get post by ID
- `GET /api/posts/user/{userId}` - Get posts by user
- `PUT /api/posts/{postId}` - Update post
- `PUT /api/posts/like/{postId}` - Like/unlike post
- `DELETE /api/posts/{postId}` - Delete post

### Workout Goals
- `POST /api/goal` - Create workout goal
- `GET /api/goals` - Get all workout goals
- `GET /api/goals/{goalId}` - Get goal by ID
- `GET /api/goals/user/{userId}` - Get goals by user
- `PUT /api/goals/{goalId}` - Update workout goal
- `PUT /api/goals/like/{goalId}` - Like/unlike goal
- `DELETE /api/goals/{goalId}` - Delete goal

### Meal Plans
- `POST /api/meals` - Create meal plan
- `GET /api/meals` - Get all meal plans
- `GET /api/meals/{mealId}` - Get meal plan by ID
- `GET /api/meals/user/{userId}` - Get meal plans by user
- `PUT /api/meals/{mealId}` - Update meal plan
- `PUT /api/meals/like/{mealId}` - Like/unlike meal plan
- `DELETE /api/meals/{mealId}` - Delete meal plan

### Reels
- `POST /api/reels` - Create reel
- `GET /api/reels` - Get all reels
- `GET /api/reels/user/{userId}` - Get reels by user

### Comments
- `POST /api/comments/post/{postId}` - Comment on post
- `POST /api/comments/goal/{goalId}` - Comment on workout goal
- `POST /api/comments/meal/{mealId}` - Comment on meal plan
- `POST /api/comments/status/{statusId}` - Comment on workout status
- `PUT /api/comments/like/{commentId}` - Like/unlike comment

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

### Installation
1. **Clone the repository**
   ```bash
   git clone https://github.com/Chanuth-silva10/spring-boot-social-fitness-web-app-backend-new.git
   cd spring-boot-social-fitness-web-app-backend-new
   ```

2. **Configure Database**
   - Create a MySQL database named `social_fitness`
   - Update `src/main/resources/application.properties` with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/social_fitness
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Build and Run**
   ```bash
   # Using Maven Wrapper (recommended)
   ./mvnw clean install
   ./mvnw spring-boot:run
   
   # Or using Maven (if installed globally)
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access the Application**
   - API Base URL: `http://localhost:5454`
   - The application will automatically create database tables on first run

## 🛠️ Technology Stack

| Technology | Purpose |
|------------|---------|
| **Spring Boot 3.2.4** | Main framework |
| **Spring Security** | Authentication & authorization |
| **Spring Data JPA** | Data persistence |
| **JWT (jsonwebtoken)** | Token-based authentication |
| **MySQL** | Primary database |
| **Lombok** | Reduce boilerplate code |
| **Maven** | Dependency management |

## 📁 Data Models

### Core Entities
- **User**: User profiles with authentication
- **Post**: General social media posts with images/videos
- **WorkOutGoal**: Fitness goals tracking
- **WorkOutStatus**: Current workout status
- **MealPlan**: Nutrition and meal planning
- **Reels**: Short video content
- **Comment**: Comments on various content types

## 🔒 Security
- JWT-based stateless authentication
- Role-based access control
- Password encryption using BCrypt
- Protected API endpoints with proper authorization

## 🧪 Testing
Run the test suite:
```bash
./mvnw test
```

## 📝 Configuration
Key configuration files:
- `application.properties` - Database and server configuration
- Security configuration in `config/` package
- JWT settings and validation

## 👥 Author
**Chanuth Silva** - [GitHub Profile](https://github.com/Chanuth-silva10)


---
⭐ **Star this repository if you find it helpful!**
