variable "tools" {
  default = {

    vault = {
      name          = "vault"
      instance_type = "t3.small"
      port_no = {
        vault = 8200
      }
      policy_actions      = []
      volume_size         = 20
      predefined_policies = []
    }

    github-runner = {
      name                = "github-runner"
      instance_type       = "t3.small"
      port_no             = {}
      policy_actions      = []
      volume_size         = 30
      predefined_policies = ["AdministratorAccess"]
    }

    jenkins = {
      name          = "jenkins"
      instance_type = "t3.small"
      port_no = {
        jenkins   = 8080
        jnlp-port = 50000
      }
      policy_actions      = []
      volume_size         = 20
      predefined_policies = []
    }

    jenkins-ci-agent = {
      name                = "jenkins-ci-agent"
      instance_type       = "t3.small"
      port_no             = {}
      policy_actions      = []
      volume_size         = 20
      predefined_policies = ["AmazonEC2ContainerRegistryFullAccess"]
    }

#     sonarqube = {
#       name          = "sonarqube"
#       instance_type = "t3.large"
#       port_no = {
#         jenkins   = 9000
#       }
#       policy_actions      = []
#       volume_size         = 20
#       predefined_policies = []
#     }

  }
}

