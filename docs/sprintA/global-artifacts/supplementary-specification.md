# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._

  ### Email
* *Email is required to register a client.*
* *Email is required for a client to log in.*
  
  ### Authentication
* *All those who wish to use the
  application must be authenticated with a password *
  ### Language
* *The application's language should always be the same (English)*
  ### Security
* *The Customer Manager must be authenticated to manage the job openings.*
* *The Administrator must be authenticated to manage its customers and its managers.*
* *The Language Engineer must be authenticated to deploy and configure the plugin.*
* *The Customer must be authenticated to be able to follow job openings.*
* *The Candidate must be authenticated to be able to follow the applications.*
  ### System Management
* 
  ### Workflow
* *The store manager should be able the analyse his employees performance.*

## Usability 

_Evaluates the client interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._
* *Unit tests are performed to prevent errors on the application methods*
* *The application design should be organized and professional*
* *The application must be simple and easy to navigate*
* *The application must support the English language*


## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._
* *The software should be secure to prevent violations of security through the use of personal accounts and passwords*
* *The software should be able to perform at its peak at any day, anytime of the day*
* *The software should prevent errors from happening and resolve them the fastest possible if they do happen*

* *The system should be able to perform operations without occuring any problem*
## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

* *The system must be capable of performing operations quickly*
* *The system must be able to perform at his usual level with a large load of system users and data*
* *The application must consume little memory and CPU*



## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 



* *The application is configured in the English language*
* *The application should be compatible with updates and system actualizations*


### Design Constraints
_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._


* *The application is developed in Java and C language using IDE Intellij, other programming languages may be used in accordance to more specific requirements.*
* *Javadoc must be used to obtain useful documentation to java code*
* *Every US/class/method should have a relevant set of automated tests.*
* *The system must support and apply authentication and authorization for all its users and functionalities.*


### Implementation Constraints
_Specifies or constraints the code or construction of a system such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._
  * *All those who wish to use the application must be authenticated with a password of seven alphanumeric characters, including
    three capital letters and two digits.*
  * *Implementation language - The aplication is developed in Java and C language using IDE Intellij.*
  * *All tests must be implemented in JUnit 5*
  * *All the images/figures produced during the software development process should be recorded in
  SVG format*
  * *Javadoc must be used to obtain useful documentation to java code.*

### Interface Constraints


### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

*Nothing to report*

















