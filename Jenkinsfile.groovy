pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clonar o repositório do GitHub
                git 'https://github.com/leopaulasilva/sistema.git'
            }
        }

        stage('Build') {
            steps {
                // Compilar o projeto com Maven
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Executar os testes com Maven
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Copiar o artefato para o diretório de implantação (substitua 'path/to/deployment' pelo diretório correto)
                sh 'cp target/sistema.jar path/to/deployment'
            }
        }
    }

    post {
        success {
            // Notificar sucesso
            echo 'Build e testes passaram com sucesso!'
        }
        failure {
            // Notificar falha
            echo 'Build ou testes falharam!'
        }
    }
}
