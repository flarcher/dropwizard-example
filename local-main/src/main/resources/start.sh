#!/bin/sh
# Start script for Unix-based OS

LOCAL_DIR=$(dirname $0)
java -jar "$LOCAL_DIR/${project.build.finalName}.jar" server "$LOCAL_DIR/configuration.yml" $1
