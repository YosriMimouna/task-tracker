# Task Tracker

[![Build Status](https://www.travis-ci.com/YosriMimouna/task-tracker.svg?branch=main)](https://www.travis-ci.com/YosriMimouna/task-tracker)

TaskTracker is a Java API Allowing:
* Create LocalTask Objects and storing each created task on Mongodb Atlas.
* Interact with Smart-Contract deployed on Goerli to trigger newTask() or call takCount() methods.

## Tech

- Java 11 / Gradle
- Spring Boot 2.4.5
- Docker
- Mongodb Atlas
- Web3j

## Build

Simple Gradle Build
```sh
./gradlew build
```

## Run

Simple Gradle Build
```sh
java -jar ./build/libs/task-tracker-0.0.1-SNAPSHOT.jar
```

## Docker

By default, the Docker will expose port 8080, so change this within the Dockerfile if necessary. When ready, simply use the Dockerfile to build the image.

```sh
cd task-tracker
docker build -f Dockerfile -t yosri96/task-tracker .
```

Or pull latest deployed version from DockerHub

```sh
docker pull yosri96/task-tracker
```

Once done, run the Docker image and map the port to whatever you wish on your host.

```sh
docker run -p 8080:8080 yosri96/task-tracker
```
