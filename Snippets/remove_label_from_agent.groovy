/////////////////////////////////////////////////////////////////
/// Remove label from selected agents                         ///
/////////////////////////////////////////////////////////////////


/// Script Console

import jenkins.model.Jenkins

def labelToRemove = "old_label"
def agentNameContains = "Agent"

Jenkins.instance.nodes.each { node ->
    if (node.displayName.contains(agentNameContains)) {
        def labels = node.labelString.tokenize()
        if (labels.contains(labelToRemove)) {
            labels.removeAll { it == labelToRemove }
            node.setLabelString(labels.join(' '))
            node.save()
            println "Removed label '${labelToRemove}' from ${node.displayName}"
        }
    }
}
