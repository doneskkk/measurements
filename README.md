
# Sensor Data Management System

This project is a web-based application for managing sensor data using various Spring technologies such as Spring Boot, Spring Data JPA, and Spring I/O Validation. The system allows users to register new sensors, add new measurements from the sensors, view all measurements, and calculate the number of rainy days.

## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring I/O Validation
- MySQL
- Jackson

## Getting Started

### Prerequisites

- Java 8 or higher
- MySQL Server

### Installation

1. Clone the repository:

   ```
   git clone https://github.com/your_username/sensor-data-management-system.git
   ```

2. Configure the MySQL database:

   - Create a new database with the name "sensor_data_db"
   - Update the database connection settings in the application.properties file

3. Build and run the application:

   ```
   ./mvnw spring-boot:run
   ```

4. Access the application:

   ```
   http://localhost:8080/
   ```

# Functionality
## Sensors endpoints
| HTTP Method | Endpoints | Description|
| - | :- | - |
| POST | /api/v1/sensors/registration | Register a new sensor|

## Measurements endpoints
| HTTP Method | Endpoints | Description|
| - | :- | - |
| POST | /api/v1/measurements/add |Adding new measurement |
| GET | /api/v1/measurements | Get all measurements | 
| GET | /api/v1/measurements/rainyDaysCount|Get the number of rainy days | 
### Registering a new sensor

Users can register new sensors by providing the sensor name

### Adding new measurement

Users can add new measurements from sensors by providing the sensor name , field **isRaining** , and measurement value.

### Get all measurements

Users can view all measurements in the system.

### Get the number of rainy days

The system can calculate the number of rainy days based on the measurements taken by sensors.

## Contributors

- Dones Chiril (@doneskkk)
