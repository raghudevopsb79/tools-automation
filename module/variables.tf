variable "name" {}
variable "instance_type" {}
variable "port_no" {}
variable "policy_actions" {}
variable "dummy_policy" {
  default = ["ec2:DescribeInstanceTypes"]
}

variable "volume_size" {}
variable "predefined_policies" {
  default = []
}

