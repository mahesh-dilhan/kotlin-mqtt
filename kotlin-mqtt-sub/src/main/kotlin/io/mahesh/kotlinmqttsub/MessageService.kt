package io.mahesh.kotlinmqttsub

import org.eclipse.paho.client.mqttv3.MqttAsyncClient
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions

class MessageService(private val topic: String, private val broker: String) {

    fun subscribe() {
        val clientId = MqttAsyncClient.generateClientId()
        val client = MqttClient(broker, clientId)

        val options =  MqttConnectOptions()
        options.connectionTimeout=10
        options.isAutomaticReconnect= true
        options.isCleanSession =true

        client.connect(options)
        client.subscribeWithResponse(topic) {
            _, msg -> sendNotification(String(msg.payload))
        }
    }

     fun sendNotification(msg: String) {
        println(msg)
    }

}