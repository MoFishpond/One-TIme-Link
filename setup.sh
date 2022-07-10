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
  curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
  chmod +x /usr/local/bin/docker-compose
fi
docker-compose up -d