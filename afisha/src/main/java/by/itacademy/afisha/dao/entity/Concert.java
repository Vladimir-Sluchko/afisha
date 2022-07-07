package by.itacademy.afisha.dao.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "event",schema = "afisha_test")
@SecondaryTable(name = "concert",pkJoinColumns = @PrimaryKeyJoinColumn(name = "uuid_concert"),schema = "afisha_test")
public class Concert extends Event{
    private UUID category;

    public Concert() {
    }

    @Column(table = "concert")
    public UUID getCategory() {
        return category;
    }

    public void setCategory(UUID category) {
        this.category = category;
    }
}
