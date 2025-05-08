////////////////////////////////////////////////////////////////////
/// Delete failed and aborted jobs of selected pipeline in range ///
////////////////////////////////////////////////////////////////////


/// Script Console

import hudson.model.Job
import hudson.model.Run

def jobName = 'Initial'
def minBuildNumber = 0
def maxBuildNumber = 5

def job = Jenkins.get().getItemByFullName(jobName)

if (!job) {
    println "Job ${jobName} not found!"
    return
}

println "Processing ${job.fullName} (builds ${minBuildNumber}-${maxBuildNumber})"

job.builds.each { build ->
    try {
        if (build.number > minBuildNumber && build.number < maxBuildNumber) {
            switch(build.result) {
                case hudson.model.Result.FAILURE:
                    println "Deleting FAILED build #${build.number}"
                    build.delete()
                    break
                case hudson.model.Result.ABORTED:
                    println "Deleting ABORTED build #${build.number}"
                    build.delete()
                    break
                case hudson.model.Result.SUCCESS:
                    println "Keeping SUCCESS build #${build.number}"
                    break
                default:
                    println "Unknown status for build #${build.number}: ${build.result}"
            }
        }
    } catch(Exception e) {
        println "Failed to process build #${build.number}: ${e.message}"
    }
}

println "Cleanup completed for ${job.fullName}"
