FROM java:8
VOLUME /tmp
ADD target/springcloud-provider-0.0.1-SNAPSHOT.jar springcloud-provider.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springcloud-provider.jar"]