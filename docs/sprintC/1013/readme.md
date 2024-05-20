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
- G1013.4. The system should allow the manager to view the rankings of the candidates
- G1013.5. The system should have validations to ensure that the data is valid

**Dependencies/References:**

Regarding this feature, there is a necessity to have the interviews conducted during the interview phase of the job opening.
Furthermore, it is necessary to view all the candidates that have applied for the job opening.

## 3. Analysis

*In this section, the team should report the study/analysis/comparison that was done in order to take the best design decisions for the requirement. This section should also include supporting diagrams/artifacts (such as domain model; use case diagrams, etc.),*

The Customer Manager requested a feature to rank the candidates for a job opening. 
This feature will allow the manager to rank the candidates, persist the rankings, change the rankings, and view the rankings. 
The system should have validations to ensure that the data is valid.

## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (presenting the classes that support the functionality), the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*

### 4.1. Realization

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