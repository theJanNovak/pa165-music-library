package cz.muni.fi.pa165.dao.impl;

import cz.muni.fi.pa165.dao.MusicianDao;
import cz.muni.fi.pa165.entity.Musician;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by peter.koza on 30.10.2016.
 */
@Repository
public class MusicianDaoImpl implements MusicianDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Musician musician) {
        em.persist(musician);
    }

    public void update(Musician musician) {
        em.merge(musician);
    }

    public void delete(Musician musician) {
        em.remove(musician);
    }

    public Musician findById(Long id) {
        return em.find(Musician.class, id);
    }

    public Musician findByTitle(String name) {
        try {
            return em.createQuery("select m from Musician m where m.name = :name", Musician.class)
                    .setParameter("name", name).getSingleResult();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    public List<Musician> findAll() {
        return em.createQuery("select m from Musician m", Musician.class)
                .getResultList();
    }
}
