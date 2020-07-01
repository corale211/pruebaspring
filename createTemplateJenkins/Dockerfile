FROM ubuntu:16.04
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    apt-get install -y ant && \
    apt-get clean
RUN mkdir /home/kali
RUN apt-get update && apt-get install -y \
curl
CMD /bin/bash
COPY sh/motores_android /home/kali
COPY target/createTemplateJenkins-0.0.1.jar /home/kali
WORKDIR /home/kali
EXPOSE 8080
CMD ["java", "-jar", "/home/kali/createTemplateJenkins-0.0.1.jar"]
