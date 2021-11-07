pipeline {
    agent any
    stages {
        stage('git clone repo & clean') {
            steps {
              bat "rmdir  /s /q Timesheet"
                bat "git clone https://github.com/chermrone/Timesheet.git"
                bat "mvn clean -f Timesheet"
            }
        }
      /*  stage('install') {
            steps {
                bat "mvn install -f TimeSheet"
            }
        } */ 
        
        stage('test') {
            steps {
                bat "mvn test -f TimeSheet"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f TimeSheet"
                bat "mvn deploy -f TimeSheet"
                bat "mvn sonar:sonar -f 
            }
        }
    }
}
