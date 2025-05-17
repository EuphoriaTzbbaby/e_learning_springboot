#!/bin/bash

# 1. 本地构建 JAR 包
echo "Building Spring Boot project..."
mvn clean package -DskipTests

# 2. 上传 JAR 包到服务器
echo "Uploading JAR file to server..."
scp target/e_learning-0.0.1-SNAPSHOT.jar root@47.101.42.177:/var/www/html/springbootAndVue/e_learning

# 3. 登录到服务器并构建 Docker 镜像
echo "Building Docker image on server..."
ssh root@47.101.42.177 << EOF
  cd /var/www/html/springbootAndVue/e_learning
  docker build -t sb-e_learning .
  docker stop spring-e_learning || true
  docker rm spring-e_learning || true
  docker run -d --name spring-e_learning -p 9421:9421 --network blog sb-e_learning
EOF

echo "Spring Boot application deployed successfully!"
