# US 1013 - Rank Candidates for Job Opening

## 1. Context

This task is being assigned as part of the ongoing development efforts to automate the main activities of the company. 
The goal is to provide the Customer Manager with the ability to rank all the applicants/candidates for a certain job 
opening to assist in assigning the vacant position according to merits. 

This task is not related to fixing a bug but rather adding a new feature to the system.

## 2. Requirements

**US 1013** As Customer Manager, I want to rank the candidates for a job opening.

**Acceptance Criteria:**

- G1013.1. The system should allow the manager to rank candidates
- G1013.2. The system should persist the rankings of the candidates
- G1013.3. The system should allow the manager to change the ranking of the candidates
- G1013.4. The application should be in the phase Analysis
- G1013.5. The system should check that the rank is an integer number

**Dependencies/References:**

Furthermore, it is necessary to view all the candidates that have applied for the job opening.
Has dependency in the user stories:
- G007 -> As a Project Manager, I want the system to support and apply authentication and
  authorization for all its users and functionalities.
- 1002 -> As Customer Manager, I want to register a job opening.
- 2002 -> As Operator, I want to register an application of a candidate for a job opening and
  import all files received.

## 3. Analysis

### 3.1. Domain Model 
Explain the domain model and its entities.

The domain model is composed of the following entities:

- **JobOpening**: Represents a job opening in the company.
- **Candidate**: Represents a candidate that has applied for a job opening.
- **Application**: Represents the application of a candidate for a job opening.
- **Phase**: Represents the phase of the application process.

![Domain Model](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintC\1013\svg\1013-domain-model.svg)

## 3.2 System Sequence Diagram

![System Sequence Diagram - Full](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintC\1013\svg\1013-system-sequence-diagram-System_Sequence_Diagram__SSD____Rank_Candidates_for_a_Job_Opening.png)

The Customer Manager requested a feature to rank the candidates for a job opening. 
This feature will allow the manager to rank the candidates, persist the rankings, change the rankings, and view the rankings. 
The system should have validations to ensure that the data is valid.

## 4. Design

### 4.1. Realization

The realization of the functionality involves defining how the Customer Manager can rank candidates 
and how these rankings are stored and modified in the system. 
This requires interactions between various system components including the UI, business logic, 
and data persistence layers.

## 4.2 Sequence Diagram

![Sequence Diagram - Full](svg/us017-sequence-diagram-full.svg)

A sequence diagram shows the interactions between the Customer Manager and the system to rank candidates. 
This includes actions like viewing a list of candidates, assigning a rank, saving the rank, and modifying it later.

### 4.2. Class Diagram

![a class diagram](1013-class-diagram-0.svg "A Class Diagram")

### 4.3. Applied Patterns

> N/A

### 4.4. Tests

[//]: # (TODO Make this)

Include here the main tests used to validate the functionality. Focus on how they relate to the acceptance criteria.

**Test 1:** *Verifies that it is not possible to ...*

**Refers to Acceptance Criteria:** G002.1


```
@Test(expected = IllegalArgumentException.class)
public void ensureXxxxYyyy() {
	...
}
````

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*

*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this requirement.*

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in this section statements/references regarding third party works that were used in the development this work.*