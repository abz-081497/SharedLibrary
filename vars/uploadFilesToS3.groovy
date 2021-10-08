def call(Map stageParams = [Region: "us-east-1", s3Bucket: "test-bucket-2221", s3Path: "/"], String path = "*.jar", String s3Path = "/") {

    withAWS(region: stageParams.Region, credentials:'awscredentials') {
        awsIdentity()
        s3Upload( 
            workingDir: "target",
            includePathPattern: path,
            bucket: stageParams.s3Bucket,
            path: s3Path
        )
    }
}