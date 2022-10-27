def call(String deleteDir = sh " rm -rf target/maven-web-application.war "){
  sh "rm -rf ${directoryName}
}  
