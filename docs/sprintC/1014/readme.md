# US 1014 - Record the time and date for an interview with a candidate

## 1. Context

This task is being assigned as part of the ongoing development efforts to automate the main activities of the company.
The task is to record the time and date for an interview with a candidate, ensuring that the Customer Manager can efficiently schedule and manage interview appointments.

This task is not related to fixing a bug but rather adding a new feature to the system.

## 2. Requirements Engineering and Analysis

**US 1014** As Customer Manager, I want to record the time and date for an interview with a candidate.

**Acceptance Criteria:**

- G1014.1. The system should allow the manager to record the time and date for an interview with a candidate.
- G1014.2. The system should persist the time and date for the interview.
- G1014.3. The system should allow the manager to change the time and date for the interview.
- G1014.4. The application should be in the phase Interview.


**Dependencies/References:**

Furthermore, it is necessary to view all the candidates that have applied for the job opening application.
Has dependency in the user stories:
- G007 -> As a Project Manager, I want the system to support and apply authentication and
  authorization for all its users and functionalities.
- 1002 -> As Customer Manager, I want to register a job opening.
- 2002 -> As Operator, I want to register an application of a candidate for a job opening and
  import all files received.

## 2.1 Product Owner Specifications

> **Question**: Uma entrevista pode ter apenas uma questão? US1014, time and date, quer dizer data de inicio e não data final? Podem haver entrevistas em paralelo?
> 
> **Answer**: Quanto ao número de perguntas numa entrevista, não está definido nenhum limite inferior ou superior. Ou seja, pode haver uma entrevista com apenas 1 pergunta (não fará sentido não ter perguntas). A US1014 refere-se à marcação da data de uma entrevista com um candidato. Algo como indicar o dia e a hora (ex: 23 de abril pelas 14:00). Em relação à marcação de entrevistas “sobrepostas” (com a mesma data de inicio), neste momento, seria algo a permitir (pode, por exemplo, o customer manager delegar noutra pessoa a condução da entrevista). Isso não invalida que devam validar se as entrevistas ocorrem dentro da fase das entrevistas.


> **Question**: Em relação à marcação da intervista, só deve ser possível marcar esta data quando? Só será possível marcar a entrevista quando a fase de recrutamento se encontrar na fase de intervista? Ou será possivel marcar noutras fases anteriores?
>
> **Answer**: Por mim pode ser possível marcar as entrevistas antes mas deve-se ter em atenção se o candidato “passou” o screening. Não faz sentido marcar uma entrevista para um candidato que não foi aceite. Tenham em atenção este tipo de aspetos.


> **Question**: As Customer Manager, I want to record the time and date for an interview with a candidate." Is it possible to schedule interviews for any day and time or we must take into account weekends, working hours and holidays, for example?
> 
> **Answer**: The system should display the day of the week for the selected date. But the system should accept any valid dat


> **Question**: Em relação à marcação de uma entrevista com um candidato, deve ser possível marcar mais do que uma entrevista por candidatura?
> 
> **Answer**: O sistema nesta fase está pensado para apenas suportar uma entrevista por job opening por isso não faz muito sentido marcar mais do que uma entrevista para um candidato a não ser para remarcar a mesma entrevista (por exemplo, o candidato faltou justificadamente a uma entrevista anterior). Neste contexto, eu diria que faz mais sentido poder alterar a marcação de uma entrevista do que marcar mais do que uma entrevista para o mesmo candidato.

## 3. Analysis

### 3.1. Domain Model
Explain the domain model and its entities.

The domain model is composed of the following entities:

- **Application**: Represents the application of a candidate for a job opening.
- **Interview**: Represents an interview with a candidate for a job opening.

[Domain Model](C:\Users\Utilizador\Desktop\sem4pi-23-24-2dh3\final\docs\sprintC\1014\svg\1014-domain-model.svg)

## 3.2 System Sequence Diagram

[System Sequence Diagram - Full](C:\Users\Utilizador\Desktop\sem4pi-23-24-2dh3\final\docs\sprintC\1014\svg\1014-system-sequence-diagram-System_Sequence_Diagram__SSD.svg)


The Customer Manager requested a feature to record the time and date for an interview with a candidate.
This feature will allow the manager to schedule interviews, send confirmation notifications, adjust interview times, and view scheduled interviews.
The system should have validations to ensure that the data is accurate and conflicts are avoided.

## 4. Design

### 4.1. Realization

The realization of the functionality involves defining how the Customer Manager can record the time and date for an interview with
a candidate and how this information is stored and modified in the system. This requires interactions between various system components 
including the UI, business logic, and data persistence layers.
## 4.2 Sequence Diagram

![Sequence Diagram - Full](C:\Users\Utilizador\Desktop\sem4pi-23-24-2dh3\final\docs\sprintC\1014\svg\1014-sequence-diagram.svg)

A sequence diagram shows the interactions between the Customer Manager and the system to record an interview with an candidates.
This includes actions like viewing a list of job opening applications, the candidate associated, saving the interview, and modifying it later.

### 4.3. Class Diagram

![a class diagram](C:\Users\Utilizador\Desktop\sem4pi-23-24-2dh3\sem4pi-23-24-2dh3_final\docs\sprintC\1014\svg\1014-class-diagram.svg)

## 5. Implementation

- The implementation of record the time and date for an interview with a candidate involves several key components: the UI layer,
  the business logic layer, and the persistence layer.
  The primary goal is to allow the Customer Manager to record the time and date for an interview with a candidate, saving the time and the date, and modifying it later
  them as necessary. 

* Controller (RecordInterviewController): Manages the interaction with the JobOpeningApplicationService to record the date and te time.

* Repository (ApplicationRepository): Handles the persistence of application data, including the rankings assigned by the Customer Manager.

* Service (JobOpeningApplicationService): Handles the business logic for record the time and te date and persists the changes using the repository.

* UI (RecordInterviewUI): Provides a user interface for the Customer Manager to select job opening applications, view applications, and record the time and the date.

## 6. Integration/Demonstration

* Integration with other system components was verified by:

- Ensuring that the RecordInterviewController correctly interacts with the JobOpeningApplicationService.
- Validating that the JobOpeningApplicationService correctly persists the time and te date using the JobOpeningApplicationRepository.
- Testing the complete workflow from the UI to the service and persistence layers.
- To demonstrate this functionality:

1) Run the application.
2) Navigate to the Record Interview UI.
3) Select a job opening application.
4) View and record the time and te date.
5) Verify that the time and te date are saved and can be modified.

## 7. Observations

* During development, the following considerations were made:

- UI/UX: The UI was designed to be intuitive, allowing the Customer Manager to easily navigate and record te time and the date.
- Performance: The record operation was optimized to ensure quick response times, even with a large number of applications.
- Extensibility: The current implementation is modular.
future work to keep the initial implementation simple and focused on manual ranking by the Customer Manager.