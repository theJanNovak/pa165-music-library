
package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Musician;

import java.util.List;

/**
 * Created by peter.koza on 30.10.2016.
 */
public interface MusicianDao {
    public void create(Musician musician);

    public void update(Musician musician);

    public void delete(Musician musician);

    public Musician findById(Long id);

    public Musician findByTitle(String name);

    public List<Musician> findAll();
}
