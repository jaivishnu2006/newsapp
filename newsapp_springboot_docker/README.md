# Spring Boot News Application

A simple Java Spring Boot application that retrieves Indian top headlines from NewsAPI.org.

## Requirements
- Java 21
- Maven
- A NewsAPI key from https://newsapi.org/
- Docker Desktop (for container steps)

## Run locally

### Windows PowerShell
```powershell
$env:NEWS_API_KEY="YOUR_API_KEY"
.\mvnw.cmd spring-boot:run
```

If the Maven wrapper is not present, use:
```powershell
mvn spring-boot:run
```

Open:
- http://localhost:8080/
- http://localhost:8080/news

## Build JAR
```powershell
mvn clean package
```

## Docker
Build the JAR first:
```powershell
mvn clean package
docker build -t newsapp:v1 .
```

Run the container:
```powershell
docker run -d -p 8080:8080 -e NEWS_API_KEY=YOUR_API_KEY --name news-container newsapp:v1
```

View logs and stop:
```powershell
docker logs news-container
docker stop news-container
```

## Push source to GitHub
Create an empty repository named `newsapp` on GitHub, then run from this folder:
```powershell
git init
git add .
git commit -m "Create Spring Boot news application"
git branch -M main
git remote add origin https://github.com/jaivishnu2006/newsapp.git
git push -u origin main
```
Change the remote URL if your repository has a different name or username.

## Push Docker image to Docker Hub
```powershell
docker login
docker tag newsapp:v1 YOUR_DOCKERHUB_USERNAME/newsapp:v1
docker push YOUR_DOCKERHUB_USERNAME/newsapp:v1
```

Replace placeholders with your own credentials. Never commit your API key to GitHub.
