package cz.muni.fi.pa165.dao.impl;

import cz.muni.fi.pa165.dao.SongDao;
import cz.muni.fi.pa165.entity.Song;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by jan.novak on 30.10.2016.
 */
@Repository
public class SongDaoImpl implements SongDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Song song) {
        em.persist(song);
    }

    public void update(Song song) {
        em.merge(song);
    }

    public void delete(Song song) {
        em.remove(song);
    }

    public Song findById(Long id) {
        return em.find(Song.class, id);
    }

    public Song findByTitle(String title) {
        try {
            return em.createQuery("select s from Song s where s.title = :title", Song.class)
                    .setParameter("title", title).getSingleResult();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    public List<Song> findAll() {
        return em.createQuery("select s from Song s", Song.class)
                .getResultList();
    }
}
