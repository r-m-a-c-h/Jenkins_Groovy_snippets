/////////////////////////////////////////////////////////////////
/// manage/configure/                                         ///
/// List system configurations                                ///
/////////////////////////////////////////////////////////////////


/// Script Console

import jenkins.model.Jenkins
import hudson.model.Node
import hudson.tools.ToolInstallation
import hudson.slaves.EnvironmentVariablesNodeProperty
import hudson.tools.ToolLocationNodeProperty

def jenkins = Jenkins.getInstance()

println("System Message: ${jenkins.getSystemMessage()}")
println("Jenkins URL: ${jenkins.getRootUrl()}")
println("Quiet Period: ${jenkins.getQuietPeriod()}")
println("SCM Checkout Retry Count: ${jenkins.getScmCheckoutRetryCount()}")
println("Global Properties:")
jenkins.getGlobalNodeProperties().each { property ->
    println("  Property: ${property.getClass().getSimpleName()}")
    if (property instanceof EnvironmentVariablesNodeProperty) {
        property.envVars.each { key, value ->
            println("    ${key}: ${value}")
        }
    }
}

println("Tool Locations:")
def toolDescriptors = jenkins.getDescriptorList(ToolInstallation.class)
toolDescriptors.each { descriptor ->
    println("Tool: ${descriptor.getDisplayName()}")
    descriptor.getInstallations().each { installation ->
        println("  Name: ${installation.getName()}")
        println("  Home: ${installation.getHome()}")
    }
}

println("Jenkins Home Directory: ${jenkins.getRootDir()}")
println("Number of Executors: ${jenkins.getNumExecutors()}")
println("Workspace Root Directory: ${jenkins.getRawWorkspaceDir()}")
println("Markup Formatter: ${jenkins.getMarkupFormatter().getClass().getSimpleName()}")