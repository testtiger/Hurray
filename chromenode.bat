title chrome-node
java -jar lib/selenium-server-standalone-2.41.0.jar -port 5557 -role node  -hub http://localhost:4444/grid/register -Dwebdriver.chrome.driver="Drivers\chromedriver.exe" -browser browserName=chrome,maxInstances=3,platform=WINDOWS 

