#!/bin/bash
WorkDir=`pwd`
cd CNXS
tag=`cat $WorkDir/tag`
mvn package
cd $WorkDir
#cp DataBase/cnxs.sql deploy/cnxs.sql
cp CNXS/target/CNXS.war deploy/CNXS.war
cd deploy
docker rm -f backend
docker rmi cndsbackend:$tag
docker build -t cndsbackend:$tag .
docker run -dit --name backend -v /root/img:/images -v /root/mysql/data:/var/lib/mysql -p 8080:8080 cndsbackend:$tag
docker rm -f imgserver
docker run -dit --name imgserver -p 8011:8080 -v /root/img:/opt/www webratio/nodejs-http-server

