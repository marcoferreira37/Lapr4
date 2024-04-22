# US 1002

## 1. Context

[//]: # (Explain the context for this task. It is the first time the task is assigned to be developed or this tasks was incomplete in a previous sprint and is to be completed in this sprint? Are we fixing some bug?*)

This task involves registering a job opening. 
It's essential for the Customer Manager role to have this functionality available. 
This task is assigned for development in this sprint.


**Client Questions:**

**Q77 Simões** – *US1002 Critérios de Aceitação* – Relativamente à US1002 - "As Customer Manager, I want to register a job opening", 
existe algum critério de aceitação ainda não mencionado, relacionado com os atributos? Ou fica ao critério da equipa de 
desenvolvimento consoante boas práticas e senso comum? Alguns exemplos: - O "Number of Vacancies" não poder ser menor ou igual a 0 ou pode ser opcional; 
- A "Description" ter um tamanho de caracteres limite ou ser opcional;

**A77** -  Sobre se existem critérios de aceitação não mencionados não me vou pronunciar, faz parte do processo descobrirem. 
Eu sugeria usarem algo mais que o senso comum


**Q79 Padilla** – *US1002* - Could we use the same interview model for more than one job opening?

**A79** - See Q38. Yes.


**Q88 Cardoso** – *US1002* – Quando o Customer Manager regista uma job offer, é ele que cria as requirement specifications e 
as interview models ou é-lhe dada uma lista destes para ele selecionar?

**A88** - Existe a US1002 e as US1009 e US1011. Penso que está claro qual a responsabilidade de cada uma. 
A criação dos modelos das entrevistas e dos requisitos é um caso de uso especifico e com um US especifica para registar no sistema os respectivos plugins (US1008).



## 2. Requirements

[//]: # (*In this section you should present the functionality that is being developed, how do you understand it, as well as possible correlations to other requirements &#40;i.e., dependencies&#41;. You should also add acceptance criteria.*)

[//]: # ()
[//]: # (*Example*)

[//]: # ()
[//]: # (**US G002** As {Ator} I Want...)

[//]: # ()
[//]: # (**Acceptance Criteria:**)

[//]: # ()
[//]: # (- G002.1. The system should...Blá Blá Blá ...)

[//]: # ()
[//]: # (- G002.2. Blá Blá Blá ...)

[//]: # ()
[//]: # (**Dependencies/References:**)

[//]: # ()
[//]: # (*Regarding this requirement we understand that it relates to...*)


**US 1002** As Customer Manager, I want to register a job opening.

**Acceptance Criteria**

* 1002.1. The system should allow the Customer Manager to create a new job opening.
* 1002.2. The job opening should include fields for job title, description, requirements, and deadline.
* 1002.3. Once created, the job opening should be visible to applicants.
* 1002.4. The Customer Manager should be able to edit or delete a job opening.


**Dependencies/References:**

*Alternatively, this can be achieved by a bootstrap process.*


## 3. Analysis

*In this section, the team should report the study/analysis/comparison that was done in order to take the best design decisions for the requirement. 
This section should also include supporting diagrams/artifacts (such as domain model; use case diagrams, etc.),*

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

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in this section statements/references regarding third party works that were used in the development this work.*