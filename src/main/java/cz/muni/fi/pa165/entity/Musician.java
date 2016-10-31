package cz.muni.fi.pa165.entity;

import javax.persistence.*;

/**
 * Created by jan.novak
 */
@Entity
public class Musician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    private String website;

    public Musician() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Musician)) return false;

        Musician musician = (Musician) o;

        if (getId() != null ? !getId().equals(musician.getId()) : musician.getId() != null) return false;
        if (!getName().equals(musician.getName())) return false;
        if (!getCountry().equals(musician.getCountry())) return false;
        return getWebsite() != null ? getWebsite().equals(musician.getWebsite()) : musician.getWebsite() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getName().hashCode();
        result = 31 * result + getCountry().hashCode();
        result = 31 * result + (getWebsite() != null ? getWebsite().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Musician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
