package parts.entities;

import org.springframework.stereotype.Component;
import javax.persistence.*;

@Component
@Entity
@Table(name = "detail")
public class Detail {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "required")
    private boolean required;

    @Column (name = "count")
    private int count;

    public Detail() {
    }
}
