package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Album;

import java.util.Date;
import java.util.List;

/**
 * Created by vit.holasek on 30.10.2016.
 */
public interface AlbumDao {
    public void create(Album album);
    public void update(Album album);
    public void delete(Album album);
    public Album findById(Long id);
    public Album findByTitle(String name);
    public List<Album> findAll();
    public List<Album> findByReleaseDate(Date from, Date to);
}
