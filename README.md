# Spring Boot Kakfa Example

Example using spring boot, and kafka

## Getting Started

* build using mvn clean install -U
* start up local kafka
* setup kafka topic
    * $ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic reckless
* run application

### Prerequisites

* java 8
* kafka
* maven