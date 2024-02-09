pipeline {
    agent any
    stages {
        stage('Clean and Build') {
            steps {
                sh 'mvn clean install package'
                // Remove the existing 'login' directory if it exists
                //sh 'rm -rf login'

                // Clone the repository into the default workspace directory
                //sh 'git clone https://github.com/A-B-Ca/loginTest.git'

                // Navigate to the cloned directory and run Maven clean, install, and package
                //dir('loginTest') {
                //    sh 'mvn clean install package'
                //}
            }
        }

        stage('Test') {
            steps {
                // Navigate to the cloned directory and run Maven test
                //dir('loginTest') {
                    sh 'mvn test'
                //}
            }
        }
        stage('Package') {
                            steps {
                                sh 'mvn package'
                            }
                        }
        stage('Build and create  DOcker Image') {
                    steps {
                        sh 'docker build -t login .'
                    }
                }
        stage('Docker login') {
                            steps {

                            withCredentials([string(credentialsId: 'Dockerid', variable: 'dockerid')]) {
                                sh 'docker login -u abcanada -p ${dockerid}'
                            }
                            }
                        }
        stage('Docker push to repo') {
                            steps {
                                sh 'docker push abcanada/login'
                            }
                        }

        stage('Deploy') {
            steps {
                // Navigate to the 'target' directory and run the Spring Boot application
                //dir('loginTest/target') {
                    sh 'docker run -p 8084:8084 login'
                //}
            }
        }
    }
}
