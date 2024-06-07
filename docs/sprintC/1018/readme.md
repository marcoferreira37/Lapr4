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


**Dependencies/References:**

Furthermore, it is necessary to view all the job interviews that have a questionary with answers.
Has dependency in the user stories:
- G007 - As a Project Manager, I want the system to support and apply authentication and
  authorization for all its users and functionalities.
- 1014 As Customer Manager, I want to record the time and date for an interview with a
  candidate.



## 3. Analysis

### 3.1. Domain Model

The domain model is composed of the following entities:

- **Plugin**: Represents a plugin that is used to evaluate the interviews for a job opening.
- **Application**: Represents the application of a candidate for a job opening.
- **Interview**: Represents an interview with a candidate for a job opening application.
- **Opening**: Represents a job opening.

[Domain Model](C:\Users\Utilizador\Desktop\sem4pi-23-24-2dh3\sem4pi-23-24-2dh3_final\docs\sprintC\1018\svg\1018-domain-model.svg)


## 3.2 System Sequence Diagram

[System Sequence Diagram - Full](C:\Users\Utilizador\Desktop\sem4pi-23-24-2dh3\sem4pi-23-24-2dh3_final\docs\sprintC\1018\svg\1018-system-sequence-diagram-System_Sequence_Diagram__SSD____Grade_Interviews_for_a_Job_Opening.svg)

The Customer Manager requested a feature to evaluate the interview of candidates for a job opening.
This feature will allow the manager to evaluate , persist the grade.


## 4. Design

### 4.1. Realization

The realization of the functionality involves defining how the Customer Manager can evaluate the interviews for a job opening
and how these grades are stored and modified in the system.
This requires interactions between various system components including the UI, business logic,
and data persistence layers.


## 4.2 Class Diagram


The class diagram shows the key classes involved.
This includes the Application, Plugin, Interview and Job Opening.

## 4.3 Sequence Diagram

[Sequence Diagram - Full](C:\Users\Utilizador\Desktop\sem4pi-23-24-2dh3\sem4pi-23-24-2dh3_final\docs\sprintC\1018\svg\1018-sequence-diagram.svg)

The sequence diagram shows the interactions between the Customer Manager and the system to evaluate the interview.
This includes actions like viewing a list of interviews, evaluate a grade, saving the grade.

## 5. Implementation

- The implementation of the evaluation feature involves several key components: the UI layer,
  the business logic layer, and the persistence layer.
  The primary goal is to allow the Customer Manager to evaluate for a job opening, save the grade.
  The implementation also ensures that all selected interviews are evaluated and are persisted.

* Controller (EvaluateInterviewController): Manages the interaction with the EvaluateInterviewService to evaluate.

* Repository (JobInterviewRepository): Handles the persistence of job interviews.

* Service (EvaluateInterviewService): Handles the business logic for evaluate and persists the changes using the repository.

* UI (EvaluateInterviewUI): Provides a user interface for the Customer Manager to select job interview, view applications, and evaluate the job interview.

## 6. Integration/Demonstration

* Integration with other system components was verified by:

- Ensuring that the EvaluateInterviewController correctly interacts with the EvaluateInterviewService.
- Validating that the EvaluateInterviewService correctly persists rankings using the JobInterviewRepository.
- Testing the complete workflow from the UI to the service and persistence layers.
- To demonstrate this functionality:


1) Run the application.
2) Navigate to the Evaluate InterviewUI UI.
3) Select a job interview.
4) View and evaluate a job opening.
5) Verify that grade is saved.

## 7. Observations


* During development, the following considerations were made:

- UI/UX: The UI was designed to be intuitive, allowing the Customer Manager to easily evaluate.
- Performance: The Plugin was optimized to ensure quick response times, even with a large number of interviews.
- Extensibility: The current implementation is modular, allowing for future enhancements.


