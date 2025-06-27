# Apache Cassandra User Activity Log System

**How to run the project:**

    mvn clean install
    
    mvn spring-boot:run

If you want to debug use the next line instead and attach a debugger using a Remote JVM Debug configuration

    mvn spring-boot:run "-Dspring-boot.run.jvmArguments=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"

**Requirements**

    Java 17
    
    Maven 3.8.1

# Apache cassandra docker

Steps to run apache cassandra on docker (it takes some minutes to cassandra server to start up):

    docker pull cassandra:5.0.4

    docker network create cassandra

    docker run --rm -d --name cassandra --hostname cassandra --network cassandra cassandra:5.0.4

Command to load cql file

    docker run --rm --network cassandra -v "$(pwd)/src/main/resources/scripts/data.cql:/scripts/data.cql" -e CQLSH_HOST=cassandra -e CQLSH_PORT=9042 -e CQLVERSION=3.4.7 nuvo/docker-cqlsh

Command to connect csqlh:

    docker run --rm -it --network cassandra nuvo/docker-cqlsh cqlsh cassandra 9042 --cqlversion='3.4.7'

Alternative commands

    docker run -p 9042:9042 --rm --name cassandra -d cassandra:5.0.4
    docker run --rm --network cassandra -v "$(pwd)/src/main/resources/scripts/data.cql:/scripts/data.cql" -e CQLSH_HOST=cassandra -e CQLSH_PORT=9042 -e CQLVERSION=3.4.7 nuvo/docker-cqlsh
    docker exec -it cassandra bash -c "cqlsh -u cassandra -p cassandra"

# Clean Up
    docker kill cassandra
    docker network rm cassandra