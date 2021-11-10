package com.example.eventplanner;

import static org.assertj.core.api.Assertions.assertThat;

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
	@Autowired
	private CommentRepository crepo;
	@Autowired
	private EventRepository erepo;
	
    @Test
    public void testMe() {
        System.out.println("Hello Test!");
    }
    
    @Test
    public void addUser() {
    	urepo.save(new User("uuser", "passwd", "USER"));
    	User u = urepo.findByUsername("uuser");
    	assertThat(u.getUsername()).isEqualTo("uuser");
    }
    
    @Test
    public void saveUser() {
    	User uh = urepo.save(new User("uus", "pass", "USER"));
    	assertThat(uh.getId()).isNotNull();	
    }
    
    @Test
    public void addEventForUser() {
    	User ah = urepo.save(new User("aas", "pass", "USER"));
    	Event eh = erepo.save(new Event("Event for uh", "description", "2021-11-11T20:20", ah));
    	assertThat(eh.getOwner().getUsername()).isEqualTo(ah.getUsername());
    }
}
