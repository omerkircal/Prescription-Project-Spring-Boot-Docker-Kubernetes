#  **Prescription Project Spring Boot Docker Kubernetes**

------------

This project is a recipe simulation. In addition to CRUD processes, this project includes one to many relationship between prescription and raw materials.
MySQL is used as database. In addition, an image of the project was created with Docker and deployed with Kubernates. Besides, you can check Postman documentation for back-end service.

### DOCS
- [Languages, Technologies and Environments Used in this Project](#languages-technologies-and-environments-used-in-this-project)
- [Back-End Service](#back-end-service)
- [Import Postman Documentation](#import-postman-documentation)
- [Create Docker Image](#create-docker-image)
- [Deploy to Kubernetes](#deploy-to-kubernetes)

# Languages, Technologies and Environments Used in this Project

| Java  | MySQL | Spring Boot | Kubernates | Docker | Postman |
| :------------: | :------------: | :------------: | :------------: | :------------: | :------------: |
|  <img src ="https://cdn.iconscout.com/icon/free/png-256/java-60-1174953.png" width ="100px" height = "100px" style="float:left" > | <img src ="https://www.onurbabur.com/wp-content/uploads/2020/09/MySQL-Logo.wine_-2048x1365.png" width ="65px" height = "65px" style="float:left " >  |  <img src ="https://azpanel.azilen.com/uploads/everything_must_know_spring_boot_application_scratch_12_8c4e62d4fe.jpg" width ="65px" height = "65px" style="float:left " > | <img src ="https://kubernetes.io/images/favicon.png" width ="65px" height = "65px" >  | <img src ="https://ms-azuretools.gallerycdn.vsassets.io/extensions/ms-azuretools/vscode-docker/1.23.3/1671477542638/Microsoft.VisualStudio.Services.Icons.Default" width ="65px" height = "65px" >  | <img src ="https://mms.businesswire.com/media/20210818005151/en/761650/2/postman-logo-vert-2018.jpg" width ="65px" height = "65px" >  |

# Back-End Service

This service is built with Spring Boot. You can find the dependencies required for the project in the `pom.xml` file. 

In the project, there is one to many relationships between Prescription and Raw Materials.
```java
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prescription_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Prescription prescription;
```
While choosing the recipe type, a filtering process was performed by creating an enum value called PrescriptionType. In this way, entering an incorrect type is prevented.
```java
public enum PrescriptionType {
    TYPE_1,
    TYPE_2
}
```
In addition, the interface approach was also used in the project. Our service classes implement an interface.
```java
@Service
public class PrescriptionServiceImpl implements PrescriptionService
```

# Import Postman Documentation

Download Postman documentation for this project [from here](https://github.com/omerkircal/Prescription-Project-Spring-Boot-Docker-Kubernetes "from here") Its name is `PrescriptionProject.postman_collection.json`
Open Postman application. You will see `Import` button in your workspace. After click upload files and select the json file that you just download. 
Now, you should check this documentation.

# Create Docker Image

Firstly, create a Dockerfile at root of project.

Open terminal and write this code:
`docker build -t omerkircal/prescription:latest .`

|<img src="https://github.com/omerkircal/Prescription-Project-Spring-Boot-Docker-Kubernetes/blob/main/images/1.PNG" width="750">|

Now, image is created. To see, write `docker image ls` to terminal.

|<img src="https://github.com/omerkircal/Prescription-Project-Spring-Boot-Docker-Kubernetes/blob/main/images/2.PNG" width="750">|

We can run this image with first 3 digits of image id. To run, write `docker run a81` to terminal.

|<img src="https://github.com/omerkircal/Prescription-Project-Spring-Boot-Docker-Kubernetes/blob/main/images/3.PNG" width="750">|

Create a repository in [DockerHub](https://hub.docker.com/ "DockerHub")  and push the image that just created to this repository with this command:
```java
docker push omerkircal/prescription:latest
```
Repository is created.

|<img src="https://github.com/omerkircal/Prescription-Project-Spring-Boot-Docker-Kubernetes/blob/main/images/4.PNG" width="750">|


To use, you can write this to terminal:
```java
docker run omerkircal/prescription:latest
```

# Deploy to Kubernetes
Firstly, create a deployment.yaml at root of project.

Open termineal and write this:
```java
kubectl apply -f deployment.yaml
```
**Note**: ensure that minikube is running before executing the command above. Start minikube by executing the command minikube start.

|<img src="https://github.com/omerkircal/Prescription-Project-Spring-Boot-Docker-Kubernetes/blob/main/images/5.PNG" width="750">|

Check on the Kubernetes dashboard that the deployment is running with no errors. Start the Kubernetes dashboard by executing the command `minikube enable` 

Application is now running successfully in the Kubernetes cluster.

|<img src="https://github.com/omerkircal/Prescription-Project-Spring-Boot-Docker-Kubernetes/blob/main/images/7.PNG" width="750">|
