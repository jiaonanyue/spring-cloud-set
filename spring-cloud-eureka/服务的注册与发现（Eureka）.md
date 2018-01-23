**SpringCloud组件Eureka**

服务的注册与发现类似zk

创建spring-cloud-eureka项目
创建步骤：打开idea->File->new->project->spring Initializr->next->填写Group，Artifact->next->选择cloud discovery->eureka server ->next->修改或者不修改项目目录地址->Finish


整体pom.xml

		<?xml version="1.0" encoding="UTF-8"?>
		<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
			<modelVersion>4.0.0</modelVersion>
		
			<groupId>org.spring.cloud</groupId>
			<artifactId>spring-cloud-eureka</artifactId>
			<version>0.0.1-SNAPSHOT</version>
			<packaging>jar</packaging>
		
			<name>spring-cloud-eureka</name>
			<description>Demo project for Spring Boot</description>
		
			<parent>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-parent</artifactId>
				<version>1.5.9.RELEASE</version>
				<relativePath/> <!-- lookup parent from repository -->
			</parent>
		
			<properties>
				<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
				<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
				<java.version>1.8</java.version>
				<spring-cloud.version>Edgware.RELEASE</spring-cloud.version>
			</properties>
		
			<dependencies>
				<dependency>
					<groupId>org.springframework.cloud</groupId>
					<artifactId>spring-cloud-starter-eureka-server</artifactId>
				</dependency>
		
				<dependency>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-test</artifactId>
					<scope>test</scope>
				</dependency>
			</dependencies>
		
			<dependencyManagement>
				<dependencies>
					<dependency>
						<groupId>org.springframework.cloud</groupId>
						<artifactId>spring-cloud-dependencies</artifactId>
						<version>${spring-cloud.version}</version>
						<type>pom</type>
						<scope>import</scope>
					</dependency>
				</dependencies>
			</dependencyManagement>
		
			<build>
				<plugins>
					<plugin>
						<groupId>org.springframework.boot</groupId>
						<artifactId>spring-boot-maven-plugin</artifactId>
					</plugin>
				</plugins>
			</build>
		
		
		</project>


在启动类上加上EnableEurekaServer注解  注入EurekaServer

		package org.spring.cloud;
		
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
		
		@SpringBootApplication
		@EnableEurekaServer
		public class SpringCloudEurekaApplication {
		
			public static void main(String[] args) {
				SpringApplication.run(SpringCloudEurekaApplication.class, args);
			}
		}


配置application.properties 
eureka是一个高可用的组件，它没有后端缓存，每一个实例注册之后需要向注册中心发送心跳（因此可以在内存中完成），在默认情况下erureka server也是一个eureka client ,必须要指定一个 server。

通过eureka.client.registerWithEureka：false和fetchRegistry：false来表明自己是一个eureka server.

		server.port=8761
		eureka.instance.hostname=localhost
		eureka.client.register-with-eureka=false
		eureka.client.fetch-registry=false
		eureka.client.service-url.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/


启动服务。访问地址：http://localhost:8761/

简单的注册中心就完成了。