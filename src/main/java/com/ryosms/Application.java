package com.ryosms;

import com.ryosms.model.User;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.indices.CreateIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ryosms on 2016/08/11.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JestClient client;

    private static final String INDEX_NAME = "jest_test";

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Start!");

        client.execute(new CreateIndex.Builder(INDEX_NAME).build());

        String id = "ryosms";
        User user = User.builder()
                .id(id)
                .name("Ryo Sumasu")
                .email("test@example.com")
                .build();

        Index index = new Index.Builder(user)
                .index(INDEX_NAME)
                .type("users")
                .build();
        client.execute(index);
    }
}
