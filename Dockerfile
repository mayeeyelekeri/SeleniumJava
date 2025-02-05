FROM mymavenwithchrome:latest 


# Install chrome 
#RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb 
#RUN dpkg -i google-chrome-stable_current_amd64.deb 
#RUN apt --fix-broken install -y 

#RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb 
#RUN apt update -y 
#RUN apt -f install ./google-chrome-stable_current_amd64.deb 

#RUN google-chrome-stable --version 

ADD . /usr/local 
WORKDIR /usr/local
CMD ["mvn", "test"]

