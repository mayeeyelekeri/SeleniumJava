FROM maven:latest 

ADD . /usr/local 
WORKDIR /usr/local
CMD ["mvn", "test"]

