def call() {
    pipeline {
        agent any
        environment {
            buketName = 'cloud_user',
			stackFileName = 'myFile.yaml',
			stackName = 'myTestStack'
        }
        stages {
            stage('Upload template to S3') {                  
                steps {
                    uploadTemplateToS3(${buketName}, ${stackFileName})
                }
            }
            stage('Deploy Stack') {                  
                steps {
                    deploy_stack(${stackName}, ${buketName}, ${stackFileName})
                }
            }
        }
    }
}
