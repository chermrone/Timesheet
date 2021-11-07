pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
               bat "rmdir  /s /q Timesheet"
                bat "git clone https://github.com/chermrone/Timesheet.git"
                bat "mvn clean -f Timesheet"
            }
        }
        stage('install') {
            steps {
                bat "mvn install -f Timesheet"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f Timesheet"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f Timesheet"
            }
        }
    }
}
