#!/bin/sh
git pull
mvn package
docker-compose down
docker build -t msansone/stockscontrol .
docker-compose up -d