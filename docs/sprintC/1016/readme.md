# US 1006 - As Customer Manager, I want the system to notify candidates, by email, of the result of the verication process

## 1. Context

This task is being assigned as part of the ongoing development efforts to automate the main activities of the company.
The task is to notify candidates, by email, of the result of the verication process

This task is not related to fixing a bug but rather adding a new feature to the system.

## 2. Requirements

**US 1016** As Customer Manager, I want the system to notify candidates, by email, of the result of the verication process.

**Acceptance Criteria:**

- G1014.1. The system should allow the manager to notify candidates, by email, of the result of the verification process.
- G1014.2. The system should persist the notification.
- G1014.3. The system should allow the manager to change the notification.

**Dependencies/References:**

Furthermore, it is necessary to view all the candidates that have applied for the job opening application.
Has dependency in the user stories:
- 2003 -> As Operator, I want to generate and export a template text file to help collect data
  fields for candidates of a job opening (so the data is used to verify the requirements of
  the job opening)
  authorization for all its users and functionalities.
- 2004 -> As Operator, I want to upload a text file with the data fields (requirements ) of a
  candidate for its verification.
- 1015 -> As Customer Manager, I want to execute the process of verification of requirements
  of applications for a job opening.


## 2.1 Product Owner Specifications

> **Question**: US1016 e US1020, relativamente ao envio das notificações por email, é necessário guardar que esse envio foi feito
>
> **Answer**: No documento nada de explicito é dito sobre este assunto. No entanto, do ponto de vista de gestão do processo da jobs4u parece-me adequado que essa informação fique registada.


> **Question**: US1016 – Acerca da US 1016 - "As Customer Manager, I want the system to notify candidates, by email, of the result of the verification process" qual é o processo através do qual essa notificação é gerada? Após a avaliação do Requirement Specification module, este gera um resultado "Aprovado" ou "Rejeitado". Este resultado despoleta automaticamente uma notificação para o candidato ou é o Customer Manager que tem a responsabilidade de informar o candidato através do sistema do resultado da verificação (ex. depois de um resultado negativo ser gerado, o Customer Manager vai no sistema rejeitar o candidato para que seja enviado o email)?
>
> **Answer**: É a segunda opção que apresenta. A US1015 permite que o Customer Manager invoque o processo de verificação de requisitos. Depois disso todas as candidaturas devem estar aceites ou recusadas. É então possível ao Customer Manager invocar a notificação através da US1016.


> **Question**: Management of screening data - We have a question about the management of the screen phase of the recruitment process. Specifically, after the applications are filtered during the screening process, I'm unsure about who manages the results and oversees this phase. Could you please clarify if the responsibility for managing the screening results falls under the customer manager, the operators, or both?
>
> **Answer**: In US2003 and US2004 it is the Operator that “downloads” a template file to register the requirements, registers the answers for the requirements in the file, and then uploads the file. It is then the Costumer manager that executes the verification process (US1015) and executes the notification of the results (US1016)


> **Question**:  em relação a US1016 que diz o seguinte: "As Customer Manager, I want the system to notify candidates, by email, of the result of the verifcation process". Eu gostaria de saber qual o formato da mensagem a seguir para enviar ao cliente, poderia ser algo do genero: "Dear [Candidate's Name], I hope this email finds you well. As the Customer Manager, I wanted to inform you about the outcome of the verification process for the position you applied for. After careful consideration of your application and qualifications, I'm pleased to inform you that you have successfully passed the verification process. Congratulations! Your application has met our initial criteria, and we are impressed with your qualifications and experience. We will be proceeding to the next phase of the selection process, which may include interviews or additional assessments. We will reach out to you soon with further details regarding the next steps. Thank you for your interest in our company and for taking the time to apply for the position. We appreciate your patience throughout the process. If you have any questions or need further assistance, please don't hesitate to contact us. Best regards, [Your Name] Customer Manager [Your Company Name]" Gostaria de saber as informações mais importantes quando se notificar o candidato, deve aparecer o nome do customer manager, a job reference, o nome do candidato. E se o email deve ser em inglês ou português.
>
> **Answer**: Pode ser como apresenta. Pode ser em português ou inglês.

> **Question**: US1016 - About the Us1016 wich states: "As Customer Manager, I want the system to notify candidates, by email, of the result of verification process". I want to know when the client says "verification process" is the same about the screening phase.
>
> **Answer**: Yes.

> **Question**:  Notify candidates - This user story has a functional dependency with 1015. I would like to know if an error occurs, do I need to delete what happened in US 1015, as if it were a transaction?
>
> **Answer**: The process of notification (US1016) must be done after the verification (US1015) but an error in the notification does not invalidate the “results” of the verification process.

## 3. Analysis

### 3.1. Domain Model
Explain the domain model and its entities.

The domain model is composed of the following entities:

- **JobOpening**: Represents the job opening for which candidates are applying.
- **JobOpeningProcess**: Represents the process of verifying the requirements of the job opening.

![Domain Model](svg\1016-domain-model.svg)

## 3.2 System Sequence Diagram

![System Sequence Diagram ](svg\1016-system-sequence-diagram-System_Sequence_Diagram__SSD_____Notify_candidates_by_email.svg)


The Customer Manager request the system to notify candidates, by email, of the result of the verication process
This feature will allow the manager to send a notification.


## 4. Design

### 4.1. Realization

The realization of the functionality involves defining how the Customer Manager can notify the candidate. This requires interactions between various system components
including the UI, business logic, and data persistence layers.

## 4.2 Sequence Diagram

![Sequence Diagram](svg\1016-sequence-diagram.svg)

A sequence diagram shows the interactions between the Customer Manager and the system to notify a candidates.

### 4.3. Class Diagram

![a class diagram](svg\1016-class-diagram.svg)

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*

*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this requirement.*

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in


## 5. Implementation

- The implementation of this us involves several key components: the UI layer,
  the business logic layer, and the persistence layer.
  The primary goal is to allow the Customer Manager to notify the candidate by email and send it another one later
  them as necessary.

* Controller (NotifyCandidatesUI): Manages the interaction with the NotifyCandidatesService to notify the candidate.

* Repository (CandidateRepository): Handles the persistence of application data.

* Service (NotifyCandidatesService): Handles the business logic.

* UI (NotifyCandidatesUI): Provides a user interface for the Customer Manager to notify the candidate.

## 6. Integration/Demonstration

* Integration with other system components was verified by:

- Ensuring that the NotifyCandidatesController correctly interacts with the NotifyCandidatesService.
- Validating that the NotifyCandidatesService correctly persists the time and te date using the CandidateRepository.
- Testing the complete workflow from the UI to the service and persistence layers.
- To demonstrate this functionality:

1) Run the application.
2) Navigate to the Notify Candidates UI.
3) Select a candidate.
4) Notify the candidate by email.
5) Verify that the email was sent.

## 7. Observations

* During development, the following considerations were made:

- UI/UX: The UI was designed to be intuitive, allowing the Customer Manager to easily navigate and send a email.
- Performance: The record operation was optimized to ensure quick response times, even with a large number of applications.
- Extensibility: The current implementation is modular.
