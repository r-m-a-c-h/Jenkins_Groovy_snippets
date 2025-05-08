/////////////////////////////////////////////////////////////////
/// manage/securityRealm/                                     ///
/// List security configurations                              ///
/////////////////////////////////////////////////////////////////


/// Script Console

import jenkins.model.Jenkins
import hudson.security.SecurityRealm

def securityRealm = Jenkins.instance.getSecurityRealm()

println("Security Realm Class: " + securityRealm.getClass().getName())
println("Security Realm Description: " + securityRealm.getDescriptor().getDisplayName())

// If the security realm supports user sign-up
if (securityRealm.hasProperty('allowsSignup')) {
    println("Allows Signup: " + securityRealm.allowsSignup())
}

// If the security realm supports group membership
if (securityRealm.hasProperty('getGroupMembership')) {
    println("Group Membership: " + securityRealm.getGroupMembership())
}

// If the security realm supports user authentication
if (securityRealm.hasProperty('authenticate')) {
    println("Authentication Method: " + securityRealm.authenticate())
}

// Additional properties can be added based on the specific security realm implementation
println("-----")

import hudson.model.User

def users = User.getAll()

for (user in users) {
    println("ID: " + user.id)
    println("Full Name: " + user.fullName)
    println("Email: " + user.getProperty(hudson.tasks.Mailer.UserProperty)?.address)
    println("Description: " + user.description)
    println("-----")
}
