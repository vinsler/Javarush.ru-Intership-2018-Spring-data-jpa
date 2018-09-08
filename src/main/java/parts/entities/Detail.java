package parts.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean required;
    private int count;

    public Detail() {
    }

}
