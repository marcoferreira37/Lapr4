# US 1021 - Display all the data of an application

## 1. Context

This task is being assigned as part of the ongoing development efforts to improve transparency and accessibility
within the recruitment process. The goal is to provide users with the ability to view all data related to a specific
job application in one place. This includes personal information, resume details, interview answers, and any other
relevant documents or notes. This feature aims to facilitate better decision-making by offering a comprehensive view
of each candidate's application. This task involves adding new capabilities to the system, rather than addressing
existing problems.

## Client Specifications

>Q202 Correia – US1021 – Quando se diz mostrar todo os dados de uma candidatura isso inclui, por exemplo, todos os dados do candidato, todos os dados da job opening relativa a essa candidatura, etc? Ou apenas, o id da job opening, o email do candidato, etc? Alem do curriculo claro.
>
>A202. Ver Q36.

>Q188 Campilho – US1021 – Listagem das applications - Gostaria de abordar um ponto específico relacionado à UI/UX User Story 1021. Eu sei que o cliente tem vindo a referir que devemos aplicar melhores práticas de UX/UI e que preferia não constrangir a forma como desenhamos a UI/UX. No entanto, a nossa preocupação é que, nesta US, no caso de haver um grande número de aplicações, a exibição de todas essas informações de uma vez poderá ficar confusa para o user. Por isso, queria apenas perguntar se poderíamos adotar uma solucão um pouco mais prática, como, por exemplo, pedir ao user para selecionar uma job opening e só depois listar as applications associadas a essa job opening e os dados dessas applications ou se, na sua visão, esta abordagem poderia restringir demasiadamente as opções oferecidas por esta funcionalidade.
>
>A188. Ver Q36. Esta US é para mostrar os dados de uma (1) candidatura. Deve haver uma forma do Customer Manager indicar (incluindo, eventualmente, forma de selecionar/”saber”/”pesquisar”) qual a candidatura (i.e., application) e o sistema mostra os dados dessa candidatura.

>Q184 Andre – US1021- Em relação à listagem dos dados de uma determinada jobApplication, um customer manager vai ter acesso a todas as jobApplications do sistema ou apenas às jobApplications feitas para uma job opening de um cliente que é gerido por esse customer manager?
>
>A184. Apenas às que está a gerir.


>Q179 Luis – US1021 - Relativamente à US1021, como é que a Application a exibir é escolhida? O utilizador pode começar por selecionar uma Job Reference e depois o e-mail de um dos candidatos? Ou recomenda uma outra abordagem?
>
>A179 Devem aplicar melhores práticas de UX/UI. Já houve perguntas anteriores sobre assuntos similares (ex: Q150). Note que existe uma US para listar todas as candidaturas a um job opening, por exemplo.

## 2. Requirements

**US 1021** As Customer Manager, I want to display all the data of an application.

**Acceptance Criteria:**

- G1021.1. The system shall display all the data of an application.
- G1021.2. The system shall display all the data of an application in one place.

**Dependencies/References:**

Furthermore, it is necessary to view all the candidates that have applied for the job opening.
Has dependency in the user stories:
- US 1005 - List all the applications of a job opening. 

## 3. Analysis

### 3.1. Domain Model

![Domain Model](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintC\1021\svg\1021-domain-model-US1021.svg)
## 3.2 System Sequence Diagram

![System Sequence Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintC\1021\svg\1021-system-sequence-diagram.svg)

## 4. Design

### 4.1. Realization

The realization of US 1021 involves several key steps to ensure that all data related to a specific job application is displayed comprehensively and efficiently. First, a user-friendly interface must be designed, allowing Customer Managers to navigate and view application data easily. This interface includes a search or selection mechanism enabling the manager to choose a specific application by either searching using criteria like job reference or candidate email or by selecting from a list of applications associated with a specific job opening.

## 4.2 Sequence Diagram

![Sequence Diagram - Full](C:\Users\leono\IdeaProjects\sem3pi2023\sem3pi2023\sem4pi-23-24-2dh3\docs\sprintC\1021\svg\1021-sequence-diagram-US_1021.svg)

## 5. Implementation


* Controller (ListJobOpeningApplicationsController)

* Repository (ApplicationRepository)

* UI (ListJobOpeningApplicationsUI)

## 6. Integration/Demonstration

* Integration with other system components was verified by:

- To demonstrate this functionality:

1) Run the application.
2) Navigate to the ListJobOpeningApplicationsUI.
3) Select a job reference.
4) Select an application.
5) Asks to show all data of the selected application.

