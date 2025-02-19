Run kafka and zookeeper with

```bash
    docker-compose up -d
```

Once Kafka is running create topic named *bank_transactions*

```bash
    docker exec -it kafka kafka-topics --create --topic bank_transactions --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
```

Verify that the topic is created

```bash
    docker exec -it kafka kafka-topics --list --bootstrap-server localhost:9092
```

run spring boot app
```bash
    mvn spring-boot:run -pl api-service
```

PLAY with API

Consume messages to see them in kafka:

```bash
    docker exec -it kafka kafka-console-consumer --topic bank_transactions --from-beginning --bootstrap-server localhost:9092
```

stop kafka and clean up

```bash
    docker-compose down
```