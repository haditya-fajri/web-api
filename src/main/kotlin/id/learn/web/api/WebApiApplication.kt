package id.learn.web.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebApiApplication

fun main(args: Array<String>) {
	runApplication<WebApiApplication>(*args)
}
