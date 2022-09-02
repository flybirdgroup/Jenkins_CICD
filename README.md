# Jenkins_CICD
 Jenkins_CICD

#############################
## Install Jenkins
### Reference: https://www.cnblogs.com/fuzongle/p/12834080.html

docker run -d -p 10240:8080 -p 10241:50000 -v /Users/flybird/Desktop/ANSIBLE/Jenkins_CICD/jenkins_home:/var/jenkins_home -v /etc/localtime:/etc/localtime --name myjenkins jenkins/jenkins:lts

"""　　
-d 后台运行镜像

　　-p 10240:8080 将镜像的8080端口映射到服务器的10240端口。

　　-p 10241:50000 将镜像的50000端口映射到服务器的10241端口

　　-v /var/jenkins_mount:/var/jenkins_mount /var/jenkins_home目录为容器jenkins工作目录，我们将硬盘上的一个目录挂载到这个位置，方便后续更新镜像后继续使用原来的工作目录。这里我们设置的就是上面我们创建的 /var/jenkins_mount目录

　　-v /etc/localtime:/etc/localtime让容器使用和服务器同样的时间设置。

　　--name myjenkins 给容器起一个别名

"""

### Knowledge
1. check env variable: [url]http://127.0.0.1:10240/env-vars.html/

2. credential link to github: https://www.youtube.com/watch?v=HSA_mZoADSw

3. webhook + ngox: https://www.youtube.com/watch?v=odRxOMUZ6Ts