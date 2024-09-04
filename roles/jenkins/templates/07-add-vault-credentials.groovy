import jenkins.model.Jenkins
import com.cloudbees.plugins.credentials.domains.Domain
import org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl
import com.cloudbees.plugins.credentials.CredentialsScope
import hudson.util.Secret
import com.cloudbees.plugins.credentials.CredentialsProvider
import com.cloudbees.plugins.credentials.SystemCredentialsProvider

// Get the Jenkins instance
def instance = Jenkins.instance

// Define the global domain
def domain = Domain.global()

// Create secret text credentials (Vault token)
def vaultToken = new StringCredentialsImpl(
    CredentialsScope.GLOBAL,
    'vault-token', // Unique ID for the credential
    'vault-token', // Description
    Secret.fromString('{{ vault_token }}') // Vault token
)

// Add the credentials to the store
def store = SystemCredentialsProvider.getInstance().getStore()
store.addCredentials(domain, vaultToken)

// Save the Jenkins instance
instance.save()