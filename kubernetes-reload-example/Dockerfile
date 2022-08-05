FROM openjdk:17.0.2-oracle

ENV JAVA_OPTS="-Xms256m -Xmx256m"

ADD ./target/kubernetes-reload-example-0.0.1-SNAPSHOT.jar /app.jar
RUN mkdir /var/log/zaihui

#RUN bash -c 'touch /boss-app.jar'
EXPOSE 8080
ENTRYPOINT exec java ${JAVA_OPTS} \
                -jar /app.jar