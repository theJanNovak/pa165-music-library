package cz.muni.fi.pa165.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    private List<Song> songs = new ArrayList<Song>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Album)) return false;

        Album album = (Album) o;

        if (title != null ? !title.equals(album.title) : album.title != null) return false;
        if (commentary != null ? !commentary.equals(album.commentary) : album.commentary != null) return false;
        if (releaseDate != null ? !releaseDate.equals(album.releaseDate) : album.releaseDate != null) return false;
        if (recordCompany != null ? !recordCompany.equals(album.recordCompany) : album.recordCompany != null)
            return false;
        return Arrays.equals(albumArt, album.albumArt);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (commentary != null ? commentary.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (recordCompany != null ? recordCompany.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(albumArt);
        return result;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", commentary='" + commentary + '\'' +
                ", releaseDate=" + releaseDate +
                ", songs=" + songs +
                ", recordCompany=" + recordCompany +
                ", albumArt=" + Arrays.toString(albumArt) +
                '}';
    }
}
