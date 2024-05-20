# US 1005

## 1. Context
This task is related to the User Story (US) 1005, which involves the functionality for listing job applications for a job opening.
This is the first time this task is being developed as part of the project to automate the main activities of the company, Jobs4U.

## 2. Requirements

The functionality to be developed involves allowing the Customer Manager to list job applications for a job opening.

## Client Specifications:

> **Question**: Q63 Gonçalves – US1005. Relativamente aos critérios para a listagem das candidaturas: Devem aparecer candidaturas
> que estão a decorrer ou podem aparecer candidaturas feitas no passado? Podem aparecer quaisquer candidaturas ou apenas 
> as que tenham sido aceites? Que informação deverá ser mostrada em cada candidatura?
>
> **Answer**: A63. Tal como refere a descrição da US, devem ser listadas todas as candidaturas para um job opening. Faz sentido mostrar todas as candidaturas, independentemente do seu estado. Assim, para cada cada candidatura deve ser identificado o candidato e o estado da sua candidatura.

> **Question**: Q76 Abreu – US1005 – A lista deve conter applications que ainda não concluíram todo o processo de seleção definido no setup da Job Opening ? Se sim, a lista deve conter o estado/fase de cada application
>
> **Answer**: A76. O processo de seleção/recrutamento termina apenas no “fim”, pelo que não percebo muito bem a primeira pergunta. Quanto à segunda pergunta penso que faz sentido incluir o estado da aplicação, até para o Customer Manager perceber as applications que foram rejeitadas por não passarem os requisitos.

> **Question**: Q129 Pinto – US1005- O customer manager vai receber a lista de todas as job Openings e selecionará uma, feito isto deve aparecer as job applications correspondentes. Que informações das job applications tem que ser mostradas ao listar?
> 
> **Answer**: A129. As candidaturas são de um candidato (pessoa), pelo acho que deve aparecer a identificação da candidatura (application), assim como a identificação do candidato e o seu nome.


**Acceptance Criteria:**

1003.1. The system should allow the Customer Manager to list job openings.

1003.2. The Customer Manager should be able to filter job openings by date, by code, by description or none.


**Dependencies/References:**

There is a dependency related to US 1002, there is a need to have job openings.
There is a dependency related to US 1012, there is a need to have applications to a job opening.
There is a dependency related to US 2000a, there is a need to have a Candidate.

## 3. Analysis

During the analysis phase, various factors were considered to ensure the efficient implementation of the job applications listing functionality.
This involved understanding the needs of the Customer Manager, the system's requirements, and the dependencies on other user stories, such as job openings and applications.
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
Integration testing was conducted to validate the functionality's interaction with existing modules and ensure smooth operation.

## 7. Observations

Further refinement and optimization may be necessary based on user feedback and evolving business requirements.
The analysis of alternative solutions and related works can provide valuable insights for future enhancements.
Third-party works and references used during development should be duly acknowledged.