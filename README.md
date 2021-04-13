# football-match

***Steps to run:***
1. Pull the code to local
2. Use the command "gradle clean build" 
3. Run command 'java -jar build/libs/football-match-0.0.1-SNAPSHOT.jar' to run java application
4. Open browser and open the swagger link 'http://localhost:8080/swagger-ui/'

To create docker image use below command:
**docker build --no-cache --build-arg JAR_FILE="build/libs/football-match-0.0.1-SNAPSHOT.jar" -f ./Dockerfile -t football_match_0.0.1 .** 

Sample URL for Application: http://localhost:8080/getTeamDetails/England/Premier%20League/Liverpool
