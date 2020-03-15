# Kafka on Windows


##Setup:
### WSL
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

#### Start
* One powershell
~~~~
cd C:\projects\kafka\kafka_2.13-2.4.0\
zookeeper-server-start config/zookeeper.properties
~~~~

* Another powershell
~~~~
cd C:\projects\kafka\kafka_2.13-2.4.0\
kafka-server-start config/server.properties
~~~~

* Things break once in a while so clean up everything.  Stop kafka and zookeeper.  Remove the kafka and zookeper files (**data is lost**) and recreate topic
* Open a powershell
~~~~
cd C:\projects\kafka\kafka_2.13-2.4.0\
Remove-Item -Path .\data\kafka\ -Recurse
Remove-Item -Path .\data\zookeeper\ -Recurse
kafka-topics --zookeeper localhost:2181 --topic topic1 --create --partitions 3 --replication-factor 1


### Other commands
Create a topic called topic1 which is used in the program
~~~~
kafka-topics --zookeeper localhost:2181 --topic topic1 --create --partitions 3 --replication-factor 1
kafka-topics --zookeeper localhost:2181 --list
kafka-topics --zookeeper localhost:2181 topic1 --describe
~~~~

Run the Spring Application in IntelliJ.  Then go to powershell and run following to drop few messasges
~~~~
cd C:\projects\kafka\kafka_2.13-2.4.0\bin\windows
kafka-console-producer --broker-list localhost:9092 --topic topic1
~~~~




