import jenkins.model.Jenkins

// Define the fixed port you want to set for inbound agents
int fixedPort = 50000 // Change this to your desired port number

// Access the Jenkins instance
Jenkins jenkins = Jenkins.getInstanceOrNull()

if (jenkins != null) {
  // Set the fixed TCP port for inbound agents
  jenkins.setSlaveAgentPort(fixedPort)

  // Save the configuration to persist the change
  jenkins.save()

  println "TCP port for inbound agents set to: ${fixedPort}"
} else {
  println "Jenkins instance is not available."
}
