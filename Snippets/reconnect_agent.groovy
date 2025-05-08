/////////////////////////////////////////////////////////////////
/// Reconnect agent                                           ///
/////////////////////////////////////////////////////////////////


/// Script Console

def agentName = "Agent_007"

// Get the agent node
def agent = Jenkins.instance.getNode(agentName)

// Reconnect the agent
if (agent) {
    agent.toComputer().disconnect()
    agent.toComputer().connect(true)
    println "[Agent ${agentName}]: reconnected successfully."
} else {
    println "[Agent ${agentName}]: not found."
}

/// Pipeline 

pipeline {
    agent any
    stages {
        stage('Reconnect Agent') {
            steps {
                script {
                    def agentName = 'Agent_007'
                    
                    // Get the agent node
                    def agent = Jenkins.instance.getNode(agentName)
                    
                    // Reconnect the agent
                    if (agent) {
                        agent.toComputer().disconnect()
                        agent.toComputer().connect(true)
                        echo "Agent ${agentName} reconnected successfully."
                    } else {
                        echo "Agent ${agentName} not found."
                    }
                }
            }
        }
    }
}