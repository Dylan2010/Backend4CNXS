FROM reniowood/tomcat-jdk-mysql:latest
ENV MYSQL_ROOT_PASSWORD root
RUN rm -fr /usr/local/tomcat/webapps/ROOT
RUN rm -fr /usr/local/tomcat/webapps/docs
RUN rm -fr /usr/local/tomcat/webapps/examples
ADD run.sh /opt/run.sh
ADD cnxs.sql /opt/cnxs.sql
ADD CNXS.war /usr/local/tomcat/webapps/ROOT.war
RUN chmod +x /opt/run.sh
WORKDIR /usr/local/tomcat

EXPOSE 8080

ENTRYPOINT ["/opt/run.sh"]
