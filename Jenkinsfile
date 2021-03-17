node {
def mvnHome
stage('Prepare') {
git url: 'https://github.com/aamir85284/ABC_Airlines_TeamD.git', branch: 'master'
mvnHome = tool 'maven'
}

stage('Build') {
if (isUnix()) {
sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
} else {
bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
 }
 }


stage('Unit Test') {
junit '**/target/surefire-reports/TEST-*.xml'
archive 'target/*.jar'
}
stage('Integration Test') {
if (isUnix()) {
sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean verify"
} else {
bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean verify/)
}
}
stage('Sonar') {
if (isUnix()) {
sh "'${mvnHome}/bin/mvn' sonar:sonar"
} else {
bat(/"${mvnHome}\bin\mvn" sonar:sonar/)
}
}



}
