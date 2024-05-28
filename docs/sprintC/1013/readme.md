# US 1013 - Rank Candidates for Job Opening

## 1. Context

This task is being assigned as part of the ongoing development efforts to automate the main activities of the company. 
The goal is to provide the Customer Manager with the ability to rank all the applicants/candidates for a certain job 
opening to assist in assigning the vacant position according to merits. 

This task is not related to fixing a bug but rather adding a new feature to the system.

## Client Specifications

> *Question*: Q142 Varela – US1013 - Candidate Ranking – Mr Client mention a manual ranking (Q17). 
> If the pontuation of an interview is not essential for the candidate's rank, what criteria is to be used when ranking?
> *Answer*: A142 Please view again Q17. The ranking is a decision of the Customer Manager based on all the data that 
> he/she may have during the process (including CV and other attached documents and the interviews as well as other 
> data/information that may not be part of the system).

> *Question*: Q155 Varela – US1013 - Rank Entries - Is there a limit on rank entries? Let's
>say that 100 candidates apply for a job opening. Does the Customer Manager
>have to sort all 100 candidates?
> *Answer*: A155 The order of candidates should include at least all the first candidates within the
>vacancy number andsome following candidates. At the moment, I do not know exactly the
>number of the following candidates to be ordered. Therefore, I would like for it to be a
>global configuration property in the system. It could be a number representing a magnitude
>from the vacancy number. For instance, 1 could mean exactly the same number of
>vacancies, 2 the double, 0,5 half the number of vacancies. The remainder of the
>candidates could be just tagged as not ranked.

> *Question*: Q157 Miguel – US1013 - Rank the candidates for a job Opening is the same as
>rank the job Applications for a Job Opening, knowing that I can only know the
>candidates throw the job application?
> *Answer*: A157 In the context of a job opening, a candidate is someone that made an application to
>that job opening. But the same person can be a candidate to other job openings.

> *Question*: Q158 Miguel – US1013 - Process of ranking - How is the ranking done? The
>customer manager selects a job opening and is shown the different
>candidates, and they assign a rank to each one. And the ranking process end
>when he assigns a rank to all candidates? Example: - Rank the candidate1: -
>Write the rank: 3 - Rank the candidate2: - Write the rank: 1 - Rank the
>candidate3: - Write the rank: 4
> *Answer*: A158 See Q155. Once again, I do not have specific requirements for UI/UX. But I can
>provide some ideas. Being a console application limits the UI/UX. However, I see this
>functionality similar to the way people enter recipients for an email, for instance. In the
>case of the recipients of an email I simply write their emails separated by a comma. Could
>it be similar in this case?

> *Question*: Q159 Miguel – US1013 - Stop the ranking process - When a customer manager
>starts the ranking process, he can stop and continue later? Or the ranking
>process must be done in one go?
> *Answer*: A159 See Q158. I guess it may depend on how you implement the solution. But, in the case
>it may work as a “long operation” be aware of when and how to conclude the “operation”

> *Question*: Q160 Miguel – US1013 - Edit ranking - The customer manager can change the
>rank of a candidate after assigning it?
> *Answer*: A160 See Q159. That should be possible if none of the interested parties were yet notified
>of the results

> *Question*: Q162 Miguel – US1013 - When the analysis phase ends, the ranking need to
>have all the candidates? or can the customer manager rank only some of the candidates?
> *Answer*: A162 See Q149. All the candidates should be ranked before moving to the result phase.

> *Question*: Q163 Miguel – US1013 - When the customer manager is ranking the
>candidates, in terms of UI, should we display information from the application
>such as interview score, etc... or just the candidate's name and email?
> *Answer*: AA163 As stated before, I do not have specific requirements for the UI/UX. Use best
>practices. However, I would like it to be possible for the Customer Manager to have 2 or
>more instances of the application running, so that he/she could, for instance, see the
>interviews grades and, at the same time, register the order/ranking of the candidates.

> *Question*: Q165 Varela – US1013 Clarifications - Mr. Client mentioned in Q155 that the
>system should have ranking configurations so that the Customer Manager
>doesn't have to rank all the candidates for a job opening, and that the ones
>that haven't been manually ranked are to be tagged with "not ranked".
>However, in Q162, you've said that all the candidates must be ranked before
>the result phase starts. Can you clarify this situation?
> *Answer*: A165 The customer manager must evaluate all the candidates. It is the only way he/she
>can produce a ranking/order for the candidates and select the “best” candidates to be
>included in the vacancies for the job opening. In Q155 I was only proposing a way to avoid
>recording in the system a lot of details that will not have any impact on the next activities.
>The term “not ranked” maybe is not the best. Maybe “rank not recorded” or something
>similar could be more appropriated.

> *Question*: Q183 Costa – US1013 – documents - When ranking the candidates, the
>customer manager makes decisions based on their CV and other relevant
>documents. My question is: should there be an option for the customer
>manager to view the relevant documents before ranking a candidate? Or has
>the customer manager already made the decision before ranking the
>candidates and purely uses this functionality to assign the previously planned ranking?
> *Answer*: A183. Once again this could be only a UX/UI issue. Please refer to Q17, Q163 and Q140.
Also note that there is US1021 for listing application data

> *Question*: Q192 Varela – US1013 – Global Configurations – I'm struggling to understang
>the global configurations defined for US1013. All candidates must be ranked,
>so that all of them can be notified. Are the global configurations only for
>persistence purposes? Example: all candidates are ranked and notified, so if
>0.5 is in the global definition, then only half of the number of vancancies must
>be persisted in the system. Is this the scenario that Mr. Client has in mind?
> *Answer*: A192. I am assuming you refer to Q155. Suppose you have 2 vacancies. You have 80
>candidates. If you configure the property as 1 you need to rank (record in the system) the 2
>first candidates plus 2 other candidates. If the property is 0,5 you should rank the 2 first
>candidates plus 1 third candidate. If the property is 2, you should rank the 2 first
>candidates plus 4 extra candidates. This is a way to assure that you do not have to record in
>the system the rank of all the possible candidates, but only a number that includes the
>ones required to fulfill the vacancies plus some extra (according to the property) for
>possible exceptions (such as someone leaving the application). But my suggestion was
>only to help in the UI/UX. You may use any other option.

> *Question*: Q198 Padilla – US1013 – The ranking of candidates should be save in an array
>to be able to do easier the result phase?
> *Answer*: A198. This question is about the design/implementation of the solution. I have no specific
>opinion regarding this specific question

> *Question*: Q215 Araujo – US1013 – About the Us1013 which states: "As Customer
>Manager, I want to rank the candidates for a job opening.". I want to know if
>two candidates can be tied, which would mean having the same rank for the
>same job opening
> *Answer*: A215. No, ties should not be allowed. It must be clear what candidates are selected to the
>vacancies.

> *Question*: Q216 Varela – US1013 – Can we assume that once an interview is evaluated,
>a score is provided and that score is initially used for the rank entry
>associated with said application? The Customer Manager is then capable of
>defining manually the rank order.
> *Answer*: A216. I see no need for that. This would be an extra functionality.

> *Question*: Q216 Varela – US1013 – Can we assume that once an interview is evaluated,
>a score is provided and that score is initially used for the rank entry
>associated with said application? The Customer Manager is then capable of
>defining manually the rank order.
> *Answer*: A216. I see no need for that. This would be an extra functionality.

## 2. Requirements

**US 1013** As Customer Manager, I want to rank the candidates for a job opening.

**Acceptance Criteria:**

- G1013.1. The system should allow the manager to rank candidates
- G1013.2. The system should persist the rankings of the candidates
- G1013.3. The system should allow the manager to change the ranking of the candidates
- G1013.4. The application should be in the phase Analysis
- G1013.5. The system should check that the rank is an integer number

**Dependencies/References:**

Furthermore, it is necessary to view all the candidates that have applied for the job opening.
Has dependency in the user stories:
- G007 -> As a Project Manager, I want the system to support and apply authentication and
  authorization for all its users and functionalities.
- 1002 -> As Customer Manager, I want to register a job opening.
- 2002 -> As Operator, I want to register an application of a candidate for a job opening and
  import all files received.

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

The Customer Manager requested a feature to rank the candidates for a job opening. 
This feature will allow the manager to rank the candidates, persist the rankings, change the rankings, and view the rankings. 
The system should have validations to ensure that the data is valid.

## 4. Design

### 4.1. Realization

The realization of the functionality involves defining how the Customer Manager can rank candidates 
and how these rankings are stored and modified in the system. 
This requires interactions between various system components including the UI, business logic, 
and data persistence layers.

## 4.2 Sequence Diagram

![Sequence Diagram - Full](svg/us017-sequence-diagram-full.svg)

The sequence diagram shows the interactions between the Customer Manager and the system to rank candidates. 
This includes actions like viewing a list of candidates, assigning a rank, saving the rank, and modifying it later.

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*

*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this requirement.*

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in this section statements/references regarding third party works that were used in the development this work.*