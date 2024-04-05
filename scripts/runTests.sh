#!/usr/bin/env bash
echo make sure JAVA_HOME is set to JDK folder
echo make sure maven is on the system PATH
cd ../
bash -c "mvn test; exec bash"
