start cmd /k mvn -f "./eurekaserver" spring-boot:run

timeout 25

start cmd /k mvn -f "./divisor" spring-boot:run -Dspring-boot.run.arguments=--server.port=11001
start cmd /k mvn -f "./divisor" spring-boot:run -Dspring-boot.run.arguments=--server.port=11002
start cmd /k mvn -f "./sumador" spring-boot:run -Dspring-boot.run.arguments=--server.port=12001
start cmd /k mvn -f "./sumador" spring-boot:run -Dspring-boot.run.arguments=--server.port=12002
start cmd /k mvn -f "./restador" spring-boot:run -Dspring-boot.run.arguments=--server.port=13001
start cmd /k mvn -f "./restador" spring-boot:run -Dspring-boot.run.arguments=--server.port=13002
start cmd /k mvn -f "./multiplicador" spring-boot:run -Dspring-boot.run.arguments=--server.port=14001
start cmd /k mvn -f "./multiplicador" spring-boot:run -Dspring-boot.run.arguments=--server.port=14002
start cmd /k mvn -f "./multiplicador" spring-boot:run -Dspring-boot.run.arguments=--server.port=14003
start cmd /k mvn -f "./multiplicador" spring-boot:run -Dspring-boot.run.arguments=--server.port=14004

timeout 50

start cmd /k mvn -f "./calculadora" spring-boot:run