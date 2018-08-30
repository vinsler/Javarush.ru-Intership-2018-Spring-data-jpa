package springNotes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springNotes.entities.Note;
import springNotes.entities.User;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("ConfigNote");
        User user = context.getBean(User.class);
        Note note = context.getBean(Note.class);

        System.out.println(user.getName());
        System.out.println(note.getName());
    }
}