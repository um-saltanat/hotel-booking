# Hotel Booking API

## Project Description

This project implements a hotel booking system using Java Spring Boot. It provides a RESTful API for managing hotel room reservations. The API includes CRUD operations for rooms and reservations, as well as functionality to search for available rooms.

## Features

- **Manage Rooms**: Create, Read, Update, Delete hotel rooms.
- **Manage Reservations**: Create, Read, Update, Delete reservations.
- **Search Available Rooms**: Find available rooms based on search criteria (e.g., dates, room type).
- **Room Availability Check**: Check if a room is available for booking on specific dates.

## Technologies Used

- Java 17
- Spring Boot 3.3.4
- Spring Data JPA
- H2 Database (for development and testing)
- Spring Security (optional for authentication and authorization)

## API Endpoints

### Rooms

- **GET /rooms**: Retrieve a list of all hotel rooms.
- **POST /rooms**: Create a new room.
- **PUT /rooms/{id}**: Update details of a room.
- **DELETE /rooms/{id}**: Delete a specific room.

### Reservations

- **GET /reservations**: Retrieve all reservations.
- **POST /reservations**: Create a new reservation.
- **GET /reservations/{id}**: Get details of a specific reservation.
- **PUT /reservations/{id}**: Update reservation details.
- **DELETE /reservations/{id}**: Cancel a reservation.

### Room Availability

- **GET /rooms/available**: Search for available rooms based on check-in and check-out dates.

## Setup and Installation

### Prerequisites

- JDK 17 or higher
- Maven
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Clone the Repository

```bash
git clone https://github.com/um-saltanat/hotel-booking-api.git
cd hotel-booking-api
