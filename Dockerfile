FROM openjdk:8-jre-slim

# Add the jar with all the dependencies
# Maven creates container-test.jar in the target folder of my workspace.
# We need this in some location - say - /usr/share/tag folder of the container

ADD  target/TestProject.jar /usr/share/tag/TestProject.jar
ADD  target/libs /usr/share/tag/libs

# Add the suite xmls
ADD testng-module.xml /usr/share/tag/testng-module.xml


# Command line to execute the test
# ENTRYPOINT "/usr/bin/java", "-jar", "/usr/share/tag/TestProject.jar" 

ENTRYPOINT /usr/bin/java -cp /usr/share/tag/TestProject.jar:/usr/share/tag/libs/* -DseleniumHubHost=$SELENIUM_HUB  org.testng.TestNG /usr/share/tag/testng-module.xml

#ENTRYPOINT ["/usr/bin/java", "-cp", "/usr/share/tag/TestProject.jar", "org.testng.TestNG",  "test.java.BuzzproAdvertisingTest"]

