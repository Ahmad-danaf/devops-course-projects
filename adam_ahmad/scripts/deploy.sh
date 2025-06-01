#!/bin/bash

echo "=== Starting Deployment ==="

TOMCAT_PATH="/c/Program Files/Apache Software Foundation/Tomcat 8.5/webapps"
APP_NAME="adam_ahmad"

# Clean old app
rm -rf "$TOMCAT_PATH/$APP_NAME"
mkdir -p "$TOMCAT_PATH/$APP_NAME"

# Copy new version
cp -r adam_ahmad/* "$TOMCAT_PATH/$APP_NAME/"

echo "✅ Deployment finished: http://localhost:8080/$APP_NAME/"