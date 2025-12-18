pipeline {
    agent {
        label 'Dev'
    }
    parameters {
        string(name: 'LastName', defaultValue: 'Poonamalli')
    }
    environment {
        Name = 'sandeep'
    }

    tools {
        maven 'MyMaven'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
                echo "Hello, ${env.Name} ${params.LastName}"
            }
            
        }
        stage('Test') {
            parallel {
                stage('Unit Tests') {
                    steps {
                        echo 'Running unit tests...'
                        // Add unit test commands here
                    }
                }
                stage('Integration Tests') {
                    steps {
                        echo 'Running integration tests...'
                        // Add integration test commands here
                    }
                }
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
            
        }
    }

}