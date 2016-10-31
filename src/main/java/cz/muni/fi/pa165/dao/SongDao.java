package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Song;

import java.util.List;

/**
 * Created by jan.novak on 30.10.2016.
 */
public interface SongDao {
    public void create(Song song);

    public void update(Song song);

    public void delete(Song song);

    public Song findById(Long id);

    public Song findByTitle(String title);

    public List<Song> findAll();
}
