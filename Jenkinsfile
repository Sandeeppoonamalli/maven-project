pipeline {
    agent {
        label 'Dev'
    }
    params {
        string(name: 'LastName', defaultValue: 'Poonamalli')
    }
    Environment {
        Name= 'sandeep'
    }

    tools {
        maven 'MyMaven'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
                echo "Hello,${Name} ${params.LastName}"
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
    }
}