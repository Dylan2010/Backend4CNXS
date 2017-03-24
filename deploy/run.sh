#!/bin/bash

if [ -z $MYSQL_ROOT_PASSWORD ]; then
      exit 1
  fi
 sed -i "s/MY_PASSWORD/$MYSQL_ROOT_PASSWORD/g" /opt/cnxs.sql
  mysql_install_db --user mysql > /dev/null

  mysqld --bootstrap --verbose=0 < /opt/cnxs.sql

 nohup  mysqld > /opt/db.log 2>&1 &
 /usr/local/tomcat/bin/catalina.sh run
