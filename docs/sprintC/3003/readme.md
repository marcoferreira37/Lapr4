# US 3003

## 1. Context

This task involves implementing the functionality for customers to receive notifications in their application
when the state (phase) of their job openings changes.
It's essential for customers to stay updated on the progress of their job openings.
This task is being assigned for development in this sprint.

## Client Specifications

> * **Question:** Q240 Rodrigo Castro – US3003 - No âmbito da visualização de notificações
> * na app de cliente deseja que a listagem tenha algo em específico por
> * exemplo, apenas as não lidas (consequentement terá de haver uma opção
> * marcar como lida).
> * **Answer:** A240. Sim, para mim faz sentido que o conceito de notificação tenha uma opção de
> * marcar como lida a notificação. Deve ser possível ver as notificações “já lidas” (algo como
> * ver “todas” ou ver “todas a partir de uma data”).

## 2. Requirements

**US 3003** As Customer, I want to be notified in my application when the state (phase) of my job openings changes.

**Acceptance Criteria:**

- 3003.1. The system should allow customers to receive notifications in their application when the state of their job
  openings changes.
- 3003.2. Notifications should be timely and accurately reflect the current state of the job openings.
- 3003.3. The solution follows a client-server architecture, where the Customer application accesses the server
  application.
- 3003.4. Customers should have the option to customize notification preferences for different types of state changes.
- 3003.5. The solution is deployed across several network nodes, with the relational database server and the Follow Up
  Server deployed on different nodes.

**Dependencies/References:**

- NFR10(RCOMP) - Functionalities related to the Candidate and Customer Apps and to the Follow Up Server part of the
  system have very specific technical requirements. It must follow a client-server architecture, where a client
  application is used to access a server. Communications between these two components must follow specific protocol
  described in a document from RCOMP ("Application Protocol"). Also, the client applications can not access the
  relational database, they can only access the server application.
- NFR11(RCOMP) - The solution should be deployed using several network nodes. It is expected that, at least, the
  relational database server and the Follow Up Server be deployed in nodes different from localhost, preferably in the
  cloud. The email notification tasks must be executed in background by the Follow Up Server.
  *Depends on the US1007*

## 3. Analysis

During the analysis phase, we conducted a study to understand the requirements for notifying customers
about changes in the state of their job openings. We considered factors such as the frequency of notifications,
the types of state changes to be notified, and the customization options for notification preferences.
Additionally, considerations are made regarding the technical requirements specified in NFR10(RCOMP) and NFR11(RCOMP)
and the use of a client-server architecture for communication.

### 3.1. Domain Model

![Domain Model](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintC\1013\svg\1013-domain-model.svg)

## 3.2 System Sequence Diagram

The system sequence diagram details the interactions needed for a customer to view their notifications.
The customer application sends a request to the server application to retrieve the notifications.
The server application retrieves the notifications from the database and sends them back to the customer application.

![System Sequence Diagram - Full](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintC\1013\svg\1013-system-sequence-diagram-System_Sequence_Diagram__SSD____Rank_Candidates_for_a_Job_Opening.png)

## 4. Design

### 4.1. Realization

- This section outlines the design decisions and the architectural patterns used to implement the notification feature.
  The notification system is implemented using a client-server architecture, where the customer application communicates
  with the server application to retrieve notifications.

## 4.2 Sequence Diagram

- For the new user story, the sequence diagram details the interactions needed for a customer to view their
  notifications.
  Implementation details for the notification system include creating the necessary entities and services to handle
  notification generation and retrieval based on job opening phase changes.
  The sequence diagram illustrates the interactions between the customer application, server application, and database.

![Sequence Diagram - Full](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintC\1013\svg\1013-sequence-diagram.png)

### 4.3. Use Case Diagram

- The use case diagram illustrates the interactions between the customer and the notification system.

![Use Case Diagram](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintC\1013\svg\1013-sequence-diagram.png)

## 5. Implementation

- The notification feature was integrated into the existing job opening management system.
  The implementation details include creating the necessary entities and services to handle notification generation and
  retrieval based on job opening phase changes.
- The system ensures that customers are kept up-to-date with the latest developments in their job openings.

## 6. Integration/Demonstration

- The notification feature was thoroughly tested and demonstrated to validate its functionality and usability.
- The demonstration showcased how customers can efficiently receive notifications in their application when the state of
  their job openings changes.

## 7. Observations

Observations during the implementation and testing phases revealed the importance of handling edge cases,
such as the rapid succession of phase changes, which could lead to notification overload.
These issues were addressed by implementing rate-limiting and batching techniques to ensure a smooth user experience.