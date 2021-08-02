package io.mahesh.kotlinmqttsub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinMqttSubApplication

fun main(args: Array<String>) {
	runApplication<KotlinMqttSubApplication>(*args)
}
