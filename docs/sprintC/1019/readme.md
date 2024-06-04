# US 1019

## 1. Context

This task involves developing a new feature to generate an ordered list of job candidates based on their interview points,
as requested by the Customer Manager for the first time in this sprint. 
The feature aims to assist the Customer Manager in analyzing and comparing candidates' performance efficiently, 
helping to make informed selection decisions by providing a clear, ranked list based on interview grades.


## Client Specifications

> *Question*: Q169 Simoes – US1019 - Relativamente a esta user story, "US 1019 - As
>Customer Manager, I want to get an ordered list of candidates, using the job
>interview points (grades), to help me analyze the candidates.", a lista que
>pretende é relacionada a uma job opening correto? A maneira de ordenação é
>ascendente ou quer uma opção que inclua ascendente e descendente?
> *Answer*: A169 Sim, a ordenação é relativa a candidaturas para um job opening. A ordenação deve
>ser descendente, do que tem maior pontuação para o que tem menor pontuação.

> *Question*: Q177 Artur – US 1019 Esclarecimento - Na US 1019: As Customer Manager, I
>want to get an ordered list of candidates, using the job interview points
>(grades), to help me analyze the candidates. Pretende que para uma
>determinada Job Opening de um cliente meu, retorno uma lista ordenada de
>candidatos e suas notas da entrevista. Penso implementar essa funcionalidade
>da seguinte forma:
>Job Opening : XXX
>Nome | Email | Grade
>Jane Doe| jane@doe.pt | 85
>John Doe | john@doe.pt | 70
>Ou seja com ordenação descendente.
>Conforme refere Q153 consegue ver numa instancia esta lista, e noutra instancia faz o
>ranking que achar pertinente.
>Acha bem?
> *Answer*: A177 Penso que queira fazer referência a Q163. Relativamente ao exemplo que apresenta
>parece-me que satisfaz o que pretendo.

> *Question*: Q204 Paula – US 1019– segundo a resposta A197, devemos então apenas
>permitir a listagem de job openings que tenham entrevista?
> *Answer*: A204. Penso que não percebi bem a referência à listagem de job openings. Esta US não faz
>sentido para job openings que não tenham entrevista, uma vez que assenta na listagem
>dos candidatos e dos seus pontos nas entrevista.

> *Question*: Q226 Bernardo Barbosa – US 1019 - Na descrição da user story : " As
>Customer Manager, I want to get an ordered list of candidates, using the job
>interview points (grades), to help me analyze the candidates". A intenção
>"analyze the candidates" impõe alguma mudança/remoção de candidatos no
>sistema?
> *Answer*: A226. A referência a “analize the candidates” é apenas para passar a ideia que se
>pretende nesta US que o sistema disponibilize uma forma do CustomerManager conseguir
>consultar o resultado das entrevistas de forma a ajudar a decidiro ranking dos candidatos.
>Nada mais. O ranking doa candidatos é registado no sistema através da US 1013.

## 2. Requirements

**US 1019**  As Customer Manager, I want to get an ordered list of candidates, using the job
interview points (grades), to help me analyze the candidates.

**Acceptance Criteria:**

- 1019.1: The system should allow the Customer Manager to input or upload a list of candidates along with their interview points.
- 1019.2: The system should sort the candidates in descending order based on their interview points.
- 1019.3: The sorted list should be displayed clearly, showing each candidate's name and their respective interview points.
- 1019.4: The system should ensure data accuracy by validating the inputted interview points to be numerical and within a defined range (e.g., 0-20).
- 1019.5: The system should be able to handle a large number of candidates efficiently, ensuring quick sorting and display.

**Dependencies/References:**

- There is a dependency on the interview phase of the job opening, as the interview points are collected during this phase.


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

The Customer Manager requested a feature to list candidates based on their interview points.
The system sequence diagram shows the interactions between the Customer Manager and the system to achieve this.
The customer manager requests the list of candidates for a job opening, and the system retrieves and sorts the candidates based on their interview points.
Selects a job opening and requests the list of candidates for that job opening.
Then, the system displays the sorted list to the Customer Manager.


## 4. Design

### 4.1. Realization

The realization of the functionality involves defining how the Customer Manager can list candidates based on their interview points.
This requires interactions between various system components including the UI, business logic, and data persistence layers.

## 4.2 Sequence Diagram

![Sequence Diagram - Full](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintC\1019\svg\1019-sequence-diagram.png)

The sequence diagram shows the interactions between the Customer Manager and the system to list candidates based on their interview points.
This includes selecting a job opening, retrieving the candidates for that job opening, sorting the candidates based on 
their interview points, and displaying the sorted list to the Customer Manager.

## 5. Implementation

- The implementation of listing candidates based on the grades involves several key components: the UI layer,
  the business logic layer, and the persistence layer.
  The primary goal is to allow the Customer Manager to list and rank candidates based on their interview points.
- The following components were implemented:

* Controller (OrderedCandidatesController): Manages the interaction with the ApplicationService to list the candidates based on their interview points.

* Repository (JobApplicationRepository): Handles the persistence of application data, including the rankings of candidates based on interview points

* Repository (JobOpeningRepository): Handles the persistence of job opening data, including the list of job openings.

* Repository (InterviewRepository): Handles the persistence of candidate data, including the interview points.

* Service (ApplicationService): Handles the business logic for listing and ranking candidates based on interview points.

* UI (OrderCandidatesUI): Provides the interface for the Customer Manager to view the list of the candidates and theirs grades.

## 6. Integration/Demonstration

* Integration with other system components was verified by:

- Ensuring that the OrderedCandidatesController correctly interacts with the ApplicationService.
- Validating that the ApplicationService correctly persists rankings using the JobOpeningApplicationRepository.
- Verifying that the UI displays the sorted list of candidates based on their interview points.
- Ensuring that the UI allows the Customer Manager to select a job opening and view the list of candidates.
- Testing the complete workflow from the UI to the service and persistence layers.
- To demonstrate this functionality:

1) Run the application.
2) Navigate to the Ordered Candidates UI.
3) Select a job opening.
4) View the list of the candidates sorted.

## 7. Observations

* During development, the following considerations were made:

- UI/UX: The UI was designed to be intuitive, allowing the Customer Manager to easily navigate and list candidates.
  Future improvements could include additional filtering and sorting options.

- Extensibility: The current implementation is modular, allowing for future enhancements such as automated initial grades based on predefined criteria.

- Alternative solutions considered included automated ranking based on interview scores,
  but this was deferred to future work to keep the initial implementation simple and focused on manual grading by the Customer Manager.