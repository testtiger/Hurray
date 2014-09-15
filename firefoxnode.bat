title Fire-fox-node
java -jar lib/selenium-server-standalone-2.41.0.jar -port 5556 -role node  -hub http://localhost:4444/grid/register -browser browserName=firefox,maxInstances=3,platform=WINDOWS