# Use uma imagem base do OpenJDK para o Java 17
FROM openjdk:17-jdk-alpine

# Copie o arquivo JAR executável do seu aplicativo para o contêiner
COPY target/sistema-0.0.1-SNAPSHOT.jar /app/sistema.jar

# Defina o diretório de trabalho como /app
WORKDIR /app

# Exponha a porta 8080 para fora do contêiner (se necessário)
EXPOSE 8080

# Comando para iniciar o aplicativo Spring Boot quando o contêiner for iniciado
CMD ["java", "-jar", "sistema.jar"]
