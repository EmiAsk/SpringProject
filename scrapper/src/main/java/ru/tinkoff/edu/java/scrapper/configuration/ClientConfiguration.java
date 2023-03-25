package ru.tinkoff.edu.java.scrapper.configuration;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.scrapper.client.Client;
import ru.tinkoff.edu.java.scrapper.client.GitHubClient;
import ru.tinkoff.edu.java.scrapper.client.StackOverflowClient;

@Configuration
@RequiredArgsConstructor
public class ClientConfiguration {
    private final GitHubConfiguration gitHubConfiguration;
    private final StackOverflowConfiguration stackOverflowConfiguration;

    @Bean
    public Client gitHubClient() {
        // Тут если в конфиг файле не указан baseUrl, тогда устанавливается значение по дефолту
        // (в общем не противоречит заданию)
        return GitHubClient.fromConfig(gitHubConfiguration);

    }

    @Bean
    public Client stackOverflowClient() {
        // Тут если в конфиг файле не указан baseUrl, тогда устанавливается значение по дефолту
        // (в общем не противоречит заданию)
        return StackOverflowClient.fromConfig(stackOverflowConfiguration);
    }

    @Bean
    public long linkUpdateSchedulerIntervalMs(ApplicationConfig config) {
        return config.scheduler().interval().toMillis();
    }
}
