package parts.services;

public class DetailEditModel {
    private Integer id;
    private String name;
    private String count;
    private boolean required;

    public DetailEditModel() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCount() {
        return count;
    }

    public boolean isRequired() {
        return required;
    }
}
