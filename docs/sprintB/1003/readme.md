# US 1003

## 1. Context
This task is related to the User Story (US) 1003, which involves the functionality for listing job openings. 
This is the first time this task is being developed as part of the project to automate the main activities of the company, Jobs4U.

## 2. Requirements

The functionality to be developed involves allowing the Customer Manager to list job openings. 
The criteria for listing job openings include the ability to filter by customer and date.

## Client Specifications:

> *Question*: Q68 Pedro – US1003 – Na us1003 é pedido que se liste job openings, há algum critério para definir quais listar? Ou são as do sistema inteiro?
> *Answer*: A68. Suponho que poder filtrar por Customer e data seja útil. Também poder filtrar apenas as activas ou todas parece-me útil.

> *Question*: Q87 Lopes – US1003 – Relativamente a uma questão já colocada foi referido que "pode-se filtrar por Customer" nesta US.
> Nesta caso qual será a forma que o Customer Manager utilizará para filtrar as Job Openings por Costumer (nome, email,...)? 
> E quando se refere a "poder filtrar por data" significa que é uma determinada data ou um intervalo de tempo?
> *Answer*: A87. O Customer é tipicamente uma empresa e tem um nome. Também já foi referida a existência de um customer code.
> Quanto ao filtro por data se estiverem no papel do customer manager que tem de consultar job openings faz sentido ser para um dia? Ou seja ele teria de sabe em que dia é que registou o job opening que está a pesquisar…

> *Question*: Q95 Varela – [1003] Job Openings Ativas – A resposta à questão Q68 suscitou-nos algumas dúvidas sobre uma job opening no estado "ativa".
> Em que instante uma job opening se torna ativa? É quando é criada e tem um conjunto de requisitos associada a si? É quando está ligada a um processo de recrutamento ainda a decorrer?
> Agradecíamos alguns esclarecimentos
> *Answer*: A95. No contexto da Q68 a referência a activa surge no contexto de datas. 
> Uma job opening cujo processo já tenha terminado não está ativa.

> *Question*: Q96 Semikina – [1003] - As Customer Manager, I want to list job openings – Em relação à listagem dos jobs openings,
> um customer manager pode listar todos os jobs openings ou apenas os que lhe foram atribuídos. 
> Posto de outra forma, os job openings são atribuídos a um customer manager específico, e o mesmo só pode ter acesso à sua lista de job openings?
> *Answer*: A96. Ver Q68. Penso que faz sentido listar apenas os “seus” job openings.




*Example*

**US 1003** As Customer Manager, I want to list job openings

**Acceptance Criteria:**

- 1003.1. The system should allow the Customer Manager to list job openings.

- G002.2. The Customer Manager should be able to filter job openings by customer and date.


**Dependencies/References:**

*Regarding this requirement we understand that it relates to...*

## 3. Analysis

*In this section, the team should report the study/analysis/comparison that was done in order to take the best design decisions for the requirement. This section should also include supporting diagrams/artifacts (such as domain model; use case diagrams, etc.),*

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