pipeline {
    agent any

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
                }
            }
        }
        
        post {
            success {
                sh "echo done"
            }
        }
}
