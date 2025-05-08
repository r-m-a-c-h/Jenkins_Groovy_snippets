/////////////////////////////////////////////////////////////////
/// manage/scriptApproval                                     ///
/// List approved scripts                                     ///
/////////////////////////////////////////////////////////////////


/// Script Console

import jenkins.model.Jenkins
import org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval

def scriptApproval = ScriptApproval.get()
def approvedScripts = scriptApproval.getApprovedSignatures()

approvedScripts.each { signature ->
    println(signature)
}
