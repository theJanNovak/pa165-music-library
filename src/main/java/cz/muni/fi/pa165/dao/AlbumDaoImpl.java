package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Album;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by xvh on 30.10.2016.
 */
public class AlbumDaoImpl implements AlbumDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Album album) {
        em.persist(album);
    }

    public void update(Album album) {
        em.merge(album);
    }

    public void delete(Album album) {
        em.remove(album);
    }

    public Album findById(Long id) {
        return em.find(Album.class, id);
    }

    public Album findByTitle(String title) {
        try {
            return em.createQuery("select a from Album a where a.title = :title", Album.class)
                    .setParameter("title", title).getSingleResult();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    public List<Album> findAll() {
        return em.createQuery("select c from Album c", Album.class)
                .getResultList();
    }

    public List<Album> findByReleaseDate(Date from, Date to) {
        return em.createQuery("select a from Album a where a.releaseDate between :from and :to", Album.class)
                .setParameter("from", from, TemporalType.DATE)
                .setParameter("to", to, TemporalType.DATE).getResultList();
    }
}
