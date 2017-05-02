node {
 triggers {
        cron('H 4/* 0 0 1-5')
   }
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
