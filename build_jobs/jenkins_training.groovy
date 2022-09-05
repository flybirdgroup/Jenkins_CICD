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
        stage('Initializing Stage') {
            steps {
                script {
                    gv = load "./build_jobs/script.groovy" 
                }
            } 
            }
        stage('Build Stage') {
            steps {
                script {
                    gv.buildApp()
                }
            } 
            }
        stage('Test Stage') {
            when {
                expression {
                    env.BRANCH_NAME == 'main'
                }
            }
            steps {
                script{
                     gv.testApp()
                }
            }
        }
        stage("deploy Stage") {
             when {
                expression {
                    params.executeTests
                }
             }
             input {
                message "Select the environment to deploy to"
                ok "done"
                parameters {
                    choice choices: ['Prod','Staging','Dev'], name: 'Proj_Env'
                }
             }
            steps{
                script{                    
                withCredentials([usernamePassword(credentialsId: 'd8847954-6db5-47e0-81b7-33febc3c8881', passwordVariable: 'password', usernameVariable: 'username')]) 
                {
                        sh "echo ${username}"
                        sh "echo ${password}"
                    }
                gv.deployApp()
                echo "Deploying to ${Proj_Env}"
                }
                 }        
        }
    } 
    post {
    always {
       script {
            echo " One or more steps need to be included within each condition's block."
        }     
    }
    // aborted {
    //    script {
    //         sh " echo One or more steps need to be included within each condition's block."
    //    }
    // }
    }
}
