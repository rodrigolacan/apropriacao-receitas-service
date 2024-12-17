FROM harbor.rr.sebrae.com.br/wildfly/wildfly:v1.0.18

COPY target/ROOT.war /opt/wildfly/standalone/deployments/
COPY keycloak-cert.pem /etc/ssl/certs

# Importa o certificado e remove o arquivo após o uso
ARG STORE_PASS=changeit
RUN keytool -import -trustcacerts -keystore $JAVA_HOME/lib/security/cacerts \
    -storepass $STORE_PASS -noprompt -alias keycloak-cert \
    -file /etc/ssl/certs/keycloak-cert.pem && \
    rm -f /etc/ssl/certs/keycloak-cert.pem