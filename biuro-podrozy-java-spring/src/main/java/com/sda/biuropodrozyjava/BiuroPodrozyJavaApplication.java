package com.sda.biuropodrozyjava;

import com.sda.biuropodrozyjava.domain.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BiuroPodrozyJavaApplication implements CommandLineRunner {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public BiuroPodrozyJavaApplication(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(BiuroPodrozyJavaApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(bCryptPasswordEncoder.encode("123"));
    }
}
