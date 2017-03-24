#!/bin/bash

if [ -z $MYSQL_ROOT_PASSWORD ]; then
      exit 1
  fi
 sed -i "s/MY_PASSWORD/$MYSQL_ROOT_PASSWORD/g" /opt/init.sql
  mysql_install_db --user mysql > /dev/null

 mysqld --bootstrap --verbose=0 < /opt/init.sql

 nohup  mysqld > /opt/db.log 2>&1 &
locktom="running"

while [ "$(echo $locktom)" != "ok" ]; do
  sleep 1
  mysqladmin -uroot -p$MYSQL_ROOT_PASSWORD processlist
  if [ $? -eq 0 ]
        then
            locktom="ok"
            mysql -uroot -p$MYSQL_ROOT_PASSWORD < /opt/cnxs.sql
  fi
done
 /usr/local/tomcat/bin/catalina.sh run
