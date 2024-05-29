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

US 3000 As Candidate, I want to list all my applications and their state (including the number of applicants).

Acceptance Criteria:

3000.1. The system should allow candidates to view a list of all their applications.
3000.2. Each application should display its current state.
3000.3. The system should display the number of applicants for each job opening the candidate has applied to.

**Dependencies/References:**

*This requirement relates to NFR10(RCOMP) and NFR11(RCOMP).*

## 3. Analysis

* During the analysis phase, we conducted a study to understand the candidate's perspective on 
viewing their applications and their states. Additionally, we analyzed the implications of displaying 
the number of applicants for each job opening to provide candidates with insights into the competition.

## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (presenting the classes that support the functionality), the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*

### 4.1. Realization

### 4.2. Class Diagram

![a class diagram](class-diagram-01.svg "A Class Diagram")

### 4.3. Applied Patterns

### 4.4. Tests

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

The implementation ensures that candidates can view a comprehensive list of their applications, 
including their states. Additionally, the system displays the number of applicants for each job opening to 
provide candidates with valuable insights.



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