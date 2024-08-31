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
      volume_size         = 20
      predefined_policies = ["AdministratorAccess"]
    }

    jenkins-server = {
      name                = "jenkins-server"
      instance_type       = "t3.small"
      port_no             = {}
      policy_actions      = []
      volume_size         = 20
      predefined_policies = []
    }

    jenkins-ci-agent = {
      name                = "jenkins-ci-agent"
      instance_type       = "t3.small"
      port_no             = {}
      policy_actions      = []
      volume_size         = 30
      predefined_policies = []
    }

  }
}

