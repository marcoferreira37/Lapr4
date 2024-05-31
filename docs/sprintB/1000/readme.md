# US 1000


## 1. Context

* This task was included in the team's to-do list during sprint 2
  and is expected to be finished within the same sprint.

## 2. Requirements

**US 1000** As Administrator, I want to be able to register, disable/enable, and list users of the backoffice.

– Priority: 1

– References: Alternatively this can be achieved by a bootstrap process

**Acceptance Criteria:**

- 1000.1. The password must contain at least one number and one capital letter

- 1000.2. The email should contain an "@" and a "."

## 3. Analysis

* For the analysis of the requirement to register, disable/enable, and list users in the back office,
  our team conducted a thorough study to ensure that the design decisions were optimal and aligned with 
  the system's goals. We began by examining similar functionalities in existing systems to understand common patterns.
* Additionally, we analyzed the specific needs and constraints of our system to tailor the solution accordingly.

## 4. Design

### 4.1. Realization

* In this section, we present the design solution adopted to fulfill the requirement of user management in the back office.

## 4.2 Class Diagram

![Class Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintB\1000\1000.1_RegisterUser\US1000_CD1.svg)

![Class Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintB\1000\1000.2_DisableUser\US1000_CD2.svg)

![Class Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintB\1000\1000.3_EnableUser\US1000_CD3.svg)

![Class Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintB\1000\1000.4_ListUsers\US1000_CD4.svg)

## 4.3. System Sequence Diagram

![System Sequence Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintB\1000\1000.1_RegisterUser\US1000_SD1-UI.svg)

![System Sequence Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintB\1000\1000.2_DisableUser\US1000_SD2.svg)

![System Sequence Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintB\1000\1000.3_EnableUser\US1000_SD3.svg)

![System Sequence Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintB\1000\1000.4_ListUsers\US1000_SD4.svg)

### 4.4. Applied Patterns

* MVC (Model-View-Controller) Pattern: Separation of concerns between UI, controller, and model components.

* Repository Pattern: ClientUserRepository and JobOpeningRepository are used to manage data persistence and retrieval, abstracting the underlying data access implementation.


## 5. Implementation

In this section, we provide insights into the implementation of the user management functionality, ensuring alignment with the previously presented design. We include evidence of adherence to the design and discuss relevant artifacts such as configuration files.

To ensure that the implementation accurately reflects the design, we conducted regular code reviews.


## 6. Integration/Demonstration

* We can see all the integration, and we can have a demonstration of the success of this User 
  Story opening the project and register as Admin, selecting the options "Regist a candidate",
  "List all candidates", "Enable a candidate", "Enable a candidate" we will see the Use Cases  
  all the use cases working correctly.

