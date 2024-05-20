# US 1005

## 1. Context
This task is related to the User Story (US) 1006, which involves the functionality for listing all of a candidate information.
This is the first time this task is being developed as part of the project to automate the main activities of the company, Jobs4U.

## 2. Requirements

The functionality to be developed involves allowing the Customer Manager to list all information about a candidate.

## Client Specifications:

> **Question**: Q42 Bernado – US1006, Qual a informação do nome do candidato deve aparecer (nome completo, primeiro e ultimo nome , etc)?
>
> **Answer**: A42. À partida diria que seria o nome, tal como foi recebido na application que fez (página 6, “name of the candidate”)

> **Question**: Q75 Silva – US1006 – Em relação à listagem dos dados pessoais de um determinado candidato, um customer manager vai ter acesso a todos os candidatos do sistema ou apenas aos candidatos que submeteram uma application para uma job opening de um cliente que é gerido por esse customer manager
> 
> **Answer**: A75. No contexto actual vamos assumir que o Customer Manager pode aceder (consultar) os dados pessoais de qualquer candidato

> **Question**: Q90 Matilde – US1006 – Em relação ao processo de selecionar um candidato e mostrar a sua informação pessoal, para facilitar a procura de um candidato especifico. Faria sentido perguntar ao utilizador se quer listar todos os candidatos existentes ou se quer reduzir a lista, selecionando um job opening e assim mostrar todos os candidatos para esse job opening, e por fim selecionar um candidato dessa lista mais pequena
> 
> **Answer**: A90. O product owner espera que o sistema aplique as melhores práticas de UI/UX mas, não sendo especialista nessa área técnica, não arrisca sugerir soluções.

> **Question**: Q113 Beatriz – US1006 - Informações do candidato - Na us1006 é necessário mostrar os dados pessoais dos candidatos. Para isso, que informações acha pertinente demonstrar?
> 
> **Answer**: A113. Será toda a informação pessoal de um candidato que o sistema tenha registado.

> **Question**: Q128 Rocha – US1006- Na us 1006, seria aceitavel perguntar ao costumer manager o id do candidato de que deseja visualizar os dados, ou seria mais pertinente dar uma lista de todos os candidos e deixa-lo escolher dessa lista, assumindo que este não tem maneira de saber o id do candidato de que quer obter dados.
> 
> **Answer**: A128. Pergunta similar à anterior Q127. Note-se que a US1005 permite obter as candidaturas para uma job opening. Esta US é para mostrar os dados de um candidato. Portanto parece existir forma de aceder ao id do candidato, caso não se saiba qual é. Mais uma vez, espero que apliquem boas práticas de UI/UX.



**Acceptance Criteria:**

1003.1. The system should allow the Customer Manager to display all information of a candidate.

**Dependencies/References:**

There is a dependency related to US 2000a, there is a need to Candidate to exist in the system.

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
Integration testing was conducted to validate the functionality's interaction with existing modules and ensure smooth operation.

## 7. Observations

 * We opted to make the UI list first all the of the candidates id and then the user can select which one to see the details. This way we can avoid the user to know the id of the candidate he wants to see the details.
 * Further refinement and optimization may be necessary based on user feedback and evolving business requirements.
 * The analysis of alternative solutions and related works can provide valuable insights for future enhancements.
 * Third-party works and references used during development should be duly acknowledged.