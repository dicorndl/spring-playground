#!/bin/bash

REPOSITORY=/home/ec2-user/app
PROJECT-NAME=dicorndl-spring-playground

echo "> Copy build file"
cp $REPOSITORY/packages/*.jar $REPOSITORY

echo "> Check current running application pid"
CURRENT_PID=$(pgrep -fl spring-playground | grep jar | awk '{print $1}')
echo "pid : $CURRENT_PID"

if [ -z "$CURRNET_PID"]; then
  echo "Already running..."
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> Deploy new application"
JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)
echo "JAR_NAME: $JAR_NAME"

echo "> Grant excutable"
chmod +x $JAR_NAME

echo "> Run $JAR_NAME"
nohup java -jar $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &