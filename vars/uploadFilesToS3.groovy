def call(Map stageParams = [Region: "us-east-1", s3Bucket: "test-bucket-2221", s3Path: "/"]) {

    withAWS(region: stageParams.Region, credentials:'awscredentials') {
        awsIdentity()
        s3Upload( 
            workingDir: "target",
            includePathPattern: "*.jar",
            bucket: stageParams.s3Bucket,
            path: stageParams.s3Path
        )
    }
}