#!/bin/bash

ls -la /app/
env
export
export NLS_LANG="BRAZILIAN PORTUGUESE_BRAZIL"
java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS \
-jar /app/${APP_NAME}.jar ${EXTRA_PROPERTIES} \
