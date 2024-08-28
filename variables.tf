variable "tools" {
  default = {

    vault = {
      name          = "vault"
      instance_type = "t3.small"
      port_no = {
        vault = 8200
      }
      policy_actions = []
      volume_size    = 20
    }

    github-runner = {
      name          = "github-runner"
      instance_type = "t3.small"
      port_no = {}
      policy_actions = []
      volume_size    = 20
    }

  }
}

