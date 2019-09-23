//package com.inertia.properties;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import zipkin2.storage.cassandra.CassandraStorage;
//
//import java.io.Serializable;
//
//@ConfigurationProperties("zipkin.storage.cassandra3")
//public class CassandraProperties implements Serializable {
//
//    private static final Logger LOG = LoggerFactory.getLogger(CassandraProperties.class);
//
//    private String keyspace;
//    private String contactPoints;
//    private boolean ensureSchema;
//    private boolean useSsl;
//    private String username;
//    private String password;
//
//    public String getKeyspace() {
//        return keyspace;
//    }
//
//    public void setKeyspace(String keyspace) {
//        this.keyspace = keyspace;
//    }
//
//    public String getContactPoints() {
//        return contactPoints;
//    }
//
//    public void setContactPoints(String contactPoints) {
//        this.contactPoints = contactPoints;
//    }
//
//    public boolean isEnsureSchema() {
//        return ensureSchema;
//    }
//
//    public void setEnsureSchema(boolean ensureSchema) {
//        this.ensureSchema = ensureSchema;
//    }
//
//    public boolean isUseSsl() {
//        return useSsl;
//    }
//
//    public void setUseSsl(boolean useSsl) {
//        this.useSsl = useSsl;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public CassandraStorage.Builder toBuilder() {
//        return CassandraStorage.newBuilder()
//                .keyspace(keyspace)
//                .contactPoints(contactPoints)
//                .useSsl(useSsl)
//                .username(username)
//                .password(password);
//    }
//}
