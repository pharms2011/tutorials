package com.inertia.config;

import com.inertia.properties.ZipkinCassandraProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.storage.StorageComponent;
import zipkin2.storage.cassandra.CassandraStorage;

@Configuration
@EnableConfigurationProperties(ZipkinCassandraProperties.class)
@ConditionalOnProperty(name = "zipkin.storage.type", havingValue = "cassandra3")
@ConditionalOnMissingBean(StorageComponent.class)
public class CassandraConfig {

    private static final Logger LOG = LoggerFactory.getLogger(CassandraConfig.class);

    @Bean
    StorageComponent storage(
            ZipkinCassandraProperties properties,
            @Value("${zipkin.storage.strict-trace-id:true}") boolean strictTraceId,
            ObjectProvider<CassandraStorage.SessionFactory> tracingSessionFactory
    ){
        LOG.info("Setting Cassandra Connection Factory parameters");
        CassandraStorage.Builder builder = properties.toBulider().strictTraceId(strictTraceId);
        return tracingSessionFactory.getIfAvailable() == null
                ? builder.build()
                : builder.sessionFactory(tracingSessionFactory.getIfAvailable()).build();
    }

}
