FROM java:8
ENV ARTIFACTID cms
ENV ARTIFACTVERSION 0.0.6-SNAPSHOT
ENV HOME_PATH /root
WORKDIR $HOME_PATH
ADD /$ARTIFACTID-$ARTIFACTVERSION.jar $HOME_PATH/$ARTIFACTID.jar
ENTRYPOINT ["java", "-jar", "cms.jar"]
