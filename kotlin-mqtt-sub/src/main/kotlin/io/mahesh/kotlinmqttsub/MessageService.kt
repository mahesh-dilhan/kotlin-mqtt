package io.mahesh.kotlinmqttsub

class MessageService {
    fun subscribe() {
        val clientId = MqttAsyncClient.generateClientId()
        val client = MqttClient(broker, clientId)

        val options =  MqttConnectOptions()
        options.connectionTimeout=10
        options.isAutomaticReconnect= true
        options.isCleanSession =true

        client.connect(options)
    }

}