# Project Jobs4U

## 1. Description of the Project

Jobs4U is a company specialized in talent acquisition. The company provides recruitment services for job positions in its clients. The aim of this project is to develop, in an exploratory way,
a solution that allows automating the main activities of the company. Therefore, a minimum
viable product should be developed in 3 months.
The company’s clients are other companies or entities that need to recruit human resources.
In response to requests from its clients, Jobs4U develops all activities that allow it to select a
set of candidates for job offers (from its clients). At the end of the process, Jobs4U must deliver
to its client an ordered list of candidates for each job offer. The final recruitment decision is
the responsibility of the client

## 2. Planning and Technical Documentation

[Planning and Technical Documentation](docs/readme.md)

## 3. How to Build

* Windows
```bash
cd scripts
.\build.bat
```
* Linux/MacOS
```
cd scripts
./build.sh
```

## 4. How to Execute Tests


* Windows
```bash
cd scripts
.\runTest.bat
```
* Linux/MacOS
```
cd scripts
./runTest.sh
```

## 5. How to Run

* Windows
```bash
cd scripts
.\run.bat
```
* Linux/MacOS
```
cd scripts
./run.sh
```

## 6. How to Install/Deploy into Another Machine (or Virtual Machine)

To install/deploy the project into another machine (or virtual machine), you need to execute the following steps:

1. Build the project (see section 3)
```
./build-all.bat
```
```
./build-all.sh
```

2. Run the following script to run the project

```
./run.bat
```
```
./run.sh
```

## 7. How to Generate PlantUML Diagrams

To generate plantuml diagrams for documentation execute the script (for the moment, only for linux/unix/macos):

    ./generate-plantuml-diagrams.sh


