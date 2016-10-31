package cz.muni.fi.pa165.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jan.novak
 */
@Entity
public class RecordCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Temporal(TemporalType.DATE)
    private Date founded;

    public RecordCompany() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getFounded() {
        return founded;
    }

    public void setFounded(Date founded) {
        this.founded = founded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecordCompany)) return false;

        RecordCompany that = (RecordCompany) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (!getName().equals(that.getName())) return false;
        if (!getLocation().equals(that.getLocation())) return false;
        return getFounded() != null ? getFounded().equals(that.getFounded()) : that.getFounded() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getName().hashCode();
        result = 31 * result + getLocation().hashCode();
        result = 31 * result + (getFounded() != null ? getFounded().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RecordCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", founded=" + founded +
                '}';
    }
}
