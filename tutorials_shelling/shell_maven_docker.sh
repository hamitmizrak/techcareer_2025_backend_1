#!/bin/bash

echo "Spring Boot Starting Dockerize"

#chmod +x shell_maven_docker.sh
#chmod +x shell_manuel_project.sh
chmod +x shell_countdown.sh

# Maven deployment
version_info(){
  ./shell_countdown.sh
  mvn -v
  git -v
  java -version
  javac -version
  docker version
}
version_info

#########################################################
# Maven deployment
maven_deployment(){
  ./shell_countdown.sh
  #mvn clean package
  cd ..
  mvn clean package -DskipTests
}
maven_deployment

#########################################################
# Docker Deployment
docker_deployment(){
  ./shell_countdown.sh
  docker-compose up
  #docker-compose up -d
}
docker_deployment