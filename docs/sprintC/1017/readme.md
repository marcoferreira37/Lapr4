# US 1017 - Upload Interview Answers

## 1. Context

This task is being assigned as part of the ongoing development efforts to enhance the company's recruitment process.
The goal is to provide the HR team and interviewers with the ability to upload interview answers directly into the system.
This feature will streamline the collection and organization of candidate responses, ensuring all relevant information
is stored in a central location for easy access and evaluation. This task is focused on adding new functionality to
the system, rather than fixing existing issues.

## Client Specifications

>Q227 Bruno Fernandes – US 1017 - Em termos "upload" certamente passa pela verificação com a gramática e após sucesso colocar o ficheiro das respostas da entrevista junto da pasta com os ficheiros da "Application" certo?
>
>A227. Sim, a sintaxe deve ser verificada e, se tudo estiver correto, o ficheiro deve ser “importado” para o sistema de forma a que possa ser usado posteriormente, por exemplo, no âmbito da US 1018. Qual a solução para o “importar” faz parte da vossa solução. Idealmente julgo que faria sentido que ficasse integrado na base de dados. Não sendo possível, penso que é aceitável que fique numa pasta/diretório de um servidor.

>Q214 Pedro – US1017/1018 – O nosso grupo tem uma dúvida em relação ao processamento dos ficheiros de respostas dos candidatos para a entrevista. No caso de upload de um ficheiro, se a pergunta que requer um número como resposta for preenchida com um formato inválido, por exemplo, uma letra, devemos considerar isso como um formato inválido na US 1017 (e pedir para o user voltar a dar upload a um ficheiro válido) ou devemos, na US1018, considerar que está incorreta e atribuir 0 pontos automaticamente para essa resposta inválida? Isto é, na US 1017, devemos apenas verificar o formato do ficheiro ou devemos verificar também se as respostas são preenchidas com o tipo de dados correto?
>
>A214. O caso mencionado deve ser considerado um erro de validação do ficheiro (ou seja, o ficheiro submetido não corresponde à gramática definida).

## 2. Requirements

**US 1017** As Customer Manager, I want to upload a text file with the candidate responses for an interview.

**Acceptance Criteria:**

- G1017.1. The uploaded file should be a text file
- G1017.2. The uploaded file should pass the grammar verification
- G1017.3. The uploaded file should be associated with the candidate's application
- G1017.4. The name of uploaded file should be stored in the system
- G1017.5. The uploaded file should be available for further processing
- G1017.6. The system should provide feedback on the success of the upload

**Dependencies/References:**

>See NFR09(LPROG).

Furthermore, it is necessary to view all the candidates that have applied for the job opening.

Has dependency in the user stories:

- US1008 - As Language Engineer, I want to deploy and configure a plugin (i.e., Job Requirement Specification or Interview Model) to be used by the system.


## 3. Analysis

### 3.1. Domain Model

The domain model is composed of the following entities:

![Domain Model](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintC\1017\svg\1017-domain-model.svg)

## 3.2 System Sequence Diagram

![System Sequence Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintC\1017\svg\1017-sequence-diagram.svg)

## 4. Design

## 4.1 Realization
The realization of the US 1017 functionality involves the following steps:

- User Interface (UI) Integration;
- File Upload Handling;
- Grammar Verification;
- File Validation;
- File Association and Storage;
- Record Keeping;
- Feedback to User.

## 4.2 Sequence Diagram

![Sequence Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintC\1017\svg\1017-system-sequence-diagram.svg)

### 4.3. Applied Patterns

The implementation of US 1017 leverages several design patterns to ensure a robust and maintainable system:

MVC (Model-View-Controller) Pattern:
Strategy Pattern;
Observer Pattern;
Command Pattern;
Factory Pattern;
Template Method Pattern;

The overall file upload and validation process can be defined in a template method, with specific steps like grammar verification and file storage being implemented in subclasses. This ensures a consistent process flow while allowing customization of individual steps.
These patterns collectively ensure that the system is modular, extensible, and easy to maintain, aligning with best practices in software design.

## 5. Implementation

- The implementation of the user story key components: the UI layer,
  the business logic layer, and the persistence layer.
  The primary goal is to allow the Customer Manager to upload the interview model text file, it be validated by the grammar
  and at least be saved in the system. 

* Controller (UploadInterviewAnswersFileUIController): Manages the interaction with the ApplicationService to upload the file.

* Repository (ApplicationRepository): Handles the persistence of application data.

* Service (ApplicationService): Handles the business logic for upload the file and persists the changes using the repository.

* UI (UploadInterviewAnswersFileUI): Provides a user interface for the Customer Manager to select the candidate, after your application and at least asks the path file.

## 6. Integration/Demonstration

* Integration with other system components was verified by:

- Validating that the ApplicationService correctly persists the file using the ApplicationRepository.
- Testing the complete workflow from the UI to the service and persistence layers.
- To demonstrate this functionality:

1) Run the application.
2) Navigate to the UploadInterviewAnswersFileUI.
3) Select a candidate.
4) Select an application.
5) Upload the path of the text file.
6) Validates the grammar of the file.
7) Verify that the file is uploaded and stored in the system.