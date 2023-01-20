provider "aws" {
  access_key= var.aws_access_key
  secert_key= var.aws_secret_key
  region = "us-west-2"
}

resource "aws_vpc" "srinathvpc" {
  cidr_block = "10.0.0.0/16"

  tags = {
    Name = "srinathvpc"
  }
}

resource "aws_internet_gateway" "srinathigw" {
  vpc_id = aws_vpc.srinathvpc.id

  tags = {
    Name = "srinathigw"
  }
}

resource "aws_subnet" "private_a" {
  vpc_id                  = aws_vpc.srinathvpc.id
  cidr_block              = "10.0.1.0/24"
  availability_zone       = "us-west-2a"
  map_public_ip_on_launch = false

  tags = {
    Name = "srinathvpc-private-subnet-a"
  }
}

resource "aws_subnet" "private_b" {
  vpc_id                  = aws_vpc.srinathvpc.id
  cidr_block              = "10.0.2.0/24"
  availability_zone       = "us-west-2b"
  map_public_ip_on_launch = false

  tags = {
    Name = "srinathvpc-private-subnet-b"
  }
}

resource "aws_subnet" "public_a" {
  vpc_id                  = aws_vpc.srinathvpc.id
  cidr_block              = "10.0.3.0/24"
  availability_zone       = "us-west-2a"
  map_public_ip_on_launch = true

  tags = {
    Name = "srinathvpc-public-subnet-a"
  }
}

resource "aws_subnet" "public_b" {
  vpc_id                  = aws_vpc.srinathvpc.id
  cidr_block              = "10.0.4.0/24"
  availability_zone       = "us-west-2b"
  map_public_ip_on_launch = true

  tags = {
    Name = "srinathvpc-public-subnet-b"
  }
}

resource "aws_security_group" "srinathvpcsg" {
  name        = "srinathvpcsg"
  description = "srinathvpcsg security group"
  vpc_id      = aws_vpc.example.id

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

