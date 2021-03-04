FROM python:3.8

USER root:root

RUN apt-get update && apt-get upgrade -y --auto-remove
RUN apt-get install sysstat -y


RUN pip3 install --upgrade pip

RUN pip3 install tqdm \
    && pip3 install requests \
    && pip3 install numpy

RUN mkdir /usr/src/app
WORKDIR /usr/src/app

#RUN mkdir output.d

COPY scripts/* ./
COPY opts/* ./
#COPY compositions/* ./
#COPY openehr_ids_10k .

#COPY scripts/main.sh  . \
#    && scripts/post_opts.py . \
#    && scripts/post_ehr_ids.py . \
#    && scripts/post_compositions.py .
#    && scripts/check_ram.sh . \
#COPY scripts/check_ram.sh \
#    && scripts/check_cpu.sh . \
#    && scripts/openehr_ids_10k .


RUN chmod +x main.sh

# entrypoint allows for passing arguments to entrypoint like:
# "docker run <image> -d" will pass the "-d" to entrypoint
ENTRYPOINT ["/usr/src/app/main.sh"]
#CMD /bin/bash ./main.sh ### Error response from daemon: OCI runtime create failed: container_linux.go:370: starting container process caused: exec: "http://141.5.100.246/ehrbase/rest/openehr/v1/": stat http://141.5.100.246/ehrbase/rest/openehr/v1/: no such file or directory: unknown
# RUN /bin/bash -c "source /usr/src/app/main.sh" cannot pass arguments!

