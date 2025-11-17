pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/jay-java/Boooooot.git'
            }
        }
        stage('Build JAR') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t java_simple_app:latest .'
            }
        }
        stage('Run Container') {
            steps {
                sh '''
                docker rm -f bootjsp || true
                docker run -d --name bootjsp -p 9090:9090 bootjsp:latest
                '''
            }
        }
    }
}
