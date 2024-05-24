# US 1007


## 1. Context

* This task was included in the team's to-do list during sprint 2
  and is expected to be finished within the same sprint.
## 2. Requirements

**US 1007** As Customer Manager, I want to setup the phases of the process for a job opening.

– Priority: 1

**Acceptance Criteria:**

- 1007.1. The system should provide a user interface for the Customer Manager to create, edit, and delete job opening phases.
- 1007.2. Each phase should have a name, description, and optional duration.
- 1007.3. Phases should be customizable in terms of their sequence and visibility to other stakeholders involved in the hiring process.

**Dependencies/References:**

*Regarding this requirement we understand that it relates to...*

## 3. Analysis

* In this section, the team conducted an analysis to understand the requirements and dependencies of setting up phases for a job opening. We examined existing systems for similar functionalities and identified key components necessary for effective phase management.

## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (presenting the classes that support the functionality), the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*

### 4.1. Realization

* The realization of the functionality involves providing a user-friendly interface for the Customer Manager to perform CRUD operations on job opening phases. This interface should allow customization of phase details such as name, description, duration, sequence, and visibility.

### 4.3. Applied Patterns

* MVC (Model-View-Controller) Pattern: Separation of concerns between UI, controller, and model components.

* Repository Pattern: ClientUserRepository and JobOpeningRepository are used to manage data persistence and retrieval, abstracting the underlying data access implementation.


## 5. Implementation

The implementation of the phase management functionality adheres to the design specifications outlined above. Regular code reviews and automated tests ensure that the implementation aligns with the intended functionality.

## 6. Integration/Demonstration

* We can see all the integration and we can have a demonstration of the success of this User Story opening the project and register as Customer Manager and selecting the option "Update a Job Opening"


