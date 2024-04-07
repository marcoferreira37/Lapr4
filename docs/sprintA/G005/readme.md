# US G005



## 1. Context

*This user story involves creating scripts to build, clean, rebuild and run tests*

## 2. Requirements


**US G005** As Project Manager, I want the team to add to the project the necessary scripts, so that build/executions/deployments/... can be executed effortlessly.

**Acceptance Criteria:**

- G002.1. The scripts should be able to build, run the tests and clean the project without errors.
- G002.2. The scripts should be written in bash and shell and stored in the root of the project.

**Dependencies/References:**

*To run the script make sure that JAVA_HOME is set to the JDK folder and maven is on the system PATH*

## 3. Analysis

* This specific user story didn't require any analysis artifacts

### 4.1. Realization

*The chosen solution involves creating a set of scripts that will allow the team to build, run tests and clean the project without errors. The scripts will be written in bash and shell and will be stored in the root of the project.*

### 4.4. Tests

*There was no need for tests in this user story*

## 5. Implementation

*Windows batch script to build, run tests and clean the project*

```batch
@ECHO OFF
ECHO make sure JAVA_HOME is set to JDK folder
ECHO make sure Maven is on the system PATH
cd ../
cmd /k mvn %1 dependency:copy-dependencies package
```
```batch
@echo off

cd ../

cmd /k mvn test
```
```batch
@echo off

cd ../

REM Clean the project using Maven
cmd /k mvn clean
```
*Linux shell script to build, run tests and clean the project*
    
```
#!/usr/bin/env bash
echo make sure JAVA_HOME is set to JDK folder
echo make sure maven is on the system PATH
cd ../
bash -c "mvn $1 dependency:copy-dependencies package; exec bash"
```
```
#!/usr/bin/env bash
echo make sure JAVA_HOME is set to JDK folder
echo make sure maven is on the system PATH
cd ../
bash -c "mvn test; exec bash"
```
```
#!/usr/bin/env bash
cd ../
bash -c "mvn clean; exec bash"
```


## 6. Integration/Demonstration
* To run the script make sure that JAVA_HOME is set to the JDK folder and maven is on the system PATH
* Run the scripts by running the files in the terminal or command prompt

## 7. Observations

*No observations needed.*
