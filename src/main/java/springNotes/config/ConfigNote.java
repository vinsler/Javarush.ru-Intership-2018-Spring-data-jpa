package springNotes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springNotes.entities.Note;
import springNotes.entities.User;

@Configuration
@ComponentScan
public class ConfigNote {

    @Bean
    public Note getNote(){
        return new Note();
    }

    @Bean
    public User getUser(){
        return new User();
    }
}