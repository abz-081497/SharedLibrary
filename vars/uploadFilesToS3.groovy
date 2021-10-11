def call(String path = "*.jar", String s3Path = "/",String workingDir = "target", String  s3Bucket,Map stageParams = [Region: "us-east-1",  s3Bucket: "test-bucket-demo-abigael", s3Path: "/"]) {

    withAWS(region: stageParams.Region, credentials:'awscredentials') {
        awsIdentity()
        s3Upload( 
            workingDir: workingDir,
            includePathPattern: path,
            bucket: s3Bucket,
            path: s3Path
        )
    }
}
