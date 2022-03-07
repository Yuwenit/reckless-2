# 小破爛一號
小小圖片上傳 :rofl: 更新中.....當有進步的時候:sweat_smile:

## •專案參考資料
https://codebun.com/spring-boot-upload-and-download-file-example-using-thymeleaf/ <br> 
-關鍵字: spring boot/thymeleaf/ mysql/ blob <br> 
-不使用lombok 套件，手動建立DAO Bean

## •環境&建置步驟
### Eclipes 2020-06 
-File >> Spring Starter Project <br> 
-Spring Boot Version 2.6.3<br> 
-Java Version 8 / 1.8 (這個要問土豆班長我也不知道)<br> 
-Maven project 與 jar package<br> 
-套件選擇 Thymeleaf / spring data JPA / Spring webP / devtool / mysql<br> 
-Pom.xml 版本與Dependencies全文如下<br> 
JDBC為什麼不用也要問一下<br> 
> 
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

### •MYSQL 8.0.25
-建立資料庫並且使用 SQL碼如下 <br> 
create database reckless01;<br> 
use reckless01;<br> 
-mysql 版本確認>> mysql登入後執行這行<br> 
select version();

### •回到Eclipes 2020-06 拉專案並進行設定
-application.properties<br> 
-資料庫名稱與使用者帳密更動為自己的<br> 
spring.datasource.url = jdbc:mysql://localhost:3306/reckless01?useSSL=false&serverTimezone=UTC<br> 
spring.datasource.username = xxx<br> 
spring.datasource.password = xxx<br> 

### •跑專案 Run as Java application
-Table >> Table Name (reckless01)右鍵 >> Alter Table<br> 
-Column Name (content) >> MEDIUMBLOB<br> 

應該就可以跑了這樣
