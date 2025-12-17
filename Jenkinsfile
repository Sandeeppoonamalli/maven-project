pipeline
{

    agent {
        label 'Dev'

    }

    tools {
        maven 'MyMaven'

    stages
    {
        stage('Build')
        {
            steps
            {
              sh 'mvn clean package'
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/*.war'
                
                }
            }
        }
        
    } 
}