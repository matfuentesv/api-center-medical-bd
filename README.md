# API Documentation

This API provides endpoints to manage doctors and patients in a medical center system. Users can perform CRUD operations on doctors and patients after authentication.

## Authentication

Authentication is required for accessing all endpoints. Users need to provide their username and password in the request headers for authentication.

## Base URL

The base URL for accessing the API is `http://example.com/api`.

## Endpoints

### 1. Get All Doctors

- **URL:** `/doctors`
- **Method:** GET
- **Authentication Required:** Yes
- **Description:** Retrieves a list of all doctors.
- **Response:**
    - Status Code: 200 OK
    - Body: JSON array containing doctor objects.

### 2. Get Doctor by ID

- **URL:** `/doctors/{id}`
- **Method:** GET
- **Authentication Required:** Yes
- **Description:** Retrieves a specific doctor by their ID.
- **Response:**
    - Status Code: 200 OK
    - Body: JSON object containing the doctor's details.
    - Status Code: 404 Not Found (If the doctor with the specified ID does not exist)

### 3. Create Doctor

- **URL:** `/doctors`
- **Method:** POST
- **Authentication Required:** Yes
- **Description:** Creates a new doctor.
- **Request Body:** JSON object containing the doctor's details.
- **Response:**
    - Status Code: 201 Created
    - Body: JSON object containing the created doctor's details.
    - Status Code: 400 Bad Request (If some parameters are missing in the request body)

### 4. Update Doctor

- **URL:** `/doctors/{id}`
- **Method:** PUT
- **Authentication Required:** Yes
- **Description:** Updates an existing doctor.
- **Request Body:** JSON object containing the updated doctor's details.
- **Response:**
    - Status Code: 200 OK
    - Body: JSON object containing the updated doctor's details.
    - Status Code: 400 Bad Request (If the doctor ID is invalid or some parameters are missing in the request body)
    - Status Code: 404 Not Found (If the doctor with the specified ID does not exist)

### 5. Delete Doctor

- **URL:** `/doctors/{id}`
- **Method:** DELETE
- **Authentication Required:** Yes
- **Description:** Deletes an existing doctor.
- **Response:**
    - Status Code: 200 OK
    - Body: String indicating successful deletion.
    - Status Code: 400 Bad Request (If the doctor ID is invalid or the doctor has associated medical records)
    - Status Code: 404 Not Found (If the doctor with the specified ID does not exist)

### 6. Get All Patients

- **URL:** `/patients`
- **Method:** GET
- **Authentication Required:** Yes
- **Description:** Retrieves a list of all patients.
- **Response:**
    - Status Code: 200 OK
    - Body: JSON array containing patient objects.

### 7. Get Patient by ID

- **URL:** `/patients/{id}`
- **Method:** GET
- **Authentication Required:** Yes
- **Description:** Retrieves a specific patient by their ID.
- **Response:**
    - Status Code: 200 OK
    - Body: JSON object containing the patient's details.
    - Status Code: 404 Not Found (If the patient with the specified ID does not exist)

### 8. Create Patient

- **URL:** `/patients`
- **Method:** POST
- **Authentication Required:** Yes
- **Description:** Creates a new patient.
- **Request Body:** JSON object containing the patient's details.
- **Response:**
    - Status Code: 201 Created
    - Body: JSON object containing the created patient's details.
    - Status Code: 400 Bad Request (If some parameters are missing in the request body)

### 9. Update Patient

- **URL:** `/patients/{id}`
- **Method:** PUT
- **Authentication Required:** Yes
- **Description:** Updates an existing patient.
- **Request Body:** JSON object containing the updated patient's details.
- **Response:**
    - Status Code: 200 OK
    - Body: JSON object containing the updated patient's details.
    - Status Code: 400 Bad Request (If the patient ID is invalid or some parameters are missing in the request body)
    - Status Code: 404 Not Found (If the patient with the specified ID does not exist)

### 10. Delete Patient

- **URL:** `/patients/{id}`
- **Method:** DELETE
- **Authentication Required:** Yes
- **Description:** Deletes an existing patient.
- **Response:**
    - Status Code: 200 OK
    - Body: String indicating successful deletion.
    - Status Code: 400 Bad Request (If the patient ID is invalid or the patient has associated medical records)
    - Status Code: 404 Not Found (If the patient with the specified ID does not exist)

