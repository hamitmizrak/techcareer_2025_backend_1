#!/bin/bash

# User Variable
REDIS_CONTAINER="Redis Container"
REDIS_SERVER="Redis Server"
SPRING="Spring Boot Server"

###################################################################
###################################################################
# Redis Container Packet Install
redis_run(){

    echo -e "\n### ${REDIS_CONTAINER} Kurulumu ###"
    read -p "\nRedis Container ? E/H? " spring_serverResult
    if [[ $spring_serverResult == "E" || $spring_serverResult == "e"  ]]
    then
        echo -e "Docker Redis Ekleniyor ... "
         # Geri Sayım
        docker -v
        docker info
        docker --version

        ls -al

        # Geri Sayım
        ./shell_countdown.sh

        docker search redis
        #docker pull redis
        #docker pull redis:1.2.1
        #docker pull redis:latest

        # Projemizin sağlıklı çalışması için öncelikler redis servera kurulu olması gerekiyor
        docker container run -d -p 6379:6379 --name spring_redis redis
        #docker container run --rm -d -p 6379:6379 --name spring_redis redis
        #docker container run --rm --detach --public 6379:6379 --name spring_redis redis

        # Geri Sayım
        ./shell_countdown.sh
        docker ps

        # Geri Sayım
        ./shell_countdown.sh
        docker image ls
        #docker container ls
        #docker container ls -al

    else
        echo -e "Docker Redis Kurulumu Yapılmadı!!!\n "
    fi
}
redis_run


###################################################################
###################################################################
# Psotgresql Packet Install
redis_server(){

    echo -e "\n### ${REDIS_SERVER} Çalışması ###"
    read -p "\nRedis Server Test Etmek İstiyor musunuz ? E/H? " spring_serverResult
    if [[ $spring_serverResult == "E" || $spring_serverResult == "e"  ]]
    then
        echo -e "Redis Server  Ekleniyor ... "
         # Geri Sayım
         ./shell_countdown.sh

        # Redis Servera bağlanmak için
        # 1.YOL: Docker Desktop => Container => Terminal
        # 2.YOL: Terminal       => winpty docker exec -it spring_redis bash

        # Redis sunucusunun çalıştığından emin olun.
        # Terminalden veya komut istemcisinden aşağıdaki komutları kullanabilirsiniz:
        # Eğer Redis düzgün çalışıyorsa PONG yanıtı alırsınız.
        # Eğer bir bağlantı hatası varsa Redis'in çalıştığından emin olun ve Redis sunucusunu başlatın:
        # redis-server

        winpty docker exec -it spring_redis bash
        # docker exec -it spring_redis bash
        # docker exec -it spring_redis bash & redis-cli ping
        # docker exec -it spring_redis redis-cli

        # $ redis-cli ping     NOT: Eğer bu ping sonucu PONG geliyorsa redis server çalışıyor demektir.
        # $ redis-cli FLUSHALL
        # $ redis-cli FLUSHDB
        # $ redis-cli DEL id   nOT: id: cache id bileşenidir.

        # bu komutu Terminale bağlandıktan sonra ping gönderirilir eğer çalışıyorsa pıng döner
        #redis-cli ping

    else
        echo -e "Redis Server ping/pong Kurulumu Yapılmadı!!!\n "
    fi
}
redis_server

###################################################################
###################################################################
# Spring Boot Run
spring_run(){

    echo -e "\n### ${SPRING} Ayağa Kalkmak ###"
    read -p "\nSpring Ayağa kaldırmak İstiyor musunuz ? E/H? " spring_serverResult
    if [[ $spring_serverResult == "E" || $spring_serverResult == "e"  ]]
    then
        echo -e "Spring Server Ayağa Kalkıyor ... "
        # Geri Sayım
        ./shell_countdown.sh
        # Spring Boot projesini çalıştır.
        mvn spring-boot:run &

    else
        echo -e "Spring Ayağa Kurulumu Yapılmadı!!!\n "
    fi
}
spring_run







