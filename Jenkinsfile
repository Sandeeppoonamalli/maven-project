pipeline {
    agent {
        label 'Dev'
    }
    parameters {
        choice choices: ['dev', 'prod'], name: 'select_enviornment'
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
                sh 'mvn clean package -DskipTests=true'
                
            }
            
        }
        stage('Test') {
            parallel {
                stage('Unit Tests') {
                    agent {
                        label 'Dev'
                    }
                    steps {
                        echo 'Running unit tests...'
                        sh 'mvn test'
                        // Add unit test commands here
                    }
                }
                stage('Integration Tests') {
                    agent {
                        label 'Dev'
                    }
                    steps {
                        echo 'Running integration tests...'
                        sh 'mvn test'
                        // Add integration test commands here
                    }
                }
            }
            post {
                success {
                    dir("webapp/target/")
                    {
                        stash name : "maven-build", includes : "*.war"
                    }

                }
            }
            
        }
        stage('Deploy') {
            when {
                expression { params.select_enviornment == 'dev' }
            }
            agent {
                label 'Dev'
            }
            steps {
                dir("${WORKSPACE}/deployment") {
                    unstash "maven-build"
                    sh """
                    jar -xvf *.war
                    """
                }
            }
        }
    }

}