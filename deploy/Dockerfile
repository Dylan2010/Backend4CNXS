FROM reniowood/tomcat-jdk-mysql:latest
ENV MYSQL_ROOT_PASSWORD root
ENV CNXS_FILE_UPLOAD_PATH /images/
RUN rm -fr /usr/local/tomcat/webapps/ROOT
RUN rm -fr /usr/local/tomcat/webapps/docs
RUN rm -fr /usr/local/tomcat/webapps/examples
RUN rm -f /etc/mysql/my.cnf
ADD my.cnf /etc/mysql/my.cnf
ADD run.sh /opt/run.sh
ADD init.sql /opt/init.sql
ADD CNXS.war /usr/local/tomcat/webapps/ROOT.war
RUN chmod +x /opt/run.sh
WORKDIR /usr/local/tomcat

EXPOSE 8080

ENTRYPOINT ["/opt/run.sh"]
