pipeline {
  agent any
  stages {
    stage('Packer') {
      steps {
        withAWS(credentials: 'AWS_Credentials', region: 'ap-northeast-2') {
        sh """
        #!/bin/bash
        cd packer_build_test
        ls -al
        packer build packer_build_test/aws-ubuntu.pkr.hcl
        """
      }
    }
  }
}
}