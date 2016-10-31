package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.PersistanceApplicationContext;
import cz.muni.fi.pa165.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

/**
 * Created by peter.koza on 31.10.16.
 */
@ContextConfiguration(classes = PersistanceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class AlbumDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AlbumDao albumDao;

    @PersistenceContext
    private EntityManager em;

    private Album album1;

    @BeforeMethod
    public void createData() {
        album1 = new Album();
        album1.setTitle("Mix");
        album1.setCommentary("Test");
        album1.setReleaseDate(new Date());
        em.persist(album1);
    }

    @Test
    public void testCreate() {
        Album albumCreate = new Album();
        albumCreate.setTitle("Imaginarium naprosto běžných podivností");
        albumCreate.setCommentary("Test");
        albumCreate.setReleaseDate(new Date());
        albumDao.create(albumCreate);

        Assert.assertEquals(albumDao.findById(albumCreate.getId()), albumCreate, "Create album method fail");
    }

    @Test
    public void testUpdate() {
        String oldCommentatory = album1.getCommentary();
        String newCommentatory = "newCommentatory";
        album1.setCommentary(newCommentatory);
        albumDao.update(album1);

        String newCommentatoryFromDB = albumDao.findById(album1.getId()).getCommentary();

        Assert.assertNotEquals(newCommentatoryFromDB, oldCommentatory, "Update album method fail");
        Assert.assertEquals(newCommentatoryFromDB, newCommentatory, "Update album method fail");
    }

    @Test
    public void testDelete() {
        albumDao.delete(album1);
        Assert.assertNull(albumDao.findById(album1.getId()));
    }
}
