FROM harbor.rr.sebrae.com.br/wildfly/wildfly:v1.0.18

COPY target/ROOT.war /opt/wildfly/standalone/deployments/