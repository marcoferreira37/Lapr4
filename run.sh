#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=jobs4u.app1/target/jobs4u.app1-0.1.0.jar:jobs4u.app1/target/dependency/*;

#REM call the java VM, e.g,
java -cp $BASE_CP hello.HelloWorld