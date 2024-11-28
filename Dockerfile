FROM eclipse-temurin:21

WORKDIR /app

COPY *.jar /app/

CMD ["java","-cp","/app/runelab-bot-1.0-SNAPSHOT-all.jar", "io.runelab.MainKt"]