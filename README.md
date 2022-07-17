
# Azure-Functions-Spring-Boot
Sample Hello API with Request and Response handled by Spring Boot in Azure Cloud functions Java with an example Database Operation. For Authentication, Firebase (Google Cloud Platform) is used.

## Firebase Authentication
Get Service Account Json file by following [this link](https://firebase.google.com/docs/admin/setup). Paste the file in resource folder and name it as "service-account.json"

## Application Property File
```
spring.datasource.url=jdbc:sqlserver://{database_url}:{port};database={database_name};user={user_name};password={password};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```
