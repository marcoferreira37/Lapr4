# US 3002 - As Customer, I want to list all my job openings, including job reference, position, active since, number of applicants.

## 1. Context

This task is being assigned as part of the ongoing development efforts to automate the main activities of the company.
The goal is to provide the Customer Manager with a way to list all job openings, including relevant information such as job reference, position, active since, and the number of applicants.

This task is not related to fixing a bug but rather adding a new feature to the system.

## Client Specifications

> *Question*: A lista job openings, position o que é?
> 
> *Answer*: Nessa US quando referimos “position” tem o mesmo significado que “title or function” na secção 2.2.2.


> *Question*: Job Openings Clarifications - You stated that one of the this to show in the listing of job openings is "active since". You've clarified that an active job opening is the one where its recruitment process is on-going. Are the job openings listed in this funcionality only the ones with recruitment process on-going? Or also the ones without recruitment processes, the ones with processes that haven't yet started or have ended?
>
> *Answer*: In the context of this US, “active since” means the date from the start of the process, the “application” phase (since that date, candidates can apply). This functionality should include all the “active” job openings.

## 2. Requirements

**US 3002** - As Customer, I want to list all my job openings, including job reference, position, active since, number of applicants.

**Acceptance Criteria:**

- G1013.1. The system should allow the customer to list all job openings
- G1013.2. The system should show the job reference, position, active since, and number of applicants for each job opening
- G1013.2. The system should persist the job openings

## 3. Analysis

### 3.1. Domain Model

The domain model is composed of the following entities:

- **JobOpening**: Represents a job opening in the company.
- **Costumer**: Represents a costumer that has applied for a job opening.

![Domain Model](C:\Users\Utilizador\Desktop\sem4pi-23-24-2dh3\sem4pi-23-24-2dh3_final\docs\sprintC\3002\svg\3002-domain-model-US1021___Display_all_the_data_of_an_application.svg)

## 3.2 System Sequence Diagram

![System Sequence Diagram](C:\Users\Utilizador\Desktop\sem4pi-23-24-2dh3\sem4pi-23-24-2dh3_final\docs\sprintC\3002\svg\3002-domain-model-US3002.svg)

The Customer requested to list all my job opening.

## 4. Design

### 4.1. Realization

The realization of the functionality involves defining how the Customer list all of my job openings.


## 4.3 Sequence Diagram

![Sequence Diagram ](C:\Users\Utilizador\Desktop\sem4pi-23-24-2dh3\sem4pi-23-24-2dh3_final\docs\sprintC\3002\svg\3002-sequence-diagram.svg)

The sequence diagram shows the interactions between the Customer and the system to list the job openings.
This includes actions like viewing a list of job openings and see the job reference, position, active since, number of applicants .

## 5. Integration/Demonstration

* Integration with other system components was verified by:

1) Run the application.
2) Navigate to the Server.
3) List the job opening.
4) View job reference, position, active since, number of applicants.
