node {
   stage ('Clone sources')
   {
    git url: 'https://github.com/cginternals/cmake-init.git' 
   }
 stage ('CMAKE')
 {
	build 'ProjectCmake'
 }
}
parallel firstBranch: {
    stage ('Coverage') 
    {
        build 'ProjectCoverage'
    }
}, secondBranch: {
    stage ('Memoryleaks') 
    {
        build 'ProjectValgrind'
    }
}, thirdBranch: {
   stage ('Google Tests')
    {
        build 'ProjectGoogleTest'
    }
}
