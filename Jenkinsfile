node {
def mvnHome
stage('Prepare') {
git url: 'https://github.com/aamir85284/ABC_Airlines_TeamD.git', branch: 'master'
mvnHome = tool 'maven'
}

stage('Sonar') {
if (isUnix()) {
sh "'${mvnHome}/bin/mvn' sonar:sonar"
} else {
bat(/"${mvnHome}\bin\mvn" sonar:sonar/)
}
}
}

