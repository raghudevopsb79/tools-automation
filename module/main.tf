resource "aws_security_group" "main" {
  name        = var.name
  description = var.name

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  dynamic "ingress" {
    for_each = var.port_no
    content {
      from_port   = ingress.value
      to_port     = ingress.value
      protocol    = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
      description = ingress.key
    }
  }

  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
    ipv6_cidr_blocks = ["::/0"]
  }
}

resource "aws_instance" "main" {
  ami                    = data.aws_ami.ami.image_id
  instance_type          = var.instance_type
  vpc_security_group_ids = [aws_security_group.main.id]
  iam_instance_profile   = aws_iam_instance_profile.main.name

  instance_market_options {
    market_type = "spot"
    spot_options {
      instance_interruption_behavior = "stop"
      spot_instance_type             = "persistent"
    }
  }

  root_block_device {
    volume_size = var.volume_size
  }

  tags = {
    Name = var.name
  }
}

resource "aws_route53_record" "main" {
  zone_id = data.aws_route53_zone.main.zone_id
  name    = "${var.name}.rdevopsb79.online"
  type    = "A"
  ttl     = 5
  records = [aws_instance.main.public_ip]
}

resource "aws_route53_record" "private" {
  zone_id = data.aws_route53_zone.main.zone_id
  name    = "${var.name}-internal.rdevopsb79.online"
  type    = "A"
  ttl     = 5
  records = [aws_instance.main.private_ip]
}


