# Enviro365Application
REST endpoints to enable communication between the frontend and backend systems of the application.

Overview
This project is aimed at managing waste data for environmental assessment. It provides endpoints to handle waste categories, disposal guidelines, and recycling tips.

Features
Waste Categories: CRUD operations for managing waste categories.
Disposal Guidelines: CRUD operations for managing disposal guidelines.
Recycling Tips: CRUD operations for managing recycling tips.
Technologies Used
Java
Spring Boot
Maven
Spring Data JPA
H2 Database
Jakarta EE (Java EE) for API specifications


Installation
Clone the repository: git clone https://github.com/thebeetsile/Enviro365Application.git
Navigate to the project directory: cd Enviro365Application
Build the project: mvn clean install
Run the application: mvn spring-boot:run


Usage

Access the application via the following endpoints:
Waste Categories: /api/waste-categories
Disposal Guidelines: /api/disposal-guidelines
Recycling Tips: /api/recycling-tips

Use Postman or any REST client to interact with the endpoints.
Sample Requests:
Create Waste Category
URL: POST /api/waste-categories
Body:
json

{
  "name": "Category Name",
  "description": "Category Description"
}

Get All Waste Categories
URL: GET /api/waste-categories

Get Waste Category by ID
URL: GET /api/waste-categories/{id}

Delete Waste Category
URL: DELETE /api/waste-categories/{id}

(Repeat similar sections for Disposal Guidelines and Recycling Tips)

Contribution
Contributions are welcome! If you have any suggestions, feature requests, or found a bug, please open an issue or create a pull request.

License
This project is licensed under the MIT License.
