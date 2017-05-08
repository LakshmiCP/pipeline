node {
   stage ('Clone sources')
   {
    git url: 'https://github.com/cginternals/cmake-init.git' 
   }
 stage ('ArtifactprojectCmake')
 {
	//  sh "mkdir -p output"
	//build 'ArtifactProjectCmake'
	dir('/var/lib/jenkins/jobs/ArtifactProjectCmake/workspace/') {
    sh 'pwd'
    stash includes: '**/build/fiblib-test', name: 'app' 
   // stash name: "first-stash", includes: "**/build/*"
    }
 }

    stage ('Coverage') {
        dir("/var/lib/jenkins/jobs/ArtifactProjectCoverage/workspace/") {
        unstash 'app'
        build 'ArtifactProjectCoverage'
    }
    
    stage ('valgrind') {
        dir("/var/lib/jenkins/jobs/ProjectValgrind/workspace/") {
        unstash 'app'
        build 'ProjectValgrind'
    }
    }   
    }

}
   
  

