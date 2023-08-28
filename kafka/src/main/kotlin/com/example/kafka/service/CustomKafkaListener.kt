package com.example.kafka.service

@Configuration
class CustomKafkaListener(
    @Value("\${spring.kafka.bootstrap-servers}")
    val server: String,
    @Value("\${spring.consumer.group-id}")
    val groupId: String
) {

    private fun consumerProperties(): MutableMap<String, Any> {
        val configs = mutableMapOf<String, Any>()
        configs[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = server
        configs[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class
        configs[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class
        configs[ConsumerConfig.GROUP_ID_CONFIG] = groupId
        return configs
    }

    @Bean
    fun messageListenerContainer(): KafkaMessageListenerContainer<String, String> {
        val containerProperties: ContainerProperties = ContainerProperties("test");
        containerProperties.messageListener = MyMessageListener()

        val consumerFactory: ConsumerFactory<String, String> =
            DefaultKafkaConsumerFactory(consumerProperties())

        val listenerContainer: KafkaMessageListenerContainer<String, String> =
            KafkaMessageListenerContainer(consumerFactory, containerProperties)

        listenerContainer.isAutoStartup = false
        listenerContainer.setBeanName("kafka-message-listener")
        return listenerContainer
    }

    class MyMessageListener : MessageListener<String, String> {
        private val logger = KotlinLogging.logger {}
        override fun onMessage(data: ConsumerRecord<String, String>) {
            logger.info { "MyMessageListener : ${data.value()}" }
        }
    }
}