/////////////////////////////////////////////////////////////////
/// manage/systemInfo                                         ///
/// List system informations                                  ///
/////////////////////////////////////////////////////////////////


/// Script Console

import jenkins.model.Jenkins

def systemInfo = System.getProperties()
systemInfo.each { key, value ->
    println("${key}: ${value}")
}
