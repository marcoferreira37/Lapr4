# US 1005

## 1. Context
This task is related to the User Story (US) 1006b, which involves the functionality for listing all information of a candidate including his applications.
This is the first time this task is being developed as part of the project to automate the main activities of the company, Jobs4U.

## 2. Requirements

The functionality to be developed involves allowing the Customer Manager to list all information of a candidate including his applications.

## Client Specifications:

> **Question**: Q108 José – US1006b- Quanto á informação que é apresentada na 1006b, que tipo de informação relacionada ás "applications" do candidato espera que seja apresentada ao customer manager?
>
> **Answer**: A108 Espera-se que sejam listadas as candidaturas desse candidato indicando a que job opening, qual a data de registo da candidatura, o seu estado e qual o seu identificador.

**Acceptance Criteria:**

1003.1. The system should allow the Customer Manager to display all of a candidates info, and it's job applications.

**Dependencies/References:**

There is a dependency related to US 1002, there is a need to have job openings.
There is a dependency related to US 1012, there is a need to have applications to a job opening.
There is a dependency related to US 2000a, there is a need to have a Candidate.

## 3. Analysis

During the analysis phase, various factors were considered to ensure the efficient implementation of the candidate listing functionality.
This involved understanding the needs of the Customer Manager, the system's requirements, and the dependencies on other user stories.
Additionally, insights from stakeholder interviews and clarification sessions were crucial in refining the requirements and acceptance criteria.

## 4. Design

### 4.1. Realization

The sequence diagram outlines the interaction between the Customer Manager and the system components to list job applications.
The domain model illustrates the key entities and relationships relevant to the job applications functionality.

## 5. Implementation

The implementation adheres to the design decisions outlined in the sequence diagram and class diagram.
Major commits related to this requirement ensure the seamless integration of the job applications listing functionality into the Jobs4U system.

## 6. Integration/Demonstration

Efforts were made to integrate the job applications listing functionality with other components of the system.
Integration testing was conducted to validate the functionality interaction with existing modules and ensure smooth operation.

## 7. Observations

* We opted to make the UI list first all the of the candidates id and then the user can select which one to see the details. This way we can avoid the user to know the id of the candidate he wants to see the details.
* Further refinement and optimization may be necessary based on user feedback and evolving business requirements.
* The analysis of alternative solutions and related works can provide valuable insights for future enhancements.
* Third-party works and references used during development should be duly acknowledged.