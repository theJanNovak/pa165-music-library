package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.PersistanceApplicationContext;
import cz.muni.fi.pa165.entity.RecordCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by jan.novak on 31.10.16.
 */
@ContextConfiguration(classes = PersistanceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class RecordCompanyTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RecordCompanyDao recordCompanyDao;

    @Test
    public void testCreate() {
        RecordCompany recordCompany = new RecordCompany();
        recordCompany.setName("Test");
        recordCompany.setFounded(new Date());
        recordCompany.setLocation("CZK");

        recordCompanyDao.create(recordCompany);

        Assert.assertEquals(recordCompanyDao.findById(recordCompany.getId()), recordCompany, "Create recordCompany method fail");
    }

    @Test
    public void testUpdate() {
        String oldLocation = "CZK";
        String newLocation = "UK";

        RecordCompany recordCompany = new RecordCompany();
        recordCompany.setName("Test");
        recordCompany.setFounded(new Date());
        recordCompany.setLocation(oldLocation);

        recordCompanyDao.create(recordCompany);

        recordCompany.setLocation(newLocation);
        recordCompanyDao.update(recordCompany);

        String newLocationFromDB = recordCompanyDao.findById(recordCompany.getId()).getLocation();

        Assert.assertNotEquals(newLocationFromDB, oldLocation, "Update record company method fail");
        Assert.assertEquals(newLocationFromDB, newLocation, "Update record company method fail");
    }

    @Test
    public void testDelete() {
        RecordCompany recordCompany = new RecordCompany();
        recordCompany.setName("Test");
        recordCompany.setFounded(new Date());
        recordCompany.setLocation("EUR");

        recordCompanyDao.create(recordCompany);
        Assert.assertEquals(recordCompanyDao.findById(recordCompany.getId()), recordCompany);

        recordCompanyDao.delete(recordCompany);
        Assert.assertNull(recordCompanyDao.findById(recordCompany.getId()));
    }

    @Test
    public void testFindById() {
        RecordCompany recordCompany = new RecordCompany();
        recordCompany.setName("Test");
        recordCompany.setFounded(new Date());
        recordCompany.setLocation("EUR");

        recordCompanyDao.create(recordCompany);
        Assert.assertEquals(recordCompanyDao.findById(recordCompany.getId()), recordCompany);
    }

}
