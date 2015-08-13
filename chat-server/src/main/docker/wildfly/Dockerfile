FROM jboss/wildfly:9.0.0.Final
#needed because the image did not expose this port
EXPOSE 9990
RUN /opt/jboss/wildfly/bin/add-user.sh ${wildfly.remote.user} ${wildfly.remote.password} admin --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
