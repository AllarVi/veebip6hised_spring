package main.groovy.me.rannarallorg

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration

@SpringBootApplication
class Lab2GroovyApplication extends WebMvcAutoConfiguration {

	static void main(String[] args) {
		SpringApplication.run Lab2GroovyApplication, args
	}
}
