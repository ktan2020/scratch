@echo off
mvn dependency:resolve
mvn test -DsuiteXmlFile=src/test/resources/SampleSuite.xml