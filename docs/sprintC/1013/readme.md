# US 1013 - Rank Candidates for Job Opening

## 1. Context

This task is being assigned as part of the ongoing development efforts to automate the main activities of the company. 
The goal is to provide the Customer Manager with the ability to rank all the applicants/candidates for a certain job 
opening to assist in assigning the vacant position according to merits. 

This task is not related to fixing a bug but rather adding a new feature to the system.

## Client Specifications

> *Question*: Q142 Varela – US1013 - Candidate Ranking – Mr Client mention a manual ranking (Q17). 
> If the pontuation of an interview is not essential for the candidate's rank, what criteria is to be used when ranking?
> *Answer*: A142 Please view again Q17. The ranking is a decision of the Customer Manager based on all the data that 
> he/she may have during the process (including CV and other attached documents and the interviews as well as other 
> data/information that may not be part of the system).

> *Question*: Q155 Varela – US1013 - Rank Entries - Is there a limit on rank entries? Let's
>say that 100 candidates apply for a job opening. Does the Customer Manager
>have to sort all 100 candidates?
> *Answer*: A155 The order of candidates should include at least all the first candidates within the
>vacancy number andsome following candidates. At the moment, I do not know exactly the
>number of the following candidates to be ordered. Therefore, I would like for it to be a
>global configuration property in the system. It could be a number representing a magnitude
>from the vacancy number. For instance, 1 could mean exactly the same number of
>vacancies, 2 the double, 0,5 half the number of vacancies. The remainder of the
>candidates could be just tagged as not ranked.

> *Question*: Q157 Miguel – US1013 - Rank the candidates for a job Opening is the same as
>rank the job Applications for a Job Opening, knowing that I can only know the
>candidates throw the job application?
> *Answer*: A157 In the context of a job opening, a candidate is someone that made an application to
>that job opening. But the same person can be a candidate to other job openings.

> *Question*: Q158 Miguel – US1013 - Process of ranking - How is the ranking done? The
>customer manager selects a job opening and is shown the different
>candidates, and they assign a rank to each one. And the ranking process end
>when he assigns a rank to all candidates? Example: - Rank the candidate1: -
>Write the rank: 3 - Rank the candidate2: - Write the rank: 1 - Rank the
>candidate3: - Write the rank: 4
> *Answer*: A158 See Q155. Once again, I do not have specific requirements for UI/UX. But I can
>provide some ideas. Being a console application limits the UI/UX. However, I see this
>functionality similar to the way people enter recipients for an email, for instance. In the
>case of the recipients of an email I simply write their emails separated by a comma. Could
>it be similar in this case?




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

The sequence diagram shows the interactions between the Customer Manager and the system to rank candidates. 
This includes actions like viewing a list of candidates, assigning a rank, saving the rank, and modifying it later.

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