# US 3003

## 1. Context

This task involves implementing the functionality for customers to receive notifications in their application
when the state (phase) of their job openings changes. 
It's essential for customers to stay updated on the progress of their job openings.
This task is being assigned for development in this sprint.

## Client Specifications

>*NO SPECIFICATIONS PROVIDED YET*

## 2. Requirements

**US 3003** As Customer, I want to be notified in my application when the state (phase) of my job openings changes.

**Acceptance Criteria:**

- 3003.1. The system should allow customers to receive notifications in their application when the state of their job openings changes.

- 3003.2. Notifications should be timely and accurately reflect the current state of the job openings.

- 3003.3. Customers should have the option to customize notification preferences for different types of state changes.

**Dependencies/References:**

*This requirement relates to NFR10(RCOMP) and NFR11(RCOMP).*

## 3. Analysis

*In this section, the team should report the study/analysis/comparison that was done in order to take the best design decisions for the requirement. This section should also include supporting diagrams/artifacts (such as domain model; use case diagrams, etc.),*

During the analysis phase, we conducted a study to understand the requirements for notifying customers 
about changes in the state of their job openings. We considered factors such as the frequency of notifications,
the types of state changes to be notified, and the customization options for notification preferences.

## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (presenting the classes that support the functionality), the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*

### 4.1. Realization

### 4.2. Class Diagram

![a class diagram](class-diagram-01.svg "A Class Diagram")

### 4.3. Applied Patterns

### 4.4. Tests

Include here the main tests used to validate the functionality. Focus on how they relate to the acceptance criteria.

**Test 1:** *Verifies that it is not possible to ...*

**Refers to Acceptance Criteria:** G002.1


```
@Test(expected = IllegalArgumentException.class)
public void ensureXxxxYyyy() {
	...
}
````

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*
*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this requirement.*

* The implementation ensures that customers receive timely notifications
in their application when the state of their job openings changes.
Notifications are designed to accurately reflect the current state of the job openings, 
and customers have the flexibility to customize their notification preferences based on their requirements.


## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*
*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

* Efforts have been made to integrate this functionality seamlessly with other parts of the system. 
Notifications are triggered based on changes in the state of job openings and are delivered to customers 
via their application interface.

*To demonstrate this functionality:*

- Log in as a customer.

- Navigate to the section for managing job openings.

- Make changes to the state of a job opening.

- Verify that the customer receives a notification reflecting the state change.

## 7. Observations

This section should be used to include any additional comments or observations regarding the implementation of this functionality. It is important to ensure that the notification system is robust and reliable, providing customers with timely updates on their job openings. Feedback from customers should be considered to refine and improve the notification mechanism.