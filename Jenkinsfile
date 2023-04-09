pipeline{

    agent any

   tools{
       maven 'manasa_maven'

   }

   triggers{
    pollSCM('* * * * *')
   }

   options{
      timestamps()
      buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: '5'))
   }

  stages{

     stage('CheckOutCode'){
       steps{
        git branch: 'master', credentialsId: '957b543e-6f77-4cef-9aec-82e9b0230975', url: 'https://github.com/devopstrainingblr/maven-web-application-1.git'
	
	   }
     }
  
     stage('Build'){
        steps{
          sh  "mvn clean package"
        }
     }
     stage("Build The Downstream Job"){
	 steps{
	     build job: "manasa_prod"
	 }
     }
  }
  post {
        always {
            script {
                def branch_name = sh(
                    script: 'git rev-parse --abbrev-ref HEAD',
                    returnStdout: true
                ).trim()

                def commit_id = sh(
                    script: 'git rev-parse HEAD',
                    returnStdout: true
                ).trim()

                def build_number = currentBuild.number

                def build_name = "${branch_name}-${commit_id}-${build_number}"
                
                currentBuild.displayName = build_name
            }
        }
    }
}
