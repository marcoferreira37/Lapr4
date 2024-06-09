# US 3003

## 1. Context

This task involves implementing the functionality for customers to receive notifications in their application
when the state (phase) of their job openings changes. 
It's essential for customers to stay updated on the progress of their job openings.
This task is being assigned for development in this sprint.

## Client Specifications

>* **Question:** Q240 Rodrigo Castro – US3003 - No âmbito da visualização de notificações 
> * na app de cliente deseja que a listagem tenha algo em específico por 
> * exemplo, apenas as não lidas (consequentement terá de haver uma opção 
> * marcar como lida).
> * **Answer:** A240. Sim, para mim faz sentido que o conceito de notificação tenha uma opção de 
> * marcar como lida a notificação. Deve ser possível ver as notificações “já lidas” (algo como 
> * ver “todas” ou ver “todas a partir de uma data”).


## 2. Requirements

**US 3003** As Customer, I want to be notified in my application when the state (phase) of my job openings changes.

**Acceptance Criteria:**

- 3003.1. The system should allow customers to receive notifications in their application when the state of their job openings changes.
- 3003.2. Notifications should be timely and accurately reflect the current state of the job openings.
- 3003.3. The solution follows a client-server architecture, where the Customer application accesses the server application.
- 3003.4. Customers should have the option to customize notification preferences for different types of state changes.
- 3003.5. The solution is deployed across several network nodes, with the relational database server and the Follow Up Server deployed on different nodes.

**Dependencies/References:**
*This requirement relates to NFR10(RCOMP) and NFR11(RCOMP).*

*Depends on the US1007*

## 3. Analysis

During the analysis phase, we conducted a study to understand the requirements for notifying customers 
about changes in the state of their job openings. We considered factors such as the frequency of notifications,
the types of state changes to be notified, and the customization options for notification preferences.
Additionally, considerations are made regarding the technical requirements specified in NFR10(RCOMP) and NFR11(RCOMP) and the use of a client-server architecture for communication.


### 3.1. Domain Model

The domain model is composed of the following entities:

- **JobOpening**: Represents a job opening in the company.
- **Application**: Represents the application of a candidate for a job opening.
- **Phase**: Represents the phase of the application process.
- **Notification**: Represents a notification sent to a customer regarding a job opening.
- **Customer**: Represents a customer who creates job openings and receives notifications.

![Domain Model](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintC\1013\svg\1013-domain-model.svg)


## 3.2 System Sequence Diagram

![System Sequence Diagram - Full](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintC\1013\svg\1013-system-sequence-diagram-System_Sequence_Diagram__SSD____Rank_Candidates_for_a_Job_Opening.png)

The Customer Manager requested a feature to rank the candidates for a job opening.
This feature will allow the manager to rank the candidates, persist the rankings, change the rankings, and view the rankings.
The system should have validations to ensure that the data is valid.


## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. 
This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram),
the identification and rational behind the applied design patterns and the specification of the main tests used to validade
the functionality.*

### 4.1. Realization

The realization of the functionality involves defining how the Customer Manager can rank candidates
and how these rankings are stored and modified in the system.
This requires interactions between various system components including the UI, business logic,
and data persistence layers.


## 4.2 Sequence Diagram

![Sequence Diagram - Full](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintC\1013\svg\1013-sequence-diagram.png)

The sequence diagram shows the interactions between the Customer Manager and the system to rank candidates.
This includes actions like viewing a list of candidates, assigning a rank, saving the rank, and modifying it later.


## 5. Implementation

* The implementation ensures that customers receive timely notifications
in their application when the state of their job openings changes.
Notifications are designed to accurately reflect the current state of the job openings, 
and customers have the flexibility to customize their notification preferences based on their requirements.


## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*
*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

* Efforts have been made to integrate this functionality seamlessly with other parts of the system. 
Notifications are triggered based on changes in the state of job openings and are delivered to customers 
via their application interface.

*To demonstrate this functionality:*

- Log in as a customer.

- Navigate to the section for managing job openings.

- Make changes to the state of a job opening.

- Verify that the customer receives a notification reflecting the state change.

## 7. Observations

This section should be used to include any additional comments or observations regarding the implementation of this functionality. 
It is important to ensure that the notification system is robust and reliable, providing customers with timely updates on their job openings. 
Feedback from customers should be considered to refine and improve the notification mechanism.