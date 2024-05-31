# US 1018

## 1. Context

This task involves executing the process that evaluates (grades) the interviews for a job opening. 
It's crucial for the Customer Manager role to have this functionality available. 
This task is assigned for development in this sprint.

## Client Specifications

> *Question*: Q199 Ribeiro – US1018 – Relativamente à US1018, após a execução do
>processo de avalição de todas as entrevistas da job opening, a fase em que
>esta se encontra deve ser automaticamente mudado para "Result" ou deve ser
>mantida em "Analysis" e apenas pode ser mudada pela execução da US1010?
> *Answer*: A199. A US1018 não deve alterar a fase actual. A US1010 permite fazer a mudança de
>fases do processo de recrutamento.

> *Question*: Q214 Pedro – US1017/1018 – O nosso grupo tem uma dúvida em relação ao
>processamento dos ficheiros de respostas dos candidatos para a entrevista.
>No caso de upload de um ficheiro, se a pergunta que requer um número
>como resposta for preenchida com um formato inválido, por exemplo, uma
>letra, devemos considerar isso como um formato inválido na US 1017 (e pedir
>para o user voltar a dar upload a um ficheiro válido) ou devemos, na US1018,
>considerar que está incorreta e atribuir 0 pontos automaticamente para essa
>resposta inválida? Isto é, na US 1017, devemos apenas verificar o formato do
>ficheiro ou devemos verificar também se as respostas são preenchidas com
>o tipo de dados correto?
> *Answer*: A214. O caso mencionado deve ser considerado um erro de validação do ficheiro (ou seja,
>o ficheiro submetido não corresponde à gramática definida).

> *Question*: Q199 Ribeiro – US1018 – Relativamente à US1018, após a execução do
>processo de avalição de todas as entrevistas da job opening, a fase em que
>esta se encontra deve ser automaticamente mudado para "Result" ou deve ser
>mantida em "Analysis" e apenas pode ser mudada pela execução da US1010?
> *Answer*: A199. A US1018 não deve alterar a fase actual. A US1010 permite fazer a mudança de
>fases do processo de recrutamento.

## 2. Requirements

**US 1018** As Customer Manager, I want to execute the process that evaluates (grades) the interviews for a job opening.

**Acceptance Criteria:**

- 1018.1. The system should allow the Customer Manager to evaluate the interviews.

- 1018.2. The system should persist the evaluations of the interviews.

- 1018.3. The system should validate the input details before registering the evaluations.

- 1018.4. The system should provide a user interface for the evaluation of the interviews.

- 1018.5. The application should be in the Analysis phase.

**Dependencies/References:**

* Alternatively, this can be achieved by a bootstrap process.


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