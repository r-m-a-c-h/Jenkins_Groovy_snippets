/////////////////////////////////////////////////////////////////
/// manage/configureTools/                                    ///
/// List global tools configuration                           ///
/////////////////////////////////////////////////////////////////


/// Script Console

import jenkins.model.Jenkins
import hudson.tools.ToolDescriptor
import hudson.tools.ToolInstallation

def jenkins = Jenkins.getInstance()
def toolDescriptors = jenkins.getDescriptorList(ToolInstallation.class)

toolDescriptors.each { descriptor ->
    println("Tool: ${descriptor.getDisplayName()}")
    descriptor.getInstallations().each { installation ->
        println("  Name: ${installation.getName()}")
        println("  Home: ${installation.getHome()}")
    }
}