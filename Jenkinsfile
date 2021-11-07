pipeline {
    agent any
    stages {
        stage('git clone repo & clean') {
            steps {
              bat "rmdir  /s /q Timesheet"
                bat "git clone https://github.com/chermrone/Timesheet.git"
                bat "mvn clean -f Timesheet"
                bat "mvn install -f TimeSheet"
                bat "mvn test -f Timesheet"
            }
        }
      /*  stage('install') {
            steps {
                bat "mvn install -f TimeSheet"
            }
        }  
        
        stage('test') {
            steps {
                bat "mvn test -f Timesheet"
            }
        }*/
        stage('package') {
            steps {
                bat "mvn package -f Timesheet"
                bat "mvn deploy -f Timesheet"
                bat "mvn sonar:sonar -f "
            }
        }
    }
}
