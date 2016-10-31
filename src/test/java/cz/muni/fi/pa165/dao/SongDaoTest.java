package cz.muni.fi.pa165.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by xvh on 31.10.2016.
 */
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class SongDaoTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private SongDao songDao;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void create()
    {

    }
}
