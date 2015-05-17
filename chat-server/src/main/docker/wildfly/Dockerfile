FROM jboss/wildfly:8.2.0.Final
#needed because the image did not expose this port
EXPOSE 9990
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
