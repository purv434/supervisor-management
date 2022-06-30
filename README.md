# supervisor-management

Supervisor management is a spring boot  and react js based web application.

## Backend : 
        - Spring boot app with latest spring version 2.7.1 and jdk version 1.8.
        - Run on http://localhost:8181/
        - For backed service create Docker image [docker build -t supervisor-management .]
## UI :
        - React js app with latest react version 18.2.0.
        - Run on http://localhost:3000/
        - For UI create Docker image [docker build -t supervisor-ui .]


## Below step follow and run application.

- Clone project using git command.
- Go to supervisor-managment directory and open terminal or cmd.
- Make docker build using this command : docker build -t supervisor-management .
- Same thing go to supervisor-management-ui directory and open terminal or cmd.
- Make docker build using this command : docker build -t supervisor-ui .
- Then after go to main directory which is present in  docker-compose.yml file and open terminal and write command - [ docker-compose up ]
