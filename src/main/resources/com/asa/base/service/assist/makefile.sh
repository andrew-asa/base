#!/bin/sh
JAVA_HOME=/Users/andrew_asa/Downloads/openjdk/jdk8u192-b12/Contents/Home
gcc -dynamiclib -fPIC -c ForceGC.c -I ${JAVA_HOME}/include/ -I ${JAVA_HOME}/include/linux -I ${JAVA_HOME}/include/darwin
gcc -shared -fPIC -o ForceGC.dylib ForceGC.o