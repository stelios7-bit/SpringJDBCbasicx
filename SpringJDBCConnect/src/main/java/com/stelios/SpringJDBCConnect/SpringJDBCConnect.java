package com.stelios.SpringJDBCConnect;

import com.stelios.SpringJDBCConnect.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJDBCConnect implements CommandLineRunner{

    @Autowired
    private StudentRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCConnect.class, args);
    }

    @Override
    public void run(String[] args) throws Exception {
        System.out.println("Sample students saved to database.");
    }
}
