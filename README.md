# Jenkins_CICD
 Jenkins_CICD

#############################
## Install Jenkins
docker run \
  -u root \
  --rm \
  -d \
  -p 8080:8080 \
  -p 50000:50000 \
  -v /Users/flybird/Desktop/ANSIBLE/Jenkins_CICD/jenkins_home:/var/jenkins_home \
jenkins/jenkins:lts