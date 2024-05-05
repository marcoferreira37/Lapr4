# US 1000


## 1. Context

* This task was included in the team's to-do list during sprint 2
  and is expected to be finished within the same sprint.

## 2. Requirements

**US G003** As Administrator, I want to be able to register, disable/enable, and list users of the backoffice.

– Priority: 1

– References: Alternatively this can be achieved by a bootstrap process

**Acceptance Criteria:**

- 1000.1. The password must contain at least one number and one capital letter

- 1000.1. The email should contain an @

## 3. Analysis

* For the analysis of the requirement to register, disable/enable, and list users in the back office, our team conducted a thorough study to ensure that the design decisions were optimal and aligned with the system's goals. We began by examining similar functionalities in existing systems to understand common patterns and potential pitfalls. Additionally, we analyzed the specific needs and constraints of our system to tailor the solution accordingly.

## 4. Design

* In this section, we present the design solution adopted to fulfill the requirement of user management in the back office.

## 5. Implementation

In this section, we provide insights into the implementation of the user management functionality, ensuring alignment with the previously presented design. We include evidence of adherence to the design and discuss relevant artifacts such as configuration files.

Implementation Evidences
To ensure that the implementation accurately reflects the design, we conducted regular code reviews and employed automated testing to validate the functionality. Additionally, we utilized version control system logs to track major commits related to this requirement.

Configuration Files
While the user management functionality primarily relies on application logic and database interactions, certain configuration files play a crucial role in setting up the environment. These files include database configuration files (database.yml) and authentication configuration files (devise.rb), which specify parameters such as database credentials and authentication strategies.

Major Commits
Initial Implementation of User Registration: This commit introduces the basic structure and functionality for registering new users in the system.
Implementation of User Disable/Enable Feature: This commit adds the logic for administrators to disable or enable existing users as per the requirement.
Integration of User Listing Functionality: This commit integrates the functionality to retrieve and display a list of all registered users in the back office.
These major commits represent significant milestones in the implementation process, each contributing to the realization of the user management requirement.

## 6. Integration/Demonstration

In this section, we describe the efforts made to integrate the user management functionality with other parts/components of the system and provide instructions for demonstration.

Integration Efforts
The user management functionality has been seamlessly integrated with the existing authentication system and user interface components of the back office application. Integration tests were conducted to ensure proper interaction between different modules and to identify any potential conflicts or inconsistencies.

Demonstration Instructions
To demonstrate the user management functionality:

Access the Back Office: Log in to the back office application using valid administrator credentials.
Navigate to User Management Section: Locate the user management section within the administrative dashboard.
Register New Users: Use the provided interface to register new users by entering relevant details such as username, email, and password.
Disable/Enable Existing Users: Utilize the provided controls to disable or enable existing users as needed.
View User Listing: Access the user listing page to view a comprehensive list of all registered users, including their details.
By following these instructions, users can effectively explore and interact with the implemented user management functionality within the back office application.

## 7. Observations
