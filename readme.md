# A very simple program that listens to messages on a kafka topic


## Setup:
* Downloaded apache kafka_2.13-2.4.0 from kafka website and extracted it
* Created a directory to store data
   	mkdir data/zookeeper
* Updated zookper property dataDir  (config/zookeeper.properties) 
~~~~
dataDir=C:\projects\kafka\kafka_2.13-2.4.0\data\zookeeper
~~~~

* Updated kafka property log.dirs (config/server.properties)
~~~~
log.dirs=/mnt/c/projects/kafka/kafka_2.13-2.4.0/data/kafka
~~~~

## Start Zookeeper and Kafka
* Open a powershell and start Zooker
~~~~
cd C:\projects\kafka\kafka_2.13-2.4.0\
zookeeper-server-start config/zookeeper.properties
~~~~

* Open another powershell and start kafka
~~~~
cd C:\projects\kafka\kafka_2.13-2.4.0\
kafka-server-start config/server.properties
~~~~

## Create topic 
* Open third powershell and create topic called topic1.  This topic is used in the program
~~~~
kafka-topics --zookeeper localhost:2181 --topic topic1 --create --partitions 3 --replication-factor 1
kafka-topics --zookeeper localhost:2181 --list
kafka-topics --zookeeper localhost:2181 topic1 --describe
~~~~

## Run it 
* Run the Spring Application in IntelliJ and starts listening to the topic1.

* Then go to powershell and run following to send few messages
~~~~
cd C:\projects\kafka\kafka_2.13-2.4.0\bin\windows
kafka-console-producer --broker-list localhost:9092 --topic topic1
~~~~

* Check IntelliJ and ensure those messages are read

## Clean up
* Things break once in a while so clean up everything.  Stop kafka and zookeeper.  Remove the kafka and zookeper files (**data is lost**) and recreate topic
* Open a powershell
~~~~
cd C:\projects\kafka\kafka_2.13-2.4.0\
Remove-Item -Path .\data\kafka\ -Recurse
Remove-Item -Path .\data\zookeeper\ -Recurse
kafka-topics --zookeeper localhost:2181 --topic topic1 --create --partitions 3 --replication-factor 1
