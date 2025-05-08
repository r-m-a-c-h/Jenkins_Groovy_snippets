/////////////////////////////////////////////////////////////////
/// manage/computer/                                          ///
/// List all agent details and free space                     ///
/////////////////////////////////////////////////////////////////


/// Script Console

jenkins.model.Jenkins.instance.computers.each { computer ->
    println "Agent: ${computer.displayName}"

    if (computer.isOnline()) {
        println "Status: Online"
        println "OS: ${computer.systemProperties['os.name']}"
        println "Architecture (Jenkins):  ${computer.systemProperties['os.arch']}"
        println "Architecture (OS):       ${"arch".execute().text}"
        println "Architecture (OS uname): ${"/usr/bin/uname -p".execute().text}"
        def rootPath = computer.getNode().getRootPath()
        if (rootPath != null) {
            println "Free Disk Space: ${Math.round(rootPath.getUsableDiskSpace() / (1024 * 1024 * 1024))} GB"
        } else {
            println "Free Disk Space: N/A"
        }
    } else {
        println "Status: Offline"
    }

    println "-------------------------"
}