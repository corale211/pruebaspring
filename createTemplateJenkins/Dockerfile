FROM ubuntu:16.04
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    apt-get install -y ant && \
    apt-get clean
RUN apt-get install -y sed
RUN apt-get update && apt-get install -y \
curl
RUN useradd -ms /bin/bash kali
VOLUME [/home/kali]
WORKDIR /home/kali
RUN ["chmod","777","/home/kali","-R"]
USER kali
COPY sh/motores_android /home/kali
COPY sh/app_android /home/kali
COPY sh/libs_android /home/kali
COPY target/createTemplateJenkins-0.0.1.jar /home/kali
CMD /bin/bash
CMD ["java", "-jar", "/home/kali/createTemplateJenkins-0.0.1.jar"]

