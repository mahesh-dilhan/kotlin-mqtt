package io.mahesh.kotlinmqttpub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinMqttPubApplication

fun main(args: Array<String>) {
	runApplication<KotlinMqttPubApplication>(*args)

	notifyDownStream()
}

fun notifyDownStream() {
	val topic ="ds1"
	val broker = "tcp://127.0.0.1:1083"

	val ms = MessageService(topic, broker)
	ms.publish("This is upstream... seq.")
}
