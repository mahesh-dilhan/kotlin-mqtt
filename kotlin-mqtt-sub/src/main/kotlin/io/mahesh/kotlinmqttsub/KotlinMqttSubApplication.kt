package io.mahesh.kotlinmqttsub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinMqttSubApplication

fun main(args: Array<String>) {
	runApplication<KotlinMqttSubApplication>(*args)

	subscribeUpstream()
}

fun subscribeUpstream() {
	val topic ="ds1"
	val broker = "tcp://127.0.0.1:1083"

	val ms = MessageService(topic, broker)
	ms.subscribe()
}

