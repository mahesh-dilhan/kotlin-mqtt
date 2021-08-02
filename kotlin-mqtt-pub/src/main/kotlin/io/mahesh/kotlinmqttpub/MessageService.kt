package io.mahesh.kotlinmqttpub

import org.eclipse.paho.client.mqttv3.MqttAsyncClient
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttMessage

class MessageService( private val topic: String, private val  broker: String) {

    fun publish(message: String) {
        val clientId = MqttAsyncClient.generateClientId()
        val client = MqttClient(broker, clientId)

        val options =  MqttConnectOptions()
        options.connectionTimeout=10
        options.isAutomaticReconnect= true
        options.isCleanSession =true

        client.connect(options)
        client.publish(topic, message.toByteArray(),2,false)
        client.disconnect()
    }
}