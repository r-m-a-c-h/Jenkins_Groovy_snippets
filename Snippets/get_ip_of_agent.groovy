/////////////////////////////////////////////////////////////////
/// Get IP of agent                                           ///
/////////////////////////////////////////////////////////////////


/// Script Console

import jenkins.model.Jenkins
import java.net.InetAddress

def agentName = 'Agent_007'
def agent = Jenkins.instance.getNode(agentName)

if (agent) {
    def computer = agent.toComputer()
    if (computer && computer.isOnline()) {
        try {
            def hostname = computer.getHostName()
            def ip = InetAddress.getByName(hostname).hostAddress
            println "Agent '${agentName}' IP address: ${ip}"
        } catch (UnknownHostException e) {
            println "Could not resolve hostname for agent '${agentName}': ${e.message}"
        }
    } else {
        println "[Agent '${agentName}']: is offline or computer object unavailable"
    }
} else {
    println "[Agent '${agentName}']: not found"
}