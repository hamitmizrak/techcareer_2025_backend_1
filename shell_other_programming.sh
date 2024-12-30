#!/bin/bash
echo "Other Programming "

# User Variable
UPDATED="Güncelleme"
CLEANER="Temizleme"
INSTALL="Yükleme"
DELETED="Silme"
CHMOD="Erişim İzni"
INFORMATION="Genel Bilgiler Ports | NETWORKING"
UFW="Uncomplicated Firewall Ggüvenlik duvarı Yöentim Araçı"
LOGOUT="Sistemi Tekrar Başlatmak"
CHECK="Yüklenecek Paket bağımlılıkları"
PACKAGE="Paket Sistemde Yüklü mü"
JDK="JDK Kurmak"
JENKINS="Jenkins"
TOMCAT="Apache Tomcat"
POSTGRESQL="Postgresql"
SONARQUBE="SonarQube"
DOCKER_PULL="Docker Pulling"
LOGIN="Docker Login"
LOGOUT="Docker Logout"
PORTAINER="Docker Portainer"
DOCKERCOMPOSE="Docker Compose"

###################################################################
###################################################################
sudo chmod +x ./countdown.sh

# Updated
updated() {
    sleep 2
    echo -e "\n###### ${UPDATED} ######  "
    
    # Güncelleme Tercihi
    echo -e "Güncelleme İçin Seçim Yapınız\n1-)update\n2-)upgrade\n3-)dist-upgrade\n4-)Çıkış"
    read chooise

    # Girilen sayıya göre tercih
    case $chooise in
        1)
            read -p "Sistem Listesini Güncellemek İstiyor musunuz ? e/h " listUpdatedResult
            if [[ $listUpdatedResult == "e" || $listUpdatedResult == "E" ]]; then
                echo -e "List Güncelleme Başladı ..."
                # Geriye Say
                sudo ./countdown.sh

                sudo apt-get update
            else
                echo -e "Sistemin Listesini Güncellenemesi yapılmadı"
            fi
            ;; 
        2)
            read -p "Sistemin Paketini Yükseltmek İstiyor musunuz ? e/h " systemListUpdatedResult
            if [[ $systemListUpdatedResult == "e" || $systemListUpdatedResult == "E" ]]; then
                echo -e "Sistem Paket Güncellenmesi Başladı ..."
                # Geriye Say
                sudo ./countdown.sh

                sudo apt-get update && sudo apt-get upgrade -y
            else
                echo -e "Sistem Paket Güncellenmesi  yapılmadı..."
            fi
            ;; 
        3)
            read -p "Sistemin Çekirdeğini Güncellemek İstiyor musunuz ? e/h " kernelUpdatedResult
            if [[ $kernelUpdatedResult == "e" || $kernelUpdatedResult == "E" ]]; then
                echo -e "Kernel Güncelleme Başladı ..."
                # Geriye Say
                sudo ./countdown.sh

                sudo apt-get update && sudo apt-get upgrade -y && sudo apt-get dist-upgrade -y
                # Çekirdek(Kernel) güncellemelerinde yeniden başlamak gerekebilir
                sudo apt list --upgradable | grep linux-image
            else
                echo -e "Kernel Güncellemesi Yapılmadı..."
            fi
            ;;
        *)
            echo -e "Lütfen Sadece Size Belirtilen Seçeneği Seçiniz"
            ;;
    esac
}
updated

###################################################################
###################################################################
# logout
logout() {
    sleep 2
    echo -e "\n###### ${LOGOUT} ######  "
    read -p "Sistemi Kapatıp Tekrar Açmak ister misiniz ? e/h " logoutResult
    if [[ $logoutResult == "e" || $logoutResult == "E" ]]; then
        echo -e "Sitem Kapatılıyor ..."

        # Geri Sayım
        sudo ./countdown.sh

        # Update
        sudo apt update

        # Temizleme Fonkisyonunu çağırsın
        clean

        # Sistemi kapat ve ac
        ./reboot.sh
    else
        echo -e "Sistem Kapatılmadı"
    fi
}
# logout

###################################################################
###################################################################
# Paket Yüklendi mi
is_loading_package() {
    sleep 2
    echo -e "\n###### ${PACKAGE} ######  "
    read -p "Paketin Yüklendiğini Öğrenmek İster misiniz ? e/h " packageResult
    if [[ $packageResult == "e" || $packageResult == "E" ]]; then
        echo -e "Yüklenmiş paket bilgisini öğrenme ..."

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "Bulunduğum dizin => $(pwd)\n"
        sleep 1

        echo -e "######### Paket Bağımlılığı #########\n"
        read -p "Lütfen yüklenmiş paket adını giriniz examples: git: " user_input

        # dependency
        package_information "$user_input"
    else
        echo -e "Paket Yüklenme Bilgisi İstenmedi..."
    fi
}

package_information() {
    # parametre - arguman
    local packagename=$1

    # Belirli bir Komutun Yolu (Sistemde nerede olduğunu bulmak)
    which $packagename

    # İlgili Paketi bulma
    whereis $packagename

    # Paket Bilgilerini Görüntüleme
    apt-cache show $packagename

    # Paketin Yüklü olup olmadığını Kontrol Etmek
    dpkg-query -W -f='${Status} ${Package}\n' $packagename

    # Geri Sayım
    sudo ./countdown.sh

    # Yüklü Tüm paketleri Listele
    dpkg -l 

    # Geri Sayım
    sudo ./countdown.sh

    # Eğer paket isimleri uzunsa grep ile arama yap 
    dpkg -l | grep $packagename

    # Dosyalarını Listelemek İstersem
    dpkg -L $packagename

    ############
    # Yüklü Tüm Paketleri Listelemek
    apt list --installed

    # Belirli bir paketin yüklü olup olmadığını kontrol etmek
    apt list --installed | grep $packagename 
}

###################################################################
###################################################################
# Paket Bağımlıklarını Görme
check_package() {
    sleep 2
    echo -e "\n###### ${CHECK} ######  "
    read -p "Sistem İçin Genel Bağımlılık Paketini Yüklemek İstiyor musunuz ? e/h " checkResult
    if [[ $checkResult == "e" || $checkResult == "E" ]]; then
        echo -e "Yüklenecek Paket Bağımlılığı ..."

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "Bulunduğum dizin => $(pwd)\n"
        sleep 1

        echo -e "######### Paket Bağımlılığı #########\n"
        read -p "Lütfen yüklemek istediğiniz paket adını yazınız examples: nginx: " user_input

        # dependency
        dependency "$user_input"
    else
        echo -e "Bağımlılıklar kontrol edilmedi ..."
    fi
}

dependency() {
    # parametre - arguman
    local packagename=$1
    #
    sudo apt-get check
    sudo apt-cache depends $packagename
    sudo apt-get install $packagename
}

###################################################################
###################################################################
# Clean
# Install
clean() {
    sleep 2
    echo -e "\n###### ${CLEANER} ######  "
    read -p "Sistemde Gereksiz Paketleri Temizlemek İster misiniz ? e/h " cleanResult
    if [[ $cleanResult == "e" || $cleanResult == "E" ]]; then
        echo -e "Gereksiz Paket Temizliği Başladı ..."

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "######### nginx #########\n"
        sudo apt-get autoremove -y
        sudo apt autoclean
        echo -e "Kırık Bağımlılıkları Yükle ..."
        sudo apt install -f
    else
        echo -e "Güncelleme yapılmadı"
    fi
}
clean

###################################################################
###################################################################
# Git Packet Install
# Install
gitInstall() {
    # Güncelleme Fonksiyonu
    updated

    # Geri Sayım
    sudo ./countdown.sh

    echo -e "\n###### ${INSTALL} ######  "
    read -p "Git Paketini Yüklemek İstiyor musunuz ? e/h " gitInstallResult
    if [[ $gitInstallResult == "e" || $gitInstallResult == "E" ]]; then
        echo -e "Git Paket Yükleme Başladı ..."

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "Bulunduğum dizin => $(pwd)\n"
        sleep 1
        echo -e "######### Git #########\n"

        # Yükleme
        sudo apt-get install git -y 
        git version
        git config --global user.name "Hamit Mızrak"
        git config --global user.email "hamitmizrak@gmail.com"
        git config --global -l

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "######### Git Version #########\n"
        git --version

        # Clean Function
        clean

        # Yüklenen Paket Hakkında Bilgi Almak
        is_loading_package

         # Git Check Package dependency Fonksiyonunu çağır
        check_package
    else
        echo -e "Git Yüklenmesi yapılmadı...."
    fi
}
gitInstall

###################################################################
###################################################################
# VS CODE Packet Install
# Install
vsCodeInstall() {
     # Güncelleme Fonksiyonu
    updated

    # Geri Sayım
    sudo ./countdown.sh

    echo -e "\n###### ${INSTALL} ######  "
    read -p "VS Code Paketini Yüklemek İstiyor musunuz ? e/h " vscodeInstallResult
    if [[ $vscodeInstallResult == "e" || $vscodeInstallResult == "E" ]]; then
        echo -e "VS Code Paket Yükleme Başladı ..."

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "Bulunduğum dizin => $(pwd)\n"
        sleep 1
        echo -e "######### VS CODE #########\n"

        # Yükleme
        sudo snap install code --classic
        sleep 1

        # Dizin oluştur
        sudo mkdir frontend
        cd frontend
        code .

        # Clean Function
        clean

        # Yüklenen Paket Hakkında Bilgi Almak
        is_loading_package

        # VSCODE Check Package dependency Fonksiyonunu çağır
        check_package
    else
        echo -e "VSCode Yüklenmesi Yapılmadı...."
    fi
}
vsCodeInstall

###################################################################
###################################################################
# JAVA JDK Packet Install
# JDK 11 : Jenkins, SonarQube(11 veya 17),  Apache Tomcat 10 (+Java 8)
# Install
jdkInstall() {
     # Güncelleme Fonksiyonu
    updated

    # Geri Sayım
    sudo ./countdown.sh

    echo -e "\n###### ${JDK} ######  "
    read -p "JDK Paketini Yüklemek İstiyor musunuz ? e/h " jdkInstallResult
    if [[ $jdkInstallResult == "e" || $jdkInstallResult == "E" ]]; then
        echo -e "JDK Paket Yükleme Başladı ..."

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "Bulunduğum dizin => $(pwd)\n"
        sleep 1
        echo -e "######### JDK #########\n"

        # Yükleme
        sudo apt-get install openjdk-11-jdk -y
        sudo add-apt-repository ppa:openjdk-r/ppa -y 
        echo -e "#Java Home\nJAVA_HOME=\"/usr/lib/jvm/java-11-openjdk-amd64/bin/\" " >> ~/.bashrc

        #sudo update-alternative --config java

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "######### Git Version #########\n"
        which git
        which java 
        java --version
        javac --version

        # Clean Function
        clean

        # Yüklenen Paket Hakkında Bilgi Almak
        is_loading_package

        #  Check Package dependency Fonksiyonunu çağır
        check_package
    else
        echo -e "JDK Yüklenmesi Yapılmadı...."
    fi
}
jdkInstall

###################################################################
###################################################################
# MAVEN Packet Install
# Install
mavenInstall() {
     # Güncelleme Fonksiyonu
    updated

    # Geri Sayım
    sudo ./countdown.sh

    echo -e "\n###### ${INSTALL} ######  "
    read -p "MAVEN Paketini Yüklemek İstiyor musunuz ? e/h " mavenInstallResult
    if [[ $mavenInstallResult == "e" || $mavenInstallResult == "E" ]]; then
        echo -e "MAVEN Paket Yükleme Başladı ..."

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "Bulunduğum dizin => $(pwd)\n"
        sleep 1
        echo -e "######### MAVEN #########\n"

        # Yükleme
        java --version 
        javac --version
        #sudo update-alternative --config java

        # Geri Sayım
        sudo ./countdown.sh

        # Maven Yükle
        sudo apt install maven 
        
         # Geri Sayım
        sudo ./countdown.sh

        echo -e "######### Version #########\n"
        which git
        which java
        which maven
        git --version
        java --version
        javac --version
        mvn --version

        # Clean Function
        clean

        # Yüklenen Paket Hakkında Bilgi Almak
        is_loading_package

        # VSCODE Check Package dependency Fonksiyonunu çağır
        check_package
    else
        echo -e "Maven Yüklenmesi Yapılmadı...."
    fi
}
mavenInstall

###################################################################
###################################################################
# JENKINS Packet Install
# http://localhost:3333
# Jenkins Delete
jenkinsDelete() {
     # Güncelleme Fonksiyonu
    updated

    # Geri Sayım
    sudo ./countdown.sh

    echo -e "\n###### ${JENKINS} Delete ######  "
    read -p "Jenkins Paketini Silmek İstiyor musunuz ? e/h " jenkinsDeleteResult
    if [[ $jenkinsDeleteResult == "e" || $jenkinsDeleteResult == "E" ]]; then
        echo -e "Jenkins Paket Yükleme Başladı ..."

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "Bulunduğum dizin => $(pwd)\n"
        sleep 1
        echo -e "######### JENKINS DELETE #########\n"

        # Yükleme
        java --version 
        javac --version
        mvn -v
        #sudo update-alternative --config java

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "######### JENKINS DELETE #########\n"
        sudo service jenkins stop
        sudo apt-get remove --purge jenkins
        sudo apt-get remove jenkins
        sudo apt-get remove --auto-remove jenkins -y

        # Clean Function
        clean

        # Yüklenen Paket Hakkında Bilgi Almak
        is_loading_package

        # VSCODE Check Package dependency Fonksiyonunu çağır
        check_package
    else
        echo -e "Jenkins Silme İşlemi Yapılmadı...."
    fi
}

# Jenkins Install
jenkinsInstall() {
     # Güncelleme Fonksiyonu
    updated

    # Geri Sayım
    sudo ./countdown.sh

    echo -e "\n###### ${JENKINS} Kurmak ######  "
    read -p "Jenkins Paketini Yüklemek İstiyor musunuz ? e/h " jenkinsInstallResult
    if [[ $jenkinsInstallResult == "e" || $jenkinsInstallResult == "E" ]]; then
        echo -e "Jenkins Paket Yükleme Başladı ..."

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "Bulunduğum dizin => $(pwd)\n"
        sleep 1
        echo -e "######### JENKINS #########\n"

        # Yükleme
        java --version 
        javac --version
        mvn -v
        #sudo update-alternative --config java

        # Geri Sayım
        sudo ./countdown.sh

        sudo ufw allow 3333

        # Jenkins Yükle
        # sudo su -
        sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
        https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
        echo "deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc]" \
        https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
        /etc/apt/sources.list.d/jenkins.list > /dev/null
        
        sudo apt-get update
        # Geri Sayım
        sudo ./countdown.sh

        echo -e "Jenkins Kuruluyor"
        sudo apt-get install jenkins -y

        # Jenkins'in varsayılan yapılandırma dosyasını düzenleyerek portu 9090 olarak değiştirin
        sudo sed -i 's/Environment="JENKINS_PORT=8080"/Environment="JENKINS_PORT=3333"/' /usr/lib/systemd/system/jenkins.service
        systemctl daemon-reload

        # Jenkins'in otomatik olarak başlamasını etkinleştirin
        sudo systemctl enable jenkins
        # Jenkins Start
        sudo systemctl start jenkins
        # Jenkins Restart
        sudo systemctl restart jenkins

        # Jnekins Stop
        # sudo systemctl stop jenkins

        # Jenkins Durumu
        sudo systemctl status Jenkins

         # Geri Sayım
        sudo ./countdown.sh

        # Jenkins Şifre Al
        sudo cat /var/lib/jenkins/secrets/initialAdminPassword 

        echo -e "######### Version #########\n"
        which git
        which java
        which maven
        git --version
        java --version
        javac --version
        mvn --version

        # Clean Function
        clean

        # Yüklenen Paket Hakkında Bilgi Almak
        is_loading_package

        # VSCODE Check Package dependency Fonksiyonunu çağır
        check_package
    else
        echo -e "Jenkins Yüklenmesi Yapılmadı...."
    fi
}
jenkinsInstall

# Jenkins Delete
jenkinsDelete

###################################################################
###################################################################
# Apache Tomcat Packet Install
# http://localhost:4444
# Tomcat Delete
apacheTomcatDelete() {
     # Güncelleme Fonksiyonu
    updated

    # Geri Sayım
    sudo ./countdown.sh

    echo -e "\n###### ${TOMCAT} ######  "
    read -p "APACHE TOMCAT Paketini Silmek İstiyor musunuz ? e/h " apacheTomcatDeleteResult
    if [[ $apacheTomcatDeleteResult == "e" || $apacheTomcatDeleteResult == "E" ]]; then
        echo -e "APACHE TOMCAT Paket Silme Yükleme Başladı ..."

        # Yükleme
        java --version 
        javac --version
        mvn --version

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "Bulunduğum dizin => $(pwd)\n"
        sleep 1
        echo -e "######### APACHE TOMCAT #########\n"
        sudo rm -rf /opt/tomcat
    
        # Eğer Açılmazsa
        # sudo /opt/tomcat/bin/startup.sh

         # Geri Sayım
        sudo ./countdown.sh
        
        # Clean Function
        clean

        # Yüklenen Paket Hakkında Bilgi Almak
        is_loading_package

        # VSCODE Check Package dependency Fonksiyonunu çağır
        check_package
    else
        echo -e "Apache Tomcat Silme Yapılmadı...."
    fi
}

# Tomcat Install
apacheTomcatInstall() {
     # Güncelleme Fonksiyonu
    updated

    # Geri Sayım
    sudo ./countdown.sh

    echo -e "\n###### ${TOMCAT} ######  "
    read -p "APACHE TOMCAT Paketini Yüklemek İstiyor musunuz ? e/h " apacheTomcatInstallResult
    if [[ $apacheTomcatInstallResult == "e" || $apacheTomcatInstallResult == "E" ]]; then
        echo -e "APACHE TOMCAT Paket Yükleme Başladı ..."

        # Yükleme
        java --version 
        javac --version
        mvn --version

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "Bulunduğum dizin => $(pwd)\n"
        sleep 1
        echo -e "######### APACHE TOMCAT #########\n"

        #sudo update-alternative --config java

        # Geri Sayım
        sudo ./countdown.sh

        # Apache Tomcat Yükle
        # Tomcat 10 için En az JDK 11 kurmalısınız
        sudo wget  https://archive.apache.org/dist/tomcat/tomcat-10/v10.0.8/bin/apache-tomcat-10.0.8.tar.gz
        sudo tar xzvf apache-tomcat-10.0.8.tar.gz
        sudo mkdir /opt/tomcat/
        sudo mv apache-tomcat-10.0.8/* /opt/tomcat/
        sudo chown -R www-data:www-data /opt/tomcat/

        # İzinleri Sembolik Mod olarak değiştirmek
        #sudo chmod -R u+rwx,g+rx,o+rx /opt/tomcat/
        sudo chmod -R 755 /opt/tomcat/
        
         # Geri Sayım
        sudo ./countdown.sh

        # Değişkenler
        TOMCAT_PORT=4444
        INSTALL_DIR=/opt/tomcat
        # 8080 => 
        sudo sed -i "s/port=\"8080\"/port=\"$TOMCAT_PORT\"/" $INSTALL_DIR/conf/server.xml

        sudo ./opt/tomcat/bin/startup.sh

        # Tomcat Servisini eğer install ile yüklerseniz aşağıdaki komutları aktifleştirin Başlatma Ve Etkinleştirme
        #sudo systemctl daemon-reload
        #sudo systemctl start tomcat

        # Test 
        sudo curl http://localhost:4444

        # Restart
        #sudo systemctl restart tomcat

        # Tomcat Servisinin Otomatik Olarak Başlamasını Sağlıyordu.
        #sudo sytemctl enable tomcat

        # Tomcat Version
        #sudo /opt/tomcat/bin/catalina.sh version 

        # Eğer Açılmazsa
        # sudo /opt/tomcat/bin/startup.sh

         # Geri Sayım
        sudo ./countdown.sh
        
        echo -e "######### Version #########\n"
        which git
        which java
        which maven
        git --version
        java --version
        javac --version
        mvn --version

        # Clean Function
        clean

        # Yüklenen Paket Hakkında Bilgi Almak
        is_loading_package

        # VSCODE Check Package dependency Fonksiyonunu çağır
        check_package
    else
        echo -e "Apache Tomcat Yüklemesi Yapılmadı...."
    fi
}
apacheTomcatInstall

# Tomcat Silmek
apacheTomcatDelete

###################################################################
###################################################################
# Docker Compose
dockerCompose(){
    echo -e "\n### ${DOCKERCOMPOSE} ###"
    read -p "\nDocker Compose Eklemek İstiyor musunuz ? E/H? " dockerComposeResult
    if [[ $dockerComposeResult == "E" || $dockerComposeResult == "e"  ]]
    then
        echo -e "Docker Compose Ekleniyor ... " 
         # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Tek bir satırda kurmak için aşağıdaki kodu kullanabilirsiniz: sudo curl -Ssl https://get.docker.com | bash - \n "  

        # Docker Kurulumunu Tek satırda çalıştırmak
        #sudo curl -Ssl https://get.docker.com | bash -

         # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker-compose Kurulumu Başladı "  

        # Docker Compose Kurulumu
        sudo apt-get install docker-compose -y

        docker-compose -v
      
    else
        echo -e "Docker Compose Ekleme Yapılmadı!!!\n "   
    fi
}

# Docker Portainer
dockerPortainer(){
    # Geri Sayım
    sudo ./countdown.sh

    echo -e "\n### ${PORTAINER} ###"
    read -p "\nDockerHub'a Çıkış yapmak istiyor musunuz ? E/H? " portainerResult
    if [[ $portainerResult == "E" || $portainerResult == "e"  ]]
    then
        echo -e "Docker Portainer ... "  
         # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Portainer Kurulum Başladı " 
        ##### Aşağıdaki kodları yaz ##########################################
        sudo curl -L https://github.com/docker/compose/releases/download/1.21.2/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose

        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Portainer CHMOD " 
        ##### CHMOD ##########################################
        sudo chmod +x /usr/local/bin/docker-compose
        sudo docker volume create portainer_data

        ##### PORT##########################################
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Portainer Port "
        sudo docker run -d -p 2222:9000 -p 8000:8000 --name portainer --restart always -v /var/run/docker.sock:/var/run/docker.sock -v /srv/portainer:/data portainer/portainer
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Portainer Start "
        sudo docker start portainer
        #sudo docker stop portainer

        ##### CHMOD ##########################################
        sudo ifconfig
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Portainer http:localhost:2222"
        sudo curl localhost:2222 

        # username:root
        # password:rootroot

    else
        echo -e "Docker Portainer Ekleme Yapılmadı!!!\n "   
    fi
}

# Docker Pulling
dockerPulling() {

    echo -e "\n### ${DOCKER_PULL} ###"
    read -p "\nDockerHub'a Pull  yapmak istiyor musunuz ? E/H? " updatedResult
    if [[ $updatedResult == "E" || $updatedResult == "e"  ]]
    then
        echo -e "Docker Pulling ... " 
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Pulling nginx" 
        sudo docker pull nginx
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Pulling nodejs"
        sudo docker pull node # nodejs
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Pulling Httpd" 
        sudo docker pull httpd # apache
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Pulling tomcat:9.0.8-jre8-alpine" 
        docker pull tomcat:9.0.8-jre8-alpine
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Pulling mysql" 
        sudo docker pull mysql
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Pulling postgres" 
        sudo docker pull postgres
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Pulling mongo"
        sudo docker pull mongo # nosql
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Pulling redis"
        sudo docker pull redis
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Pulling ubuntu"
        sudo docker pull ubuntu
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Pulling alpine"
        sudo docker pull alpine
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Pulling centos"
        sudo docker pull centos
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Pulling python"
        sudo docker pull python:3.8
        docker images
    else
        echo -e "apt-get Update List Güncelleme Yapılmadı!!!\n "   
    fi
}

# dockerHubLogin
dockerHubLogin() {
    echo -e "\n### ${LOGIN} ###"
    read -p "\nDockerHub'a Giriş yapmak istiyor musunuz ? E/H? " updatedResult
    if [[ $updatedResult == "E" || $updatedResult == "e"  ]]
    then
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Login ... "  
        sudo docker login
    else
        echo -e "Docker Login Yapılmadı!!!\n "   
    fi
}

# dockerHubLogout
dockerHubLogout() {
    echo -e "\n### ${LOGOUT} ###"
    read -p "\nDockerHub'a Çıkış yapmak istiyor musunuz ? E/H? " updatedResult
    if [[ $updatedResult == "E" || $updatedResult == "e"  ]]
    then
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "Docker Login ... "  
        sudo docker logout
    else
        echo -e "Docker Logout Yapılmadı!!!\n "   
    fi
}

# Docker Packet Install
# Install
dockerInstall() {
     # Güncelleme Fonksiyonu
    updated

    # Geri Sayım
    sudo ./countdown.sh

    echo -e "\n###### ${INSTALL} ######  "
    read -p "Docker Paketini Yüklemek İstiyor musunuz ? e/h " dockerInstallResult
    if [[ $dockerInstallResult == "e" || $dockerInstallResult == "E" ]]; then
        echo -e "Docker Paket Yükleme Başladı ... "

        # Yükleme
        git --version 
        #sudo update-alternative --config java
        java --version 
        javac --version
        mvn --version

        # Geri Sayım
        sudo ./countdown.sh

        echo -e "Bulunduğum dizin => $(pwd)\n"
        sleep 1
        echo -e "######### Docker Sürümünü Eğer Varsa Öncelikle Sil #########\n"
        # Docker Kurulumu
        # Eğer önceden Docker varsa sil
        sudo apt-get purge docker-ce docker-ce-cli containerd.io -y
        sudo rm -rf /var/lib/docker
        sudo rm -rf /var/lib/containerd
        sudo apt-get clean
        sudo apt-get autoremove -y
        sudo apt-get update
        sudo apt-get remove docker docker-engine docker.io containerd runc
        sudo apt-get update
        sudo apt-get upgrade

        # Geri Sayım
        sudo ./countdown.sh
        echo -e "######### Docker Https Üzerinden Depo İznini Ver#########\n"
         ### HTTPS üzerinden bir depo kullanmasına izin vermek için##################################
        sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common -y

        # Geri Sayım
        sudo ./countdown.sh
        echo -e "######### Docker Resmi GPG Anahtarını Ekle #########\n"
        ### Docker’ın resmi GPG anahtarını ekleyiniz. curl aracı ile GPG anahtarını komut içerisine aktarınız
        sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
        sudo apt-key fingerprint 0EBFCD88

        # Geri Sayım
        sudo ./countdown.sh
        echo -e "######### Docker Curl Araçını Docker Apt Deposuna Ekle #########\n"
        ### curl aracı ile Docker apt deposunu eklemek
        sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

        ###############DOCKER KURULUMU##########################################
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "######### Docker Kurulumuna Başla #########\n"
        sudo apt-get update
        sudo apt-get install docker-ce docker-ce-cli containerd.io -y

        # sudo systemctl status docker
        # sleep 2
        # q
        # Geri Sayım
        sudo ./countdown.sh
        echo -e "######### Docker Enable/Start #########\n"
        sudo systemctl enable --now docker 
        sudo systemctl start docker
        # sudo systemctl status docker

        # Geri Sayım
        sudo ./countdown.sh
        echo -e "######### Docker User Mod Ekle #########\n"
        ### kullanıcı adınızı docker grubuna ekle
        sudo usermod -aG docker ${USER}
        su - ${USER}
        sudo  id -NG
        sudo apt-get install bash-completion 
        docker version

        # Docker Image Oluştursun
        docker run hello-world

        # Docker Compose 
        dockerCompose

        # Docker Linux Ubuntu Portainer
        dockerPortainer
        
         # Geri Sayım
        sudo ./countdown.sh

        # Docker Pulling
        dockerPulling

        # Apache Tomcat 
        docker run -d --name my_tomcat1 -p  1111:8080 tomcat:9.0.8-jre8-alpine
        docker ps 
        # docker container exec -it my_tomcat1 bash

        # DockerHub Login 
        dockerHubLogin

        # DockerHub Logout 
        dockerHubLogout

        # Version
        echo -e "######### Version #########\n"
        which git
        which java
        which maven
        git --version
        java --version
        javac --version
        mvn --version

        # Clean Function
        clean

        # Yüklenen Paket Hakkında Bilgi Almak
        is_loading_package

        # VSCODE Check Package dependency Fonksiyonunu çağır
        check_package
    else
        echo -e "Docker Kurulumu Yapılmadı...."
    fi
}
dockerInstall


###################################################################
###################################################################
# Postgresql Packet Install
postgresql(){
   
    echo -e "\n### ${POSTGRESQL} Kurulumu ###"
    read -p "\nPostgresql Eklemek İstiyor musunuz ? E/H? " postgresqlResult
    if [[ $postgresqlResult == "E" || $postgresqlResult == "e"  ]]
    then
        echo -e "Postgresql Ekleniyor ... " 
         # Geri Sayım
        sudo ./countdown.sh
        sudo ufw allow 5432

        sleep 2
        # sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'
        echo -e "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main " | sudo tee --append /etc/apt/sources.list.d/pgdg.list
        sudo wget -q https://www.postgresql.org/media/keys/ACCC4CF8.asc -O - | sudo apt-key add -
        sudo apt-get -y install postgresql postgresql-contrib

        sleep 2
        echo -e "######Postgresql Enable"
        sudo systemctl enable postgresql

        sleep 2
        echo -e "Postgresql Start"
        sudo systemctl start postgresql

        # PostgreSQL için kullanılacak yeni parola
        NEW_PASSWORD="sonarqube"
        # PostgreSQL kullanıcısının parolasını değiştirme
        sudo -u postgres psql -c "ALTER USER postgres WITH PASSWORD '$NEW_PASSWORD';"

        # Parolanın değiştirildiğini doğrulama
        RESULT=$(sudo -u postgres psql -tAc "SELECT 1 FROM pg_roles WHERE rolname='postgres' AND rolpassword IS NOT NULL;")

        if [ "$RESULT" == "1" ]; then
            echo "PostgreSQL kullanıcısının parolası başarıyla değiştirildi."
        else
            echo "PostgreSQL kullanıcısının parolası değiştirilemedi."
        fi

        su - postgres
        createuser sonar
        psql
        ALTER USER sonar WITH ENCRYPTED password 'sonar';
        CREATE DATABASE sonarqube OWNER sonar;
        grant all privileges on DATABASE sonarqube to sonar;
        \q
        exit

        sleep 2
        echo -e "5432 PORT"
        sudo netstat -ntlp | grep 5432
        sudo netstat -nlptu
        
        # Geri Sayım
        sudo ./countdown.sh
      
    else
        echo -e "Postgresql Kurulumu Yapılmadı!!!\n "   
    fi
}
postgresql

###################################################################
###################################################################
# Psotgresql Packet Install
sonarqube(){
   
    echo -e "\n### ${SONARQUBE} Kurulumu ###"
    read -p "\nSonarQube İstiyor musunuz ? E/H? " sonarqubeResult
    if [[ $sonarqubeResult == "E" || $sonarqubeResult == "e"  ]]
    then
        echo -e "SonarQube Ekleniyor ... " 
         # Geri Sayım
        sudo ./countdown.sh
      
    else
        echo -e "SonarQube Kurulumu Yapılmadı!!!\n "   
    fi
}
sonarqube

###################################################################
###################################################################
# Information
information() {
    sleep 2
    echo -e "\n###### ${INFORMATION} ######  "
    read -p "Genel Bilgileri Görmek ister misiniz ? e/h " informationResult
    if [[ $informationResult == "e" || $informationResult == "E" ]]; then
        echo -e "Genel Bilgiler Verilmeye Başlandı ..."

        # Geri Sayım
        sudo ./countdown.sh
        #sudo su
        echo -e "Ben Kimim => $(whoami)\n"
        sleep 1
        echo -e "Ağ Bilgisi => $(ifconfig)\n"
        sleep 1
        echo -e "Port Bilgileri => $(netstat -nlptu)\n"
        sleep 1
        echo -e "Linux Bilgileri => $(uname -a)\n"
        sleep 1
        echo -e "Dağıtım Bilgileri => $(lsb_release -a)\n"
        sleep 1
        echo -e "Hardisk Bilgileri => $(df -m)\n"
        sleep 1
        echo -e "CPU Bilgileri => $(cat /proc/cpuinfo)\n"
        sleep 1
        echo -e "RAM Bilgileri => $(free -m)\n"
        sleep 1
    else
        echo -e "Dosya izinleri yapılmadı"
    fi
}
information

###################################################################
###################################################################
# Port And Version
portVersion() {
    node -v
    zip -v
    unzip -v+
    # build-essential:
    gcc --version # gcc: GNU C compiler derlemek
    g++ --version # g++: GNU C++ compiler derlemek
    make --version # make: Makefile kullanarak derlemek içindir
    git --version
    java --version
    javac --version
    mvn --version
    
     # docker Version
    docker-compose -v

    # Tomcat Version
    /opt/tomcat/bin/catalina.sh version 

}
portVersion
