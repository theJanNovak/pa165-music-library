package cz.muni.fi.pa165.entity;

import cz.muni.fi.pa165.enums.Genre;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Created by jan.novak
 */
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Min(0)
    private int bitrate;

    @Column(nullable = false)
    @Min(1)
    private int positionInAlbum;

    private String commentary;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne(optional = false)
    private Album album;

    @ManyToOne(optional = false)
    private Musician musician;

    public Song() {
    }

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

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public int getPositionInAlbum() {
        return positionInAlbum;
    }

    public void setPositionInAlbum(int positionInAlbum) {
        this.positionInAlbum = positionInAlbum;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String comentatory) {
        this.commentary = comentatory;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", bitrate=" + bitrate +
                ", positionInAlbum=" + positionInAlbum +
                ", comentatory='" + commentary + '\'' +
                ", genre=" + genre +
                ", album=" + album +
                ", musician=" + musician +
                '}';
    }

}
