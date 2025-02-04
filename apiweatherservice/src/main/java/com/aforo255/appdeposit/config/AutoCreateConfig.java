package com.aforo255.appdeposit.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class AutoCreateConfig {

	@Value("${spring.kafka.template.default-topic}")
	String topicname;
	
	@Bean
	public NewTopic transactionEvent() {
		
		return TopicBuilder.name(topicname)
				.partitions(3)    
				.replicas(1)
				.build();
	}
	
}