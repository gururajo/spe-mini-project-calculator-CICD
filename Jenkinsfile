pipeline {
    agent any
    stages {
        stage('git clone') {
            steps {
                git url: 'https://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@github.com/gururajo/spe-mini-project-calculator-CICD.git', branch: 'main'
            }
        }
        stage('clean') {
            steps {
                script {
                    sh 'chmod 777 mvnw'
                    sh './mvnw clean'
                }
            }
        }
        stage('compile main') {
            steps {
                sh './mvnw compiler:compile'
            }
        }
        stage('compile tests') {
            steps {
                sh './mvnw compiler:testCompile'
            }
        }
        stage('build') {
            steps {
                sh './mvnw package'
            }
        }
        stage('build docker') {
            steps {
                 script {
                    docker.build('mini-project-calculator:latest', '-f ./Dockerfile .')
                }
            }
        }
        stage('create tag and push docker') {
            steps {
                 script {
                    docker.withRegistry('','a35784e8-a508-4b02-8262-03b415dadd5d'){
                    sh 'docker tag mini-project-calculator gururajo/mini-project-calculator:latest'
                    sh 'docker push gururajo/mini-project-calculator'
                    }

                }
            }
        }
        stage('call ansible') {
            steps {
                 script {
                    ansiblePlaybook(
                        playbook: 'playbook.yml',
                        inventory: 'inventory.ini'
                     )
                }

            }
        }
    }
}
