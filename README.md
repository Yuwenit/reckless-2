# 小破爛一號

圖片上傳 :rofl: 更新中.....當有進步的時候:sweat_smile:

## •專案參考資料

"https://codebun.com/spring-boot-upload-and-download-file-example-using-thymeleaf/"

- 關鍵字: spring boot/thymeleaf/ mysql/ blob 
- 檔案上傳方法說明:不使用lombok 套件，手動建立DAO Bean，blob方式儲存檔案
  
## •環境&建置步驟

### Eclipes 2020-06 

- File >> Spring Starter Project  
- Spring Boot Version 2.6.3  
- Java Version 8 / 1.8
- Maven project 與 jar package  
- 套件選擇 Thymeleaf / spring data JPA / Spring webP / devtool / mysql  
- Pom.xml 版本與Dependencies全如下 

```text
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.6.3</version>
		<relativePath/> 
	</parent>
	
	<properties>
		<java.version>1.8</java.version>
	</properties>
	
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
```

### •MYSQL 8.0.25
- 建立資料庫並且使用 SQL碼如下  
	create database reckless01;  
	use reckless01;
- mysql 版本確認>> mysql登入後執行這行  
	select version();

### •回到Eclipes 2020-06 拉專案並進行設定

- application.properties<br> 
- 資料庫名稱與使用者帳密更動為自己的  
  spring.datasource.url = jdbc:mysql://localhost:3306/reckless01?useSSL=false&serverTimezone=UTC  
  spring.datasource.username = xxx  
  spring.datasource.password = xxx  
 
### •跑專案 Run as Java application

- Table >> Table Name (reckless01)右鍵 >> Alter Table  
- Column Name (content) >> MEDIUMBLOB

### •套版使用 Bootstrap 5 ，導入bundle

- 帶入自行可以使用版本的Bootstrap CDN & JQ &JS
