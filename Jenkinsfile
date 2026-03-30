pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Build') {
            steps {
                echo 'Build World'
            }
        }
        stage('Test') {
            steps {
                 sh 'mvn clean test'
            }
        }
    }
    post
    {
        always
        {
            emailext body: 'summary see pipelinstatus', subject: 'pipeline status', to: 'ogguruchith27@gmail.com'
        }
    }

}
