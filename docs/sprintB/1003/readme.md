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


> *Question*: Q120 Varela – [US1003] Job Opening Status- O cliente esclareceu o aspeto do status de uma job opening nas questões Q68 e Q95. 
> Disse que uma job opening deixava de estar ativa quando o seu processo de recrutamento termina-se. 
> Contudo, em que estado estão as job openings que já foram registadas mas ainda não têm um processo de recrutamento associado a si?
> *Answer*: A120. Relativamente ao estado (nome do estado) em que estão depois de serem registadas mas ainda não terem um processo eu não sei o que responder. 
> Mas posso acrescentar que se não têm processo então não têm datas para as fases do processo e, portanto,
> parece-me que ainda não entraram na fase de application, pelo que ninguém tem “oficialmente” conhecimento dessa oferta de emprego e não devem haver candidaturas para essa oferta.

**Acceptance Criteria:**

1003.1. The system should allow the Customer Manager to list job openings.

1003.2. The Customer Manager should be able to filter job openings by date, by code, by description or none.


**Dependencies/References:**

There is a dependencie related to US1002, there is a need to have job openings to list them.

## 3. Analysis

During the analysis phase, various factors were considered to ensure the efficient implementation of the job openings listing functionality. 
This involved understanding the needs of the Customer Manager, defining filtering criteria, and determining the status of job openings. 
Additionally, insights from stakeholder interviews and clarification sessions were crucial in refining the requirements and acceptance criteria.

## 4. Design

### 4.1. Realization

The sequence diagram outlines the interaction between the Customer Manager and the system components to list job openings.
The domain model illustrates the key entities and relationships relevant to the job openings functionality.

## 5. Implementation

The implementation adheres to the design decisions outlined in the sequence diagram and class diagram. 
Major commits related to this requirement ensure the seamless integration of the job openings listing functionality into the Jobs4U system.

## 6. Integration/Demonstration

Efforts were made to integrate the job openings listing functionality with other components of the system.
Integration testing was conducted to validate the functionality's interaction with existing modules and ensure smooth operation.

## 7. Observations

Further refinement and optimization may be necessary based on user feedback and evolving business requirements. 
The analysis of alternative solutions and related works can provide valuable insights for future enhancements. 
Third-party works and references used during development should be duly acknowledged.