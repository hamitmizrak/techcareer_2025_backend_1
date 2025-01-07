# JDK Image Create
FROM openjdk:17

# ARG JAR_FILE
ARG JAR_FILE=/target/*.jar

# yukarıdaki Değişen ismi yani .jar isimdekini kullanmak
ADD ${JAR_FILE} blog.jar

# Çalışma Ortamı
ENTRYPOINT ["java","-jar","/blog.jar"]