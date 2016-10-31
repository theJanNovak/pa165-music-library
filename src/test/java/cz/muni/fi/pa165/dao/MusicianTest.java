package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.PersistanceApplicationContext;
import cz.muni.fi.pa165.entity.Musician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by jan.novak on 31.10.16.
 */
@ContextConfiguration(classes = PersistanceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class MusicianTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MusicianDao musicianDao;

    @Test
    public void testCreate() {
        Musician musician = new Musician();
        musician.setName("Iron Maiden");
        musician.setWebsite("http://ironmaiden.com/");
        musician.setCountry("GB");
        musicianDao.create(musician);

        Assert.assertEquals(musicianDao.findById(musician.getId()), musician, "Create musician method fail");
    }

    @Test
    public void testUpdate() {
        String oldSite = "CZK";
        String newSite = "UK";

        Musician musician = new Musician();
        musician.setName("Iron Maiden");
        musician.setWebsite(oldSite);
        musician.setCountry("GB");
        musicianDao.create(musician);

        musician.setWebsite(newSite);
        musicianDao.update(musician);

        String newLocationFromDB = musicianDao.findById(musician.getId()).getWebsite();

        Assert.assertNotEquals(newLocationFromDB, oldSite, "Update musician method fail");
        Assert.assertEquals(newLocationFromDB, newSite, "Update musician method fail");
    }

    @Test
    public void testDelete() {
        Musician musician = new Musician();
        musician.setName("Iron Maiden");
        musician.setWebsite("http://ironmaiden.com/");
        musician.setCountry("GB");
        musicianDao.create(musician);

        Assert.assertEquals(musicianDao.findById(musician.getId()), musician);

        musicianDao.delete(musician);
        Assert.assertNull(musicianDao.findById(musician.getId()));
    }

    @Test
    public void testFindById() {
        Musician musician = new Musician();
        musician.setName("Iron Maiden");
        musician.setWebsite("http://ironmaiden.com/");
        musician.setCountry("GB");
        musicianDao.create(musician);

        Assert.assertEquals(musicianDao.findById(musician.getId()), musician);
    }

}
