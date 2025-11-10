FROM ubuntu:latest
LABEL authors="alexmaia"

ENTRYPOINT ["top", "-b"]

# diretorio de trabalho dentro do container
WORKDIR /app

COPY ./app/target/challenge-oracle-java-1.0-SNAPSHOT.jar /app/app.jar

RUN useradd -m appuser
USER appuser

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
