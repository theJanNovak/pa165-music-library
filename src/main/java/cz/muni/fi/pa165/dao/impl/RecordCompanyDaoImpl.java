package cz.muni.fi.pa165.dao.impl;

import cz.muni.fi.pa165.dao.RecordCompanyDao;
import cz.muni.fi.pa165.entity.RecordCompany;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by peter.koza on 30.10.2016.
 */
@Repository
public class RecordCompanyDaoImpl implements RecordCompanyDao {
    @PersistenceContext
    private EntityManager em;

    public void create(RecordCompany recordCompany) {
        em.persist(recordCompany);
    }

    public void update(RecordCompany recordCompany) {
        em.merge(recordCompany);
    }

    public void delete(RecordCompany recordCompany) {
        em.remove(recordCompany);
    }

    public RecordCompany findById(Long id) {
        return em.find(RecordCompany.class, id);
    }

    public RecordCompany findByTitle(String name) {
        try {
            return em.createQuery("select r from RecordCompany r where r.name = :name", RecordCompany.class)
                    .setParameter("name", name).getSingleResult();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    public List<RecordCompany> findAll() {
        return em.createQuery("select r from RecordCompany r", RecordCompany.class)
                .getResultList();
    }
}
