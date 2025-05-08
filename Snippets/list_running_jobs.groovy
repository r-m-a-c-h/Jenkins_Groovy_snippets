/////////////////////////////////////////////////////////////////
/// List running jobs                                         ///
/////////////////////////////////////////////////////////////////


/// Script Console

import jenkins.model.Jenkins
import hudson.model.Job

def isAnyJobBuilding(job) {
    if (job instanceof com.cloudbees.hudson.plugins.folder.Folder) {
        return job.getItems().any { isAnyJobBuilding(it) }
    } else if (job instanceof Job) {
        return job.isBuilding()
    }
    return false
}

def jobs = Jenkins.instance.getAllItems(Job)

// Check if any job is currently building
def runningJobs = jobs.findAll { job ->
    isAnyJobBuilding(job)
}

if (runningJobs.isEmpty()) {
    println "No pipelines are currently running."
} else {
    println "The following pipelines are currently running:"
    runningJobs.each { job ->
        println "- ${job.fullDisplayName}"
    }
}
