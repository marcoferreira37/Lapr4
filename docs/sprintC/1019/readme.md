# US 1019

## 1. Context

This task involves developing a new feature to generate an ordered list of job candidates based on their interview points,
as requested by the Customer Manager for the first time in this sprint. 
The feature aims to assist the Customer Manager in analyzing and comparing candidates' performance efficiently, 
helping to make informed selection decisions by providing a clear, ranked list based on interview grades.

## 2. Requirements

**US 1019**  As Customer Manager, I want to get an ordered list of candidates, using the job
interview points (grades), to help me analyze the candidates.

**Acceptance Criteria:**

- 1019.1: The system should allow the Customer Manager to input or upload a list of candidates along with their interview points.
- 1019.2: The system should sort the candidates in descending order based on their interview points.
- 1019.3: The sorted list should be displayed clearly, showing each candidate's name and their respective interview points.
- 1019.4: The system should ensure data accuracy by validating the inputted interview points to be numerical and within a defined range (e.g., 0-100).
- 1019.5: The system should be able to handle a large number of candidates efficiently, ensuring quick sorting and display.

**Dependencies/References:**

- There is a dependency on the interview phase of the job opening, as the interview points are collected during this phase.


## 3. Analysis

The Customer Manager requested a feature to generate an ordered list of candidates based on their interview points.


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