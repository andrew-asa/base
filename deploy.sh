#! /bin/sh
# dst=".."
# mvn install && cp target/com.asa.base-1.0-SNAPSHOT.jar "$dst/lib/com.asa.base-1.0-SNAPSHOT.jar" && cp target/com.asa.base-1.0-SNAPSHOT-sources.jar "$dst/lib/com.asa.base-1.0-SNAPSHOT-sources.jar"
mvn deploy -DaltDeploymentRepository=andrew.asa-maven-repository::default::file:/Users/andrew_asa/Documents/code/github/andrew-asa/maven-repository/
