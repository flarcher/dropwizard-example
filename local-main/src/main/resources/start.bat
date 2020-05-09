rem Start script for Windows OS

%JAVA_HOME%\bin\java.exe -jar ${project.build.finalName}.jar server configuration.yml %1
