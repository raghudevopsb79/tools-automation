import jenkins.model.*
import hudson.plugins.git.*
import hudson.plugins.git.extensions.*
import hudson.plugins.git.GitSCM
import hudson.plugins.git.UserRemoteConfig
import hudson.plugins.git.BranchSpec
import hudson.model.*
import org.jenkinsci.plugins.workflow.cps.*

def instance = Jenkins.getInstance()

def globalLib = new org.jenkinsci.plugins.workflow.libs.GlobalLibraries()

def sharedLib = new org.jenkinsci.plugins.workflow.libs.LibraryConfiguration(
    'roboshop',
    new hudson.plugins.git.GitSCM(
        [new UserRemoteConfig('https://github.com/raghudevops79/roboshop-jenkins.git', null, null, null)],
        [new BranchSpec('*/main')],
        new GitSCM.DescriptorImpl(),
        new hudson.plugins.git.extensions.impl.CleanBeforeCheckout(),
        new hudson.plugins.git.extensions.impl.LocalBranch('main'),
        null
    ),
    'roboshop@main'
)

// Add the library configuration to Jenkins
globalLib.libs = [sharedLib]
instance.getDescriptorByType(org.jenkinsci.plugins.workflow.libs.GlobalLibraries.DescriptorImpl).setGlobalLibraries(globalLib)

// Save the configuration
instance.save()
