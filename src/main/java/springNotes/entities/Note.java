package springNotes.entities;

import java.util.Date;

public class Note {
    private int id;
    private String Name;
    private String description;
    private Date createDate;
    private int Status;
    private User user;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getStatus() {
        return Status;
    }

    public User getUser() {
        return user;
    }
}
