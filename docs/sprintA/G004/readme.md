# US G004

## 1. Context

* This task is being assigned for the first time and is being developed in this sprint. It is not about fixing a bug or completing an incomplete task from previous sprints.

## 2. Requirements

**US G004** As Project Manager, I want the team to setup a continuous integration server. 

**Acceptance Criteria:**

- G002.1. The system should be integrated with a continuous integration server.

- G002.2. GitHub Actions/Workflows should be used

**Dependencies/References:**

* No dependencies were found.

## 3. Analysis

* During the analysis stage, the team carefully looked at different things to decide on the best tools for starting the project and managing it. One important thing they considered was which version control system to use, which is really important for working on software together. They found that GitHub was a strong option because a lot of people use it, it has a lot of useful features, and it works well with other tools.


* In the end, the team decided that GitHub was the best choice after thinking about things like how easy it is to use and some other aspects. GitHub has a lot of features, it is very easy to use, which makes it great for modern software teams.


* The team also decided to use GitHub Actions/Workflows to automate the build and test processes. This will help the team to ensure that the code is always in a working state and that the tests are always passing.


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

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in this section statements/references regarding third party works that were used in the development this work.*