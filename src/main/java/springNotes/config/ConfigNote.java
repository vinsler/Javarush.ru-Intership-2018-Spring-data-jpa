package springNotes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springNotes.entities.Note;
import springNotes.entities.User;

@Configuration
@ComponentScan("springNotes.entities")
public class ConfigNote {

    @Bean
    public Note getNote(User user){
        Note note = new Note();
        note.setId(90);
        return note;
    }
}