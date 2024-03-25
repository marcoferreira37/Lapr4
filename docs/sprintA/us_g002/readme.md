# US G002

## 1. Context

This task involves setting up the project repository and 
configuring a project management tool.

## 2. Requirements

* Project Repository (GitHub): Create a GitHub repository for the project to store all project-related files
and source code. It will facilitate collaboration, version control, and document management. 
* Project Management Tool: Choose and set up a project management tool to streamline project planning, 
task tracking, and communication. It will enable task assignment, progress monitoring, and issue management.

**US G002** As Project Manager I Want the team to use the defined project 
repository and setup a tool for project management;

**Acceptance Criteria:**

**G002.1.** GitHub repository is created with an appropriate name that reflects the project's purpose or name.

**G002.2.** Team members are added to the GitHub repository with the appropriate permissions, allowing them to collaborate and contribute to the project.

**G002.3.** Initial project files, including README, and any relevant documentation, are added to the GitHub repository.

**G002.4.** The project repository is organized into relevant folders or categories to facilitate easy navigation and access to project resources.

**G002.5.** Version control mechanisms, such as branching and merging strategies, are established and documented within the GitHub repository.

**G002.6.** The GitHub repository is configured to enable issue tracking, allowing team members to report and address project-related issues effectively.

**Dependencies/References:**

- No dependencies were found.

## 3. Analysis

*In this section, the team should report the study/analysis/comparison that was done in order to take the best design decisions for the requirement. This section should also include supporting diagrams/artifacts (such as domain model; use case diagrams, etc.),*

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