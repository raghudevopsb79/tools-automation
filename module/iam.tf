resource "aws_iam_role" "main" {
  name = "${var.name}-role"

  assume_role_policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action = "sts:AssumeRole"
        Effect = "Allow"
        Sid    = ""
        Principal = {
          Service = "ec2.amazonaws.com"
        }
      },
    ]
  })

  inline_policy {
    name = "inline-policy"

    policy = jsonencode({
      Version = "2012-10-17"
      Statement = [
        {
          Action   = concat(var.dummy_policy, var.policy_actions)
          Effect   = "Allow"
          Resource = "*"
        },
      ]
    })
  }

  tags = {
    Name = "${var.name}-role"
  }
}


resource "aws_iam_instance_profile" "main" {
  name = "${var.name}-role"
  role = aws_iam_role.main.name
}

resource "aws_iam_role_policy_attachment" "predefined-policies" {
  count      = length(var.predefined_policies)
  role       = aws_iam_role.main.name
  policy_arn = "arn:aws:iam::aws:policy/${var.predefined_policies[count.index]}"
}


