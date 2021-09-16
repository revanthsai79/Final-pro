provider "aws"{
  access_key = "AKIAZOWLFLKRNC6G5UDC"
  secret_key = "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"
  region = "ap-south-1"
}


variable "ingressrules" {
type = list(number)
default = [80,22]
}

variable "egressrules" {
type = list(number)
default = [80,443,25,3306,53,8080]
}

resource "aws_instance" "ec2" {
  ami = "ami-0a23ccb2cdd9286bb"
  instance_type = "t2.micro"
  security_groups = [aws_security_group.webtraffic.name]
}

resource "aws_security_group" "webtraffic" {
name = "Allow HTTPS2021"

dynamic "ingress"  {
 iterator           = port
 for_each           = var.ingressrules
 content {
 from_port          = port.value
 to_port            = port.value
 protocol           = "TCP"
 cidr_blocks        = ["0.0.0.0/0"]
  }
}