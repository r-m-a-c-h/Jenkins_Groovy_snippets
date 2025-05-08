/////////////////////////////////////////////////////////////////
/// manage/computer/                                          ///
/// List all node details                                     ///
/////////////////////////////////////////////////////////////////


/// Script Console

import jenkins.model.Jenkins
import hudson.model.Node
import hudson.tools.ToolLocationNodeProperty
import hudson.slaves.EnvironmentVariablesNodeProperty

def jenkins = Jenkins.getInstance()
def nodes = jenkins.getNodes()

nodes.each { node ->
    println("Node: ${node.getDisplayName()}")
    println("  Description: ${node.getNodeDescription()}")
    println("  Remote FS: ${node.getRemoteFS()}")
    println("  Label: ${node.getLabelString()}")
    println("  Executors: ${node.getNumExecutors()}")
    println("  Mode: ${node.getMode()}")
    println("  Retention Strategy: ${node.getRetentionStrategy().getClass().getSimpleName()}")
    println("  Launcher: ${node.getLauncher().getClass().getSimpleName()}")
    try {
        println("  Launcher Details: ${node.getLauncher().getDescriptor().getDisplayName()}")
    } catch (UnsupportedOperationException e) {
        println("  Launcher Details: Not available")
    }
    println("  Node Properties:")
    node.getNodeProperties().each { property ->
        println("    Property: ${property.getClass().getSimpleName()}")
        if (property instanceof ToolLocationNodeProperty) {
            property.getLocations().each { location ->
                println("      Tool: ${location.getName()}")
                println("      Location: ${location.getHome()}")
            }
        } else if (property instanceof EnvironmentVariablesNodeProperty) {
            property.envVars.each { key, value ->
                println("      ${key}: ${value}")
            }
        }
    }
    println("  Node Status: ${node.getComputer().isOnline() ? 'Online' : 'Offline'}")
    println("")
}
