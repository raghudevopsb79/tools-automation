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

    minikube = {
      name          = "minikube"
      instance_type = "t3.medium"
      port_no = {
        kube = 8443
      }
      policy_actions = []
      volume_size    = 30
    }

  }
}

