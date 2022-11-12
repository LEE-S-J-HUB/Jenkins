pipeline {
  agent any
  stages {
    stage('Packer') {
      steps {
        withAWS(credentials: 'AWS_Credentials', region: 'ap-northeast-2') {
        sh """
        #!/bin/bash
        cd packer_build_test
        pwd
        ls -al
        packer build aws-ubuntu.pkr.hcl
        """
      }
    }
  }
}
}