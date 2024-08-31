import jenkins.model.Jenkins
import hudson.slaves.DumbSlave
import hudson.slaves.JNLPLauncher
import hudson.slaves.RetentionStrategy
import hudson.model.Node
import hudson.node_monitors.*

def nodeName          = "agent-node"
def nodeDescription   = "Common Agent Node"
def remoteFS          = "/jenkins"
def numExecutors     = 2
def labelString       = "agent"
def mode                     = Node.Mode.NORMAL
def launcher                 = new JNLPLauncher()
def retentionStrategy        = RetentionStrategy.Always.INSTANCE
def env                      = []

def diskSpaceThreshold = new DiskSpaceMonitorDescriptor.DiskSpace("/jenkins", 1024 * 1024 * 10)
if (Jenkins.instance.getNode(nodeName) == null) {
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
  agentNode.getNodeProperties().add(new NodePropertyDescriptor())
  agentNode.getNodeProperties().add(new DiskSpaceMonitorDescriptor(diskSpaceThreshold))
  Jenkins.instance.addNode(agentNode)
  println "Agent node '${nodeName}' with custom disk space monitoring has been added successfully."
} else {
  println "Node '${nodeName}' already exists. Skipping creation."
}
