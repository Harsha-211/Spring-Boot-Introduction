package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

}
class Coffee{
	private final String id;
	private String name;

	public Coffee(String id , String name){
		this.id = id;
		this.name = name;
	}
	public Coffee(String name){
		this(UUID.randomUUID().toString(),name);
	}
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public void setName(){
		this.name = name;
	}
}
