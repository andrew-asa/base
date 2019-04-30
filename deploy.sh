#! /bin/sh
# mvn install && cp target/com.asa.base-1.0-SNAPSHOT.jar "$dst/lib/com.asa.base-1.0-SNAPSHOT.jar" && cp target/com.asa.base-1.0-SNAPSHOT-sources.jar "$dst/lib/com.asa.base-1.0-SNAPSHOT-sources.jar"
dst=/Users/andrew_asa/Documents/code/github/andrew-asa/maven-repository/
version=1.0-SNAPSHOT
package=com/asa/com.asa.base
echo $dst$package/$version
rm -Rf $dst$package/$version
mvn deploy -DaltDeploymentRepository=andrew.asa-maven-repository::default::file:$dst
