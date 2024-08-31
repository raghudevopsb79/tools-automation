import jenkins.model.Jenkins
import hudson.slaves.DumbSlave
import hudson.slaves.JNLPLauncher
import hudson.slaves.RetentionStrategy
import hudson.model.Node

def nodeName = "agent-node"
def nodeDescription = "Agent Node"
def remoteFS = "/jenkins"
def numExecutors = 2
def labelString = "agent"
def mode = Node.Mode.NORMAL
def launcher = new JNLPLauncher()
def retentionStrategy = RetentionStrategy.Always.INSTANCE
def env = []

// Check if node already exists
if (Jenkins.instance.getNode(nodeName) == null) {
  // Create the agent node
  DumbSlave agentNode = new DumbSlave(
      nodeName,
      nodeDescription,
      remoteFS,
      numExecutors.toString(),
      mode,
      labelString,
      launcher,
      retentionStrategy,
      env
  )

  // Add the node to Jenkins
  Jenkins.instance.addNode(agentNode)
  println "Agent node '${nodeName}' has been added successfully."
} else {
  println "Node '${nodeName}' already exists. Skipping creation."
}
