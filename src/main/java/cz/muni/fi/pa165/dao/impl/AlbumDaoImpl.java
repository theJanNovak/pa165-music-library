package cz.muni.fi.pa165.dao.impl;

import cz.muni.fi.pa165.dao.AlbumDao;
import cz.muni.fi.pa165.entity.Album;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * AlbumDao persistance implementation
 * Created by vit.holasek on 30.10.2016.
 */
@Repository
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

    public List<Album> findByTitle(String title) {
        try {
            return em.createQuery("select a from Album a where a.title like :title", Album.class)
                    .setParameter("title", "%"+title+"%").getResultList();
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
