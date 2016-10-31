package cz.muni.fi.pa165.entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by jan.novak
 */
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String commentary;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    @ManyToOne(optional=false)
    private RecordCompany recordCompany;

    @Lob
    private byte[] albumArt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public byte[] getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(byte[] albumArt) {
        this.albumArt = albumArt;
    }

    public RecordCompany getRecordCompany() {
        return recordCompany;
    }

    public void setRecordCompany(RecordCompany recordCompany) {
        this.recordCompany = recordCompany;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
