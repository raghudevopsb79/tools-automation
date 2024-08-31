import jenkins.model.*
import hudson.model.*
import jenkins.model.Jenkins
import hudson.PluginWrapper

def pluginsToInstall = [
    'ionicons-api',
    'cloudbees-folder',
    'antisamy-markup-formatter',
    'asm-api',
    'json-path-api',
    'structs',
    'workflow-step-api',
    'token-macro',
    'build-timeout',
    'bouncycastle-api',
    'credentials',
    'plain-credentials',
    'variant',
    'ssh-credentials',
    'credentials-binding',
    'scm-api',
    'workflow-api',
    'commons-lang3-api',
    'timestamper',
    'caffeine-api',
    'script-security',
    'javax-activation-api',
    'jaxb',
    'snakeyaml-api',
    'json-api',
    'jackson2-api',
    'commons-text-api',
    'workflow-support',
    'plugin-util-api',
    'font-awesome-api',
    'bootstrap5-api',
    'jquery3-api',
    'echarts-api',
    'display-url-api',
    'checks-api',
    'junit',
    'matrix-project',
    'resource-disposer',
    'ws-cleanup',
    'ant',
    'okhttp-api',
    'durable-task',
    'workflow-durable-task-step',
    'workflow-scm-step',
    'workflow-cps',
    'workflow-job',
    'jakarta-activation-api',
    'jakarta-mail-api',
    'apache-httpcomponents-client-4-api',
    'instance-identity',
    'mailer',
    'workflow-basic-steps',
    'gradle',
    'pipeline-milestone-step',
    'pipeline-build-step',
    'pipeline-groovy-lib',
    'pipeline-stage-step',
    'joda-time-api',
    'pipeline-model-api',
    'pipeline-model-extensions',
    'branch-api',
    'workflow-multibranch',
    'pipeline-stage-tags-metadata',
    'pipeline-input-step',
    'pipeline-model-definition',
    'workflow-aggregator',
    'jjwt-api',
    'github-api',
    'mina-sshd-api-common',
    'mina-sshd-api-core',
    'gson-api',
    'git-client',
    'git',
    'github',
    'github-branch-source',
    'pipeline-github-lib',
    'pipeline-graph-analysis',
    'metrics',
    'pipeline-graph-view',
    'eddsa-api',
    'trilead-api',
    'ssh-slaves',
    'matrix-auth',
    'pam-auth',
    'ldap',
    'email-ext',
    'theme-manager',
    'dark-theme'
]

def pluginManager = Jenkins.instance.pluginManager
def updateCenter = Jenkins.instance.updateCenter

def installPlugins(pluginList) {
  pluginList.each { pluginName ->
    if (pluginManager.getPlugin(pluginName) == null) {
      println "Installing plugin: ${pluginName}"
      def plugin = updateCenter.getPlugin(pluginName)
      if (plugin) {
        plugin.deploy(true)
        println "Successfully installed ${pluginName}."
      } else {
        println "Plugin ${pluginName} not found in the Update Center."
      }
    } else {
      println "Plugin ${pluginName} is already installed."
    }
  }
}

installPlugins(pluginsToInstall)

