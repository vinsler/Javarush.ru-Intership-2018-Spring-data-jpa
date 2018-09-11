package parts.entities;

// Создали сущность, через персистенс, сделали пустой конструктор, геттеры/сеттеры.

import javax.persistence.*;

@Entity
@Table(name = "detail")
public class Detail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "name")
    private String name;

    @Column (name = "required")
    private boolean required;

    @Column (name = "count")
    private int count;

    public Detail() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isRequired() {
        return required;
    }

    public int getCount() {
        return count;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
