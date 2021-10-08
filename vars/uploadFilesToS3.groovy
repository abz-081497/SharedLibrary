def call(String path = "*.jar", String s3Path = "/", Map stageParams = [Region: "us-east-1", workingDir = "target",  "test-bucket-2221", s3Path: "/"]) {

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