//package net.storyshelf.ms_books;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
//import java.time.Duration;
//
//@Configuration
//@Slf4j
//@EnableElasticsearchRepositories(basePackages = "net.storyshelf.ms_books")
//public class ElasticsearchConfig extends ElasticsearchConfiguration {
//
//    @Override
//    public ClientConfiguration clientConfiguration() {
//        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("localhost:9200")
//                .usingSsl()
//                .withConnectTimeout(Duration.ofSeconds(5))
//                .withSocketTimeout(Duration.ofSeconds(3))
//                .withBasicAuth("elastic", "Cl-VsmbjTg2fLLnSrpR2")
//                .build();
//        return clientConfiguration;
//    }
//}