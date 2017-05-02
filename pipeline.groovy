node {
   stage ('Clone sources')
   {
    git url: 'https://github.com/cginternals/cmake-init.git' 
   }
 stage ('CMAKE')
 {
	build 'ProjectCmake'
 }
   stage ('Coverage') {
        build 'ProjectCoverage'
   }
   stage ('Valgrind') {
       build 'ProjectValgrind'
   }
   stage ('Google-test')
       build 'ProjectGoogleTest'
}
