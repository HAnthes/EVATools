:restart
if exist C:\EVATransport\Server\stop.txt goto ende
java -XX:+HeapDumpOnOutOfMemoryError -Djava.rmi.server.hostname=10.57.109.81 -jar EVA-Server.jar server.Server

goto restart
echo Ende
:ende