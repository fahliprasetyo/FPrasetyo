import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer

Properties props = new Properties()
props.put('bootstrap.servers', 'localhost:9092')
props.put('group.id', 'katalon-consumer')
props.put('key.deserializer', StringDeserializer.class.getName())
props.put('value.deserializer', StringDeserializer.class.getName())
props.put('auto.offset.reset', 'earliest')

KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)
consumer.subscribe(Arrays.asList("test-topic"))

def records = consumer.poll(5000)

if(records.isEmpty()){
    KeywordUtil.markFailed("No message received from Kafka")
} else {
    records.each { r ->
        println("Received: ${r.value()}")
    }
}
consumer.close()
