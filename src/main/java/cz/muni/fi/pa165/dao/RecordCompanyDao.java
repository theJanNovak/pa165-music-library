package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.RecordCompany;

import java.util.List;

/**
 * Created by peter.koza on 30.10.2016.
 */
public interface RecordCompanyDao {
    public void create(RecordCompany recordCompany);

    public void update(RecordCompany recordCompany);

    public void delete(RecordCompany recordCompany);

    public RecordCompany findById(Long id);

    public RecordCompany findByTitle(String name);

    public List<RecordCompany> findAll();
}
