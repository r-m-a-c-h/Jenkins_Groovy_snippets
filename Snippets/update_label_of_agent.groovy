/////////////////////////////////////////////////////////////////
/// Update label of selected agents                           ///
/////////////////////////////////////////////////////////////////


/// Script Console

import jenkins.model.Jenkins
import jenkins.model.JenkinsLocationConfiguration

agentNameContains = "Agent"
labelToFind = "new_label"
agentLinks = []

def rootUrl = JenkinsLocationConfiguration.get().getUrl().replaceAll('/$', '')
println "Using controller URL: ${rootUrl}\n"

Jenkins.get().nodes.each { node ->
    if (node.displayName.contains(agentNameContains)) {
        println "Processing node: ${node.displayName}"
        
        // Generate agent link with URL encoding
        def encodedName = URLEncoder.encode(node.displayName, "UTF-8")
        def agentLink = "${rootUrl}/computer/${encodedName}/"
        agentLinks << agentLink
        
        // Label management
        def currentLabels = node.labelString.tokenize()
        println "Current labels: ${currentLabels}"
        
        if (!currentLabels.contains(labelToFind)) {
            currentLabels << labelToFind
            node.setLabelString(currentLabels.join(' '))
            node.save()
            println "Added label: ${labelToFind}"
        }
        
        println "----------------------"
    }
}

println "\nAgent Links:"
agentLinks.each { println it }
