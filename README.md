# Jenkins_CICD
 Jenkins_CICD

#############################
## Install Jenkins
### Reference: https://www.cnblogs.com/fuzongle/p/12834080.html

docker run -d -p 10240:8080 -p 10241:50000 -v /Users/flybird/Desktop/ANSIBLE/Jenkins_CICD/jenkins_home:/var/jenkins_home -v /etc/localtime:/etc/localtime --name myjenkins jenkins/jenkins:lts

docker run \
  -p 8080:8080 \
  -p 50000:50000 \
  -v /Users/flybird/Desktop/ANSIBLE/Jenkins_CICD/jenkins_home:/var/jenkins_home \
jenkins/jenkins