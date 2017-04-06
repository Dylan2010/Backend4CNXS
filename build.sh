#!/bin/bash
WorkDir=`pwd`
cd CNXS
tag=`cat $WorkDir/tag`
mvn package
cd $WorkDir
cp DataBase/cnxs.sql deploy/cnxs.sql
cp CNXS/target/CNXS.war deploy/CNXS.war
cd deploy
docker rm -f backend
docker rmi cndsbackend:$tag
docker build -t cndsbackend:$tag .
docker run -dit --name backend -v /root/img:/images -p 8080:8080 cndsbackend:$tag
