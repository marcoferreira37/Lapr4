# US 1001 - As a Customer Manager, I want to register a new customer.


## 1. Context

*Explain the context for this task. It is the first time the task is assigned to be developed or this tasks was incomplete in a previous sprint and is to be completed in this sprint? Are we fixing some bug?*



## Client Specifications

> *Question*: Q104 Rui – US1001 – A criação de uma conta para o customer é feita ao inserir manualmente o email e nome do customer ou é expectavel ter uma lista de customers não registados no sistema para usar?
> *Answer*: A104 Não percebi bem o conceito de customers não registados. Penso que esse conceito não existe. A US 1001 indica que se pretende registar um customer. Ao registar-se o customer deve-se também criar um utilizador para que o customer possa aceder à App de customers.

> *Question*: Q110 Sergio – US1001 - Password para o customer- Na US1001, o customer manager ao registrar um customer deve definir uma password para este usuário ou será que deve ser gerado pelo sistema?
> *Answer*: A110 Já respondida em Q19.

> *Question*: Q111 Sergio – US1001 - Regras de negócio para endereço do customer- Quais são as regras de negócio do endereço do customer?
> *Answer*: A111 (Nota: evitem fazer perguntas muito genéricas e técnicas). Se me perguntar se é suficiente, nesta fase, que o sistema aceite apenas endereços nacionais, a minha resposta é afirmativa. Se a pergunta era outra, por favor coloque de novo, desta vez como se estivesse a falar com alguém que não sabe o que são regras de negócio, mas é especialista no negócio

> *Question*: Q112 Rui – US1001 - É correto assumir que o customer fica automaticamente atribuido ao customer manager que o registou ?
> *Answer*:A112 Sim. No âmbito deste projeto vamos assumir que isso deve acontecer.

> *Question*: Q122 Dias – US 1001 - E-mail atribuído ao Customer- Na US 1001 é pedido que a criação de um User através da CustomerEntity criada seja automática. Contudo, para a criação de um User é necessário um e-mail. Permite que seja pedido um e-mail ao Manager, para ficar associado á entidade? A password já será gerada automaticamente, por isso seria também possível a geração automática de um e-mail. 
> *Answer:* A122. Para essa US faze sentido assumir que o Customer Manager conhece o email a ser suado para esse Customer e pode introduzi-lo. Tal como para outras situações similares podem assumir que a password é gerada pelo sistema e que existe uam forma do utilizador conhecer essa password, mas que está forá do âmbito actual do sistema. Não percebi à referência a CustomerEntity. O que é?
## 2. Requirements

*In this section you should present the functionality that is being developed, how do you understand it, as well as possible correlations to other requirements (i.e., dependencies). You should also add acceptance criteria.*

*Example*

**US G002** As {Ator} I Want...

**Acceptance Criteria:**

- G002.1. The system should...Blá Blá Blá ...

- G002.2. Blá Blá Blá ...

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