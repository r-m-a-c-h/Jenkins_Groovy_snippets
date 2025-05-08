/////////////////////////////////////////////////////////////////
/// manage/configure - Environment variables                  ///
/// Print all env vars                                        ///
/////////////////////////////////////////////////////////////////


/// Script Console

def envVars = jenkins.model.Jenkins.instance.getGlobalNodeProperties()
envVars.each { env ->
    env.getEnvVars().each { key, value ->
        println "${key} = ${value}"
    }
}

/// Pipeline 

pipeline {
    agent any
    stages {
        stage('Print Environment Variables') {
            steps {
                script {
                    env.each { key, value ->
                        echo "${key} = ${value}"
                    }
                }
            }
        }
    }
}