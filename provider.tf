terraform {
  backend "s3" {
    bucket = "d79-terraform"
    key    = "tools/terraform.tfstate"
    region = "us-east-1"
  }
}
