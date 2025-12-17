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
            post {
                success {
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
    }
}