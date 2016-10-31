package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.PersistanceApplicationContext;
import cz.muni.fi.pa165.entity.Album;
import cz.muni.fi.pa165.entity.Musician;
import cz.muni.fi.pa165.entity.Song;
import cz.muni.fi.pa165.enums.Genre;
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
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vit.holasek on 31.10.2016.
 */
@ContextConfiguration(classes=PersistanceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class SongDaoTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private SongDao songDao;

    @Autowired
    private MusicianDao musicianDao;

    @PersistenceContext
    private EntityManager em;

    private Musician musician1;
    private Musician musician2;
    private Song song1;
    private Song song2;
    private Album album1;

    @BeforeMethod
    public void createData()
    {
        musician1 = new Musician();
        musician1.setName("Iron Maiden");
        musician1.setWebsite("http://ironmaiden.com/");
        musician1.setCountry("GB");
        em.persist(musician1);

        musician2 = new Musician();
        musician2.setName("Korn");
        musician2.setWebsite("http://www.korn.com/");
        musician2.setCountry("US");
        em.persist(musician2);

        album1 = new Album();
        album1.setTitle("Mix");
        album1.setCommentary("Test");
        album1.setReleaseDate(new Date());
        em.persist(album1);

        song1 = new Song();
        song1.setBitrate(320);
        song1.setTitle("Run to the Hills");
        song1.setPositionInAlbum(2);
        song1.setGenre(Genre.METAL);
        song1.setMusician(musician1);
        song1.setAlbum(album1);
        songDao.create(song1);

        song2 = new Song();
        song2.setBitrate(64);
        song2.setTitle("Falling Away from Me");
        song2.setPositionInAlbum(3);
        song2.setGenre(Genre.METAL);
        song2.setMusician(musician2);
        song2.setAlbum(album1);
        songDao.create(song2);
    }

    @Test
    public void create() {
        Song gatheredSong = em.find(Song.class, song1.getId());
        Assert.assertEquals(song1, gatheredSong);
    }

    @Test
    public void update() {
        song2.setCommentary("Test123");
        song2.setTitle("Never Never");
        song2.setGenre(Genre.HIPHOP);
        song2.setMusician(musician1);
        songDao.update(song2);

        Song gatheredSong = em.find(Song.class, song2.getId());
        Assert.assertEquals(song2, gatheredSong);
    }

    @Test
    public void delete() {
        Long id = song1.getId();
        songDao.delete(song1);

        Song gatheredSong = em.find(Song.class, song1.getId());
        Assert.assertNull(gatheredSong);
    }

    @Test
    public void findById() {
        Song gatheredSong = songDao.findById(song1.getId());
        Assert.assertNotNull(gatheredSong);
        Assert.assertEquals(song1, gatheredSong);
    }

    @Test
    public void findByIdNotExistReturnsNull() {
        Song gatheredSong = songDao.findById(new Long(999));
        Assert.assertNull(gatheredSong);
    }

    @Test
    public void findByTitle() {
        Song gatheredSong = songDao.findByTitle("Run to the Hills");
        Assert.assertNotNull(gatheredSong);
        Assert.assertEquals(gatheredSong, song1);
    }

    @Test
    public void findByTitleNotExistReturnsNull() {
        Song gatheredSong = songDao.findByTitle("Run to the Hils");
        Assert.assertNull(gatheredSong);
    }

    @Test
    public void findAll() {
        List<Song> list = songDao.findAll();
        List<Song> list1 = new LinkedList<Song>();
        list1.add(song1);
        list1.add(song2);
        Assert.assertTrue(listEquals(list, list1));
    }

    public static <T> boolean listEquals(List<T> list1, List<T> list2) {
        int counter = 0;
        if (list1.size() != list2.size()) return false;
        for (T item1 : list1) {
            for (T item2 : list2) {
                if (item1.equals(item2))
                {
                    list2.remove(item2);
                    counter++;
                    break;
                }
            }
        }
        return counter == list1.size();
    }
}
