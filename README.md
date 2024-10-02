1) Install IntelliJ Community
	https://www.jetbrains.com/idea/download/other.html

2) Download generated spring initializr
	https://start.spring.io/

	Project: Maven
	Language: Java
	Spring Boot: 3.3.4
	Packaging: War
	Java: 23

3) Unzip and open with IntelliJ
	Set Java SDK 23 (click download if not exists)

4) Run, Edit Configurations, Maven
	Search: spring-boot-run
		OK
	Open pom.xml and Add into dependencies:
		<dependency>
			<groupId>com.machinezoo.sourceafis</groupId>
			<artifactId>sourceafis</artifactId>
			<version>3.18.1</version>
		</dependency>

5) Run proyect

6) Run python demo.py

More info: https://sourceafis.machinezoo.com/java