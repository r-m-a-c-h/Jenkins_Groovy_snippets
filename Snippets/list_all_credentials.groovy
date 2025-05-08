/////////////////////////////////////////////////////////////////
/// manage/credentials/                                       ///
/// List all credential details                               ///
/////////////////////////////////////////////////////////////////


/// Script Console

import com.cloudbees.plugins.credentials.CredentialsProvider
import com.cloudbees.plugins.credentials.Credentials
import java.nio.charset.StandardCharsets

def creds = CredentialsProvider.lookupCredentials(Credentials.class, Jenkins.instance, null, null)

for (c in creds) {
    println("ID: " + c.id)
    println("Description: " + c.description)
    if (c.hasProperty('username')) {
        println("Username: " + c.username)
    }
    if (c.hasProperty('password')) {
        println("Password: " + c.password?.getPlainText())
    }
    if (c.hasProperty('passphrase')) {
        println("Passphrase: " + c.passphrase?.getPlainText())
    }
    if (c.hasProperty('privateKeySource')) {
        println("Private Key: " + c.privateKeySource?.getPrivateKey()?.getPlainText())
    }
    if (c.hasProperty('secret')) {
        println("Secret: " + c.secret?.getPlainText())
    }
    if (c.hasProperty('secretBytes')) {
        println("Secret Bytes: " + new String(c.secretBytes.getPlainData(), StandardCharsets.UTF_8))
    }
    if (c.hasProperty('apiToken')) {
        println("API Token: " + c.apiToken)
    }
    if (c.hasProperty('token')) {
        println("Token: " + c.token)
    }
    if (c.hasProperty('subscriptionId')) {
        println("Subscription ID: " + c.subscriptionId)
    }
    if (c.hasProperty('clientId')) {
        println("Client ID: " + c.clientId)
    }
    if (c.hasProperty('tenant')) {
        println("Tenant: " + c.tenant)
    }
    println("-----")
}