package springNotes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springNotes.entities.Note;
import springNotes.entities.User;

public class Main {
    public static void main(String[] args) {
        ApplicationContext contextUser = new AnnotationConfigApplicationContext("springNotes");
        User user = contextUser.getBean(User.class);

        ApplicationContext contextNote = new AnnotationConfigApplicationContext("config.class");
        Note note = contextNote.getBean(Note.class);

        System.out.println(user.getId());
        System.out.println(note.getId());
    }
}