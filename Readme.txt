Taller 2

Punto 1:
- ejecutar el servidor mediante maven sobre la carpeta ./paseos/servidor_paseos (mvn exec:java)
- ejecutar el cliente mediante maven ./paseos/cliente_paseos (mvn exec:java)

- En el cliente se pueden hacer solicitudes al servidor por medio del menú interno que hay en la app

Punto 2:
- Primero hay que iniciar el servicio de descubrimiento (./servidoreureka), luego los servicios de operaciones (./sumador, ./restador, ./multiplicador y ./divisor), y por ultimo el servicio de calculadora (./calculadora)
- para ejecutar los procesos necesarios para el ejercicio (en SO windows) puede observar el archivo Calculadora/ejecutar.bat, o en otras plataformas ejecutar el equivalente de cada comando de forma manual uno por uno.
	- ej: mvn -f "./restador" spring-boot:run -Dspring-boot.run.arguments=--server.port=13002 ejecuta un restador en el puerto 13002, estando situados sobre la carpeta ./Calculadora/ o mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=13002 estando situado en la carpeta ./restador

Para compilar cualquier proyecto utilizar mvn clean install