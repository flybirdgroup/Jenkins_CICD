pipeline {
    agent any

    environment {
        NEW_VERSION = '1.3.0'
    }

    // tools {
    //     // Install the Maven version configured as "M3" and add it to the path.
    //     maven "M3"
    // }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                // git 'https://github.com/jglick/simple-maven-project-with-tests.git'

                // Run Maven on a Unix agent.
                sh "echo hello"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            } 
            }
        stage('test') {
            when {
                expression {
                    env.BRANCH_NAME == 'main' || env.BRANCH_NAME == 'dev'
                }
            }
            steps {
                sh "echo test stage"
            }
        }
        stage("deploy") {
                steps{
                    sh "echo deploy stage"
                    withCredentials([gitUsernamePassword(credentialsId: 'd8847954-6db5-47e0-81b7-33febc3c8881', gitToolName: 'Default')]) 
                    { 
                        sh "echo gitToolName"
                     }
                }
            }
        }
        
        post {
            success {
                sh "echo done"
            }
        }
}
