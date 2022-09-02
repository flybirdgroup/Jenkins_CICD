pipeline {
    agent any

    environment {
        NEW_VERSION = '1.3.0'
    }
    parameters {
        string description: 'version to deploy on dev', name: 'Version'
        choice choices: ['1.1','1.2','1.3'], name: 'Version'
        booleanParam defaultValue: true, name: 'executeTests'
    }



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
                    env.BRANCH_NAME == 'main'
                }
            }
            steps {
                sh "echo test stage"
            }
        }
        stage("deploy") {
             when {
                expression {
                    params.executeTests
                }
             }
            steps{
                echo " deploying ${params.executeTests}"
                // withCredentials([gitUsernamePassword(credentialsId: 'd8847954-6db5-47e0-81b7-33febc3c8881', gitToolName: 'Default')]) 
                // { 
                //     echo " deploying ${params.executeTests}"
                //     }
            // }
                 }        
        }
    } 
    post {
    always {
       script {
            sh "echo One or more steps need to be included within each condition's block."
        }     
    }
    aborted {
       script {
            sh " echo One or more steps need to be included within each condition's block."
       }
    }
    }
}
