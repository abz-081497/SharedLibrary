def call(String path = "*.jar", String s3Path = "/",String workingDir = "target" ,Map stageParams = [Region: "us-east-1",  "test-bucket-2221", s3Path: "/"]) {

    withAWS(region: stageParams.Region, credentials:'awscredentials') {
        awsIdentity()
        s3Upload( 
            workingDir: workingDir,
            includePathPattern: path,
            bucket: stageParams.s3Bucket,
            path: s3Path
        )
    }
}