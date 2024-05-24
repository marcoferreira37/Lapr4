# UC 2002 -  To register a application

---

## 1. Requirements Engineering and Analysis


### 1.1. User Case Description and Context

As Operator , I want to register an application of a candidate for a job opening and
import all files received.


This requirement is related to the registration of an Application in the system.

An Application refers to the materials submitted by a candidate to apply for a specific job opening

### 1.2. Acceptance Criteria

* **AC1**: The system should check if the application already exists based on a unique identifier, such as the id, and reject the operation if a duplicate entry is detected.
* **AC2**: To register an application, an Operator must be logged in the system.
* **AC3**: After the creation of the application, it should be possible to view the application in the system.
* **AC4**: The system should validate the application's directory path.
* **AC5**: The system should move the application's directory to the imported applications directory after successful registration.
* **AC6**: The system should display a success message after the successful registration of the application.

### 1.3 Input and Output Data

**Input Data:**

* Path of file

**Selected Data:**
* Application

**Output Data:**

(In)Success of the operation

### 1.4. System Sequence Diagram (SSD)

[SSD](2002-system-sequence-diagram.puml)


## 2. Analysis


### 2.1. Domain Model

The domain model is composed of the following entities:

- **User**: Represents a user with a role in the system.
- **Shared Object**: Represents an object shared between different entities in the system.
- **Job Opening Application**: Represents the application submitted by a candidate for a job opening.
- **Job Opening**: Represents a job opening in the system.
[Domain Model](C:\Users\Utilizador\Desktop\sem4pi-23-24-2dh3\final\docs\sprintB\2002\2002-domain-model.puml)


This use case is relatively straightforward, as it primarily involves the creation of an application.
For this, an operator needs to log into the system, and then provide the necessary information to register an application.

## 3. Design

### 3.1. Sequence Diagram

This sequence diagram represents the case of a successful registration of an Application.

[Sequence Diagram](2002-sequence-diagram-puml.puml)
