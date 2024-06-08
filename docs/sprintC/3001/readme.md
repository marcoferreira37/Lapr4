# US 3001 - As Candidate, I want to be notified in my application when the state of one of my applications changes.
## 1. Context

This task involves enabling Candidates to receive notifications within their application when the state of one of their applications changes. Implementing this functionality is crucial for providing real-time updates to Candidates regarding the progress of their applications. The solution must adhere to specific technical requirements specified in NFR10(RCOMP) and NFR11(RCOMP), including the use of a client-server architecture and deployment across multiple network nodes.

## 2. Requirements

**3001** As a Candidate, I want to be notified in my application when the state of one of my applications changes.

**Acceptance Criteria:**

- 3001.1. The Candidate application provides a notification feature to inform Candidates when the state of one of their applications changes.
- 3001.2. Notifications include details such as the application ID, the previous state, the new state, and a timestamp of the state change.
- 3001.3. Notifications are displayed in real-time within the Candidate application.
- 3001.4. The Candidate application communicates with the server application to receive notifications.
- 3001.5. The solution follows a client-server architecture, where the Candidate application accesses the server application.
- 3001.6. The solution is deployed across several network nodes, with the relational database server and the Follow Up Server deployed on different nodes, preferably in the cloud.

**Dependencies/References:**

- NFR10(RCOMP) - Functionalities related to the Candidate and Customer Apps and to the Follow Up Server part of the system have very specific technical requirements. It must follow a client-server architecture, where a client application is used to access a server. Communications between these two components must follow specific protocol described in a document from RCOMP ("Application Protocol"). Also, the client applications can not access the relational database, they can only access the server application.
- NFR11(RCOMP) - The solution should be deployed using several network nodes. It is expected that, at least, the relational database server and the Follow Up Server be deployed in nodes different from localhost, preferably in the cloud. The email notification tasks must be executed in background by the Follow Up Server.

## 3. Analysis

The analysis focuses on understanding the requirements for notifying Candidates within their application when the state of one of their applications changes. This includes identifying the functionalities necessary for providing a notification feature, including details such as application ID, previous state, new state, and timestamp of the state change. Additionally, considerations are made regarding the technical requirements specified in NFR10(RCOMP) and NFR11(RCOMP) and the use of a client-server architecture for communication.

### Client Clarifications
> **Question:**
> Na US 3001 pretende que o candidato seja notificado na sua aplicação quando o estado de uma aplicação mudar.
> De que forma pretende que o candidato seja notificado? E caso o candidato não esteja a correr a aplicação,
> essa notificação é perdida?
>
> **Answer:**
> O candidato deve ser notificado quando a sua “app” está em execução. Relativamente a notificações que “acontecem”
> quando não está a correr a aplicação, seria interessante que as recebesse da próxima vez que executasse a aplicação
>
> **Question:**
> Questão âmbito notificações - O candidato será notificado, quando a sua candidatura mudar de estado.
> O que se entende por notificado, é receber um email, quando entra na aplicação tem uma fila de 'inbox' ?
> Quando a aplicação está ligada recebo email? É o candidato que faz o pedido(cliente) (Pop) inicia assim
> a comunicação, e recebe a resposta/notificação (servidor). E como encaixo o cenário de notificação(push)?
>
> **Answer:**
> Neste caso as notificações são na aplicação do candidato, não são por email.
>
> **Question:**
> – I'd like some clarifications regarding the state that US3001 mentions. Is it the "accepted/not accepted"
> state, or a state regarding the phases of the recruitment process of which the application is associated to?
>
> **Answer:**
> This US is focused on the Candidate perspective. He/she may not be aware of the internal phases of the recruitment
> process. But he/she is interested in knowing the “external” state of his/her applications. For instance, as a candidate
> I would like to know if my application was received. Then I would like to know if my application was accepted or not and,
> finally, if I was selected or not
>
> **Question:**
> Segundo a nossa perspetiva sobre esta funcionalidade, achámos melhor o utilizador ter na sua aplicação uma espécie
> de inbox de notificações. Quando o utilizador está na funcionalidade das notificações este recebe as notificações
> que tinha e que não foram enviadas porque não estava na aplicação e depois fica á espera de novas notificações que
> apareçam entretanto, até o utilizador pedir para sair da funcionalidade. Esta abordagem está alinhada com suas
> expectativas?
>
> **Answer:**
> Pode ser. Mas não seria possível receber as notificação mesmo não estando nessa “opção de menu”? Sendo uma aplicação
> “console” limita um pouco a UI, mas não seria possível receber as notificações desde que tenha a aplicação em execução
> mas só mostrar essas notificações quando o utilizador seleciona a opção? Em termos de UI a diferença é mínima, em termos
> de implementação pode ser significativa. Talvez esta seja até mais uma questão para RCOMP.
>
> **Question:**
> Em questões anteriores sobre esta funcionalidade menciona que como candidate gostaria de saber se a sua candidatura foi
> recebida, aceite e escolhida. Pedimos que descreva a que se refere quando diz que uma candidatura foi aceite, e quando
> foi escolhida.
>
> **Answer:**
> É aceite se passa o processo de verificação de requisitos. É escolhida se após o ranking está dentro dos lugares
> das vagas para o job opening.

## 4. Design

### 4.1. Realization

The functionality for notifying Candidates within their application when the state of one of their applications changes is implemented. This involves providing a notification feature within the Candidate application, communicating with the server application to receive notifications, and displaying notifications in real-time. The solution adheres to specific technical requirements such as client-server architecture and deployment across multiple network nodes.

### 4.2. Use Case Diagram

[Use Case Diagram](svg/3001-UCD.svg)

### 4.3. Sequence Diagram

[Sequence Diagram](svg/3001-system-sequence-diagram.svg)

### 4.4. Class Diagram

No Class Diagram was needed for created for this user story.

### 4.5. Tests and implementation

N/A

## 5. Implementation

The Candidate application is implemented to provide a notification feature informing Candidates when the state of one of their applications changes. This involves communicating with the server application to receive notifications, displaying notifications in real-time within the Candidate application, and ensuring adherence to specific technical requirements such as client-server architecture and deployment across multiple network nodes.


## 6. Integration/Demonstration

Thorough testing and demonstration are conducted to validate the functionality and usability of the notification feature within the Candidate application. This includes testing the receipt and display of notifications in real-time, ensuring accuracy of notification details, and verifying adherence to specific technical requirements. The demonstration showcases how Candidates can efficiently receive notifications within their application when the state of one of their applications changes.

## 7. Observations

Enabling Candidates to receive real-time notifications within their application is essential for providing timely updates regarding the progress of their applications. Continuous monitoring and updates may be necessary to enhance the notification feature based on feedback and evolving requirements. Additionally, thorough documentation and training should be provided to Candidates on how to effectively utilize this feature for staying informed about their application statuses.