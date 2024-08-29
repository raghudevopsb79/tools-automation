module "tools" {
  for_each = var.tools
  source   = "./module"

  name                = each.value["name"]
  instance_type       = each.value["instance_type"]
  port_no             = each.value["port_no"]
  policy_actions      = each.value["policy_actions"]
  volume_size         = each.value["volume_size"]
  predefined_policies = each.value["predefined_policies"]
}
