# US 1009

## 1. Context

* This task was included in the team's to-do list during sprint 2
  and is expected to be finished within the same sprint.

## 2. Requirements

**US 1009** As Customer Manager, I want to select the requirements specification to be used for a job opening.

– Priority: 1

– References: See NFR09(LPROG).

## 3. Analysis

* To determine the best design for this requirement, the team conducted a thorough analysis of current job opening management systems. Key considerations included ease of use for the Customer Manager, integration with existing HR systems, and compliance with relevant legal and organizational standards. The team reviewed various domain models and use case diagrams to ensure a comprehensive understanding of the requirements. The analysis included the following:

* Comparison of different requirements management tools.
Interviews with Customer Managers to gather user insights.
Review of industry standards and best practices.

## 4. Design

### 4.1. Realization

* The realization phase focused on creating a sequence diagram to illustrate the workflow for selecting a requirements specification for a job opening. This diagram includes interactions between the Customer Manager, the system, and the requirements database.

### 4.2. Class Diagram

![Class Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintB\1009\CD\US1009_DM.svg)


### 4.3. Sequence Diagram

![Sequence Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintB\1009\SD\US1009-SD.svg)


### 4.4. Applied Patterns

* MVC (Model-View-Controller) Pattern: Separation of concerns between UI, controller, and model components.

* Repository Pattern: ClientUserRepository and JobOpeningRepository are used to manage data persistence and retrieval, abstracting the underlying data access implementation.


## 5. Implementation

* The implementation of the requirements attribution functionality adheres to the design specifications outlined above. Regular code reviews and automated tests ensure that the implementation aligns with the intended functionality.

## 6. Integration/Demonstration

* We can see all the integration and we can have a demonstration of the success of 
  this User Story opening the project and register as Customer Manager and selecting the option 
  "Update a Job Opening"
