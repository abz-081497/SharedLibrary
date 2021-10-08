def pushToS3(Map stageParams) {
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