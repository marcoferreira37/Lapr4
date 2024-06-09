# US 3000

## 1. Context

This task involves implementing the functionality for candidates to list all their applications 
along with their current state, including the number of applicants for each job opening they have applied to. 
This is the first time this task is being developed.

## Client Specifications

> *Question*: Q176 Artur – US3000 - Na US3000 pede que, para alem de listar as aplicações
>e o estado das mesmas de um candidato, que liste o numero de candidatos.
>Este numero de candidatos é um somatório da quantidade de candidatos que
>fizeram uma aplicação para as mesmas Job Openings deste primeiro
>candidato (que esta a executar o caso de uso)?
> *Answer*: A176 Devem ser listadas todas as “applications” (candidaturas) do candidato, o estado
>delas, assim como o número de candidaturas que cada job opening teve (assim o
>candidato tem uma noção da “concorrência” que teve para cada uma das suas
>candidaturas).

## 2. Requirements

* **US 3000** As Candidate, I want to list all my applications and their state (including the number of applicants).

Acceptance Criteria:

- 3000.1. The system should allow candidates to view a list of all their applications.
- 3000.2. Each application should display its current state.
- 3000.3. The system should display the number of applicants for each job opening the candidate has applied to.
- 3000.4. The solution follows a client-server architecture, where the Candidate application accesses the server application.

**Dependencies/References:**

- NFR10(RCOMP) - Functionalities related to the Candidate and Customer Apps and to the Follow Up Server part of the
  system have very specific technical requirements. It must follow a client-server architecture, where a client
  application is used to access a server. Communications between these two components must follow specific protocol
  described in a document from RCOMP ("Application Protocol"). Also, the client applications can not access the
  relational database, they can only access the server application.
- NFR11(RCOMP) - The solution should be deployed using several network nodes. It is expected that, at least, the
  relational database server and the Follow Up Server be deployed in nodes different from localhost, preferably in the
  cloud. The email notification tasks must be executed in background by the Follow Up Server.

## 3. Analysis

* During the analysis phase, we conducted a study to understand the candidate's perspective on 
viewing their applications and their states. Additionally, we analyzed the implications of displaying 
the number of applicants for each job opening to provide candidates with insights into the competition.

### 3.1. Domain Model

![Domain Model](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintC\1013\svg\1013-domain-model.svg)

## 4. Design

### 4.1. Realization

The functionality for listing all applications and their states for Candidates is implemented within the Candidate application.
This involves communicating with the server application to retrieve application data, displaying the state and number of applicants for each application, 
and ensuring adherence to specific technical requirements such as client-server architecture and deployment across multiple network nodes.

### 4.2. Sequence Diagram

- For the new user story, the sequence diagram details the interactions needed for a candidate to view their
applications and their states, including the number of applicants for each job opening.
  Implementation details for the notification system include creating the necessary entities and services to handle
notifications and state changes.
  The sequence diagram illustrates the interactions between the candidate application, server application, and database.

![Sequence Diagram - Full](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintC\1013\svg\1013-sequence-diagram.png)

### 4.3. Used Case Diagram

- The use case diagram illustrates the interactions between the candidate and the system when viewing their applications
and their states.

![Use Case Diagram](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintC\1013\svg\1013-sequence-diagram.png)


## 5. Implementation

The implementation ensures that candidates can view a comprehensive list of their applications, 
including their states. Additionally, the system displays the number of applicants for each job opening to 
provide candidates with valuable insights.
The implementation is based on the following steps:
1) The system retrieves all applications for the logged-in candidate.
2) The system retrieves the state of each application.
3) The system retrieves the number of applicants for each job opening the candidate has applied to.

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*
*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

* Efforts have been made to seamlessly integrate this functionality with other parts of the system. 
The user interface components are integrated with the overall system interface, 
and the necessary interactions between controllers, services, and repositories have been established.

*To demonstrate this functionality:*

- Log in as a candidate.
- Navigate to the section for viewing applications.
- Verify that all applications are listed along with their states.
- Note the displayed number of applicants for each job opening.

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*
*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*
*The team should include in this section statements/references regarding third party works that were used in the development this work.*
