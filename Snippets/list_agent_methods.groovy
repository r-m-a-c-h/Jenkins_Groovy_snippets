/////////////////////////////////////////////////////////////////
/// List agent methods                                        ///
/////////////////////////////////////////////////////////////////


/// Script Console

import jenkins.model.Jenkins

def agentName = 'Agent_007'

def agent = Jenkins.instance.getNode(agentName)

if (agent) {
    println "Methods available on agent '${agentName}':"
    agent.metaClass.methods*.name.sort().unique().each { println it }
} else {
    println "Agent '${agentName}' not found."
}
