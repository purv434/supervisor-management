# supervisor-management

Supervisor management is a spring boot  and react js based web application. In this application manager or admine can send the notification to particular supervisor and this is a one page appliation.

## For easy way to running this application we need to install docker in our system.
[docker install in windows reference](https://docs.docker.com/desktop/windows/install/ "docker install reference")
[docker install in linux reference](https://docs.docker.com/desktop/linux/install/ "docker install reference")

## Backend : 
        - Spring boot app with latest spring version 2.7.1 and jdk version 1.8.
        - This application Run on http://localhost:8181/
        - There are two rest endpoint present in this app [/api/supervisors, /api/submit].
        - Added proper validation like 
              - Numeric jurisdictions should be removed from the response.
              - The format of the supervisors returned must be displayed in the following format “<jurisdiction> - <lastName>, <firstName>”
              - If the request omits the first name, last name, or supervisor field then the  endpoint needs to return an error response with an appropriate message.
              - Name fields are required and must only contain letters, no numbers.
              - Standard validation against phone number and/or email must be applied.
              - Any invalid requests must send back an error response.
        - For backed service create Docker image [docker build -t supervisor-management .]
        
## UI :
        - React js app with latest react version 18.2.0.
        - This application Run on http://localhost:3000/
        - For API managment I have used to axios,For UI managment used to reactstrap and bootstrap.
        - Added proper validation like show tost message if some mandetory filed is null or empty  and manage proper state.
        - For UI create Docker image [docker build -t supervisor-ui .]


## Below step follow and run application with docker.

- Clone project using git command.
    - [Git Installation](https://www.atlassian.com/git/tutorials/install-git#:~:text=Install%20Git%20on%20Windows,-Git%20for%20Windows&text=Download%20the%20latest%20Git%20for%20Windows%20installer.,prompts%20to%20complete%20the%20installation. "Git Installation")
    - git clone with this command : [git clone https://github.com/purv434/supervisor-management.git]
- Open terminal or cmd then after go to supervisor-managment directory.
- Make docker build for backend using this command : [docker build -t supervisor-management .]
- Same thing go to supervisor-management-ui directory.
- Make docker build for UI using this command : [docker build -t supervisor-ui .]
- Then after go to main directory which is present in  docker-compose.yml file and execute this command - [docker-compose up]
