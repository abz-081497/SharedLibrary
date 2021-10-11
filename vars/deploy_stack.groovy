def call(String buketName, String stackFile, Map stageParams = [awsRegion: "us-east-1"]){
  withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {
        awsIdentity()
        cfnCreateChangeSet(
          stack:'EC2Jenkins', 
          changeSet:'my-change-set', 
          url:'https://${bucketName}.s3.amazonaws.com/${stackFile}'
        )
        cfnExecuteChangeSet(
          stack:'EC2Jenkins', 
          changeSet:'my-change-set'
        )
  }
}
