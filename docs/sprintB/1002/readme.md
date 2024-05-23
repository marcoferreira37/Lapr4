# US 1002

## 1. Context

This task involves registering a job opening.
It's essential for the Customer Manager role to have this functionality available.
This task is assigned for development in this sprint.

## Client Specifications

> *Question*: Q77 Simões – US1002 Critérios de Aceitação – Relativamente à US1002 - "As Customer Manager, I want to
> register a job opening",
> existe algum critério de aceitação ainda não mencionado, relacionado com os atributos? Ou fica ao critério da equipa
> de
> desenvolvimento consoante boas práticas e senso comum? Alguns exemplos: - O "Number of Vacancies" não poder ser menor
> ou igual a 0 ou pode ser opcional;
> A "Description" ter um tamanho de caracteres limite ou ser opcional;
> *Answer*: A77 - Sobre se existem critérios de aceitação não mencionados não me vou pronunciar, faz parte do processo
> descobrirem.
> Eu sugeria usarem algo mais que o senso comum

> *Question*: Q79 Padilla – US1002 - Could we use the same interview model for more than one job opening?
> *Answer*: A79 - See Q38. Yes.

> *Question*: Q88 Cardoso** – US1002 – Quando o Customer Manager regista uma job offer, é ele que cria as requirement
> specifications e
> as interview models ou é-lhe dada uma lista destes para ele selecionar?
> *Answer*: A88 - Existe a US1002 e as US1009 e US1011. Penso que está claro qual a responsabilidade de cada uma.
> A criação dos modelos das entrevistas e dos requisitos é um caso de uso especifico e com um US especifica para
> registar no sistema os respectivos plugins (US1008).

> *Question*: Q109 Varela – [US1002] Modo de Trabalho e Tipo de Contrato- Numa job opening,
> o tipo de contrato e o modo de trabalho são elementos fixos, na medida em que os tipos apresentados na documentação
> são estáticos e não mudam, ou poderão haver mais tipos deste dois elementos?
> *Answer*: A109 Os mais “normais” serão os que aparecem na documentação.
> Mas penso que faz sentido o sistema aceitar outros diferentes caso o Customer Manager assim o entender.

> *Question*: Q114 Guedes – US1002 - Um customer manager tem a responsabilidade de criar job openings para os customers
> em que é responsável. Na hora da criação da job opening, como é que ele refere qual é o customer daquela job opening?
> Seleciona um customer dentro dos que está responsável?
> *Answer*: A114. Sim, pode ser como indica.

## 2. Requirements

**US 1002** As Customer Manager, I want to register a job opening.

**Acceptance Criteria**

* 1002.1. The system should allow the Customer Manager to create a new job opening.
* 1002.2. The job opening should include fields for description, address, mode, contract type, title rr function,
  vacancies number, company Id.
* 1002.3. The system should validate the input details before registering the job opening.
* 1002.4. The job opening should be added to the database upon successful registration.
* 1002.5. The system should provide a user interface for job opening registration.
*

**Dependencies/References:**

*Alternatively, this can be achieved by a bootstrap process.*

### 3.1. Domain Model

The domain model is composed of the following entities:

- **JobOpening**: Represents a job opening in the company.

![Domain Model](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintB\1002\svg\1002-domain-model.png)

## 3.2 System Sequence Diagram

![System Sequence Diagram - Full](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintB\1002\svg\1002-system-sequence-diagram-System_Sequence_Diagram__SSD____Register_job_opening.png)

- The System Sequence Diagram (SSD) for registering a job opening illustrates the interaction between the "Customer Manager" 
and the System. 
- It begins with the Customer Manager's request to register a new job opening, 
followed by providing the job details such as description, vacancies number, and address. 
- The System then prompts the Manager to select the job opening mode and type, and subsequently asks for additional requirements 
like title or function and company ID. 
- After the Manager provides the necessary information, the System confirms the registration and notifies 
the Manager of the successful registration. 
- This diagram succinctly visualizes the structured flow of interaction between the user and the system during the job opening registration process.

## 4. Design

### 4.1. Realization

The sequence diagram outlines the interaction between the Customer Manager and the system components to list job
openings.
The domain model illustrates the key entities and relationships relevant to the job openings functionality.
This requires interactions between various system components including the UI, business logic,
and data persistence layers.

## 4.2 Sequence Diagram

![Sequence Diagram - Full](C:\Users\gonca\IdeaProjects\sem4pi-23-24-2dh3\docs\sprintB\1003\svg\1003-sequence-diagram-List_Job_Openings___Sequence_Diagram.png)

- The sequence diagram shows the process of listing job openings with filters.
  The Customer Manager requests to list job openings via the UI.
  The UI fetches filtering strategies from the controller and presents them to the Customer Manager.
- After selecting a strategy and inputting criteria, the controller uses the JobOpeningService to retrieve and
  filter job openings from the JobOpeningRepository.
- The filtered job openings are then returned and displayed to the Customer Manager.
  This process involves interactions between the UI, controller, service, filtering strategy,
  and repository to ensure the correct job openings are displayed based on the selected filters.

## 3. Analysis

- During the analysis phase, we delved into the intricacies of the job opening registration requirement,
  aiming to align the system's capabilities with the expectations of the Customer Manager.
- Stakeholder interviews provided valuable insights,
  guiding us to prioritize features and define acceptance criteria.
- We scrutinized existing processes in analogous systems,
  seeking inspiration and identifying potential enhancements.

## 4. Design

## 5. Implementation

- Job opening registration functionality is implemented within the system,
  allowing Customer Managers to register new job openings.
- The system validates the input details and adds the job opening to the
  database upon successful registration.
- A bootstrap process is developed as an alternative method for achieving job
  opening registration during system initialization.

## 6. Integration/Demonstration

To integrate this functionality with other parts of the system, ensure that:

The UI components are properly integrated with the overall user interface of the system.
The controller interacts seamlessly with other controllers and services.
The repository integrates with the database or storage system used by the system.
You can demonstrate this functionality by following these steps:

- Log in as a Customer Manager.
- Navigate to the job opening registration section.
- Fill in the required job details.
- Submit the form to create a new job opening.
- Verify that the job opening is visible to applicants.

## 7. Observations

Ensure that the job opening registration process aligns with the requirements specified by the client and complies with
any legal or organizational policies.
Consider implementing additional features, such as validation for job opening fields and support for
multiple job opening types and modes, based on future requirements or feedback.