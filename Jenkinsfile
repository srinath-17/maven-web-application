pipeline{

    agent any

   tools{
       maven 'manasa_maven'

   }
   parameters {
      choice choices: ['development', 'master'], description: 'This job is parametrized', name: 'BranchName'
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
	       git branch: '${BranchName}', credentialsId: '957b543e-6f77-4cef-9aec-82e9b0230975', url: 'https://github.com/devopstrainingblr/maven-web-application-1.git'
	
	   }
     }
  
     stage('Build'){
        steps{
          sh  "mvn clean package"
        }
     }
    stage("Build sample project Job"){
	    steps{
		   build job: 'sris_game_testing_proj_pipe_dev'
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
