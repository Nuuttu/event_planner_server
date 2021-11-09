package com.example.eventplanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.eventplanner.domain.*;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest
@SpringBootTest(properties = "spring.profiles.active=test")
public class UserRepoTest {

	@Autowired
	private UserRepository urepo;
	
    @Test
    public void testMe() {
        System.out.println("Hello World!");
    }
    
    @Test
    public void addUser() {
    	urepo.save(new User("uuser", "passwd", "USER"));
    	User u = urepo.findByUsername("uuser");
    	System.out.println("uuu");
    	assertThat(u.getUsername()).isEqualTo("uuser");
    }
}
