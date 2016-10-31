package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Album;

import java.util.Date;
import java.util.List;

/**
 * Album entity DAO interface
 * Created by vit.holasek on 30.10.2016.
 */
public interface AlbumDao {

    /**
     * Create album entity
     * @param album Album entity
     */
    public void create(Album album);

    /**
     * Update changes of Album entity
     * @param album Album entity
     */
    public void update(Album album);

    /**
     * Delete Album entity
     * @param album Album entity
     */
    public void delete(Album album);

    /**
     * Find Album entity with given ID
     * @param id ID
     * @return Album entity
     */
    public Album findById(Long id);

    /**
     * Find all Album entities which contains title string
     * @param title String contained in title
     * @return List of Album entities
     */
    public List<Album> findByTitle(String title);

    /**
     * Find all stored Album entities
     * @return List of Album entities
     */
    public List<Album> findAll();

    /**
     * Find all Album entities between given dates
     * @param from From Date
     * @param to To Date
     * @return List of Album entities
     */
    public List<Album> findByReleaseDate(Date from, Date to);
}
