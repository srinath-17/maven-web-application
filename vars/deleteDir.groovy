def call(String deleteDir = sh " rm -rf sharedlib/target/maven-web-application.war "){
  sh "rm -rf ${directoryName}
}  
