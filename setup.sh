#!/usr/bin/env bash
set -e

if ! [ -x "$(command -v docker)" ]
then
  echo "Set up docker..."
  curl -fsSL https://get.docker.com -o get-docker.sh
  sh get-docker.sh
fi

if ! [ -x "$(command -v docker-compose)" ]
then
  echo "Set up docker-compose..."
  sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
  sudo chmod +x /usr/local/bin/docker-compose
fi

if ! [ -x "$(command -v java)" ]
then
  echo "Set up Java8..."
  sudo apt-get update -y && sudo apt-get upgrade -y
  sudo apt-get install openjdk-8-jdk -y
fi

if ! [ -x "$(command -v mvn)" ]
then
  echo "Set up Maven..."
  wget https://dlcdn.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.tar.gz
  tar -xzvf apache-maven-3.8.6-bin.tar.gz
  source setup_maven.sh
fi

echo "Build project..."
cd backend && mvn clean package && cd ..
sudo docker-compose up -d