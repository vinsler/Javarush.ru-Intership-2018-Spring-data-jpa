package parts.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import parts.entities.Detail;

import java.util.List;


@Repository
public class DaoClassDetail implements DaoInterfaceDetail {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Object find(Object i) {
        Session session = sessionFactory.getCurrentSession();
        Detail detail = (Detail) session.get(Detail.class, (Integer) i);
        return detail;
    }

    public boolean add(Object o) {
        Session session = sessionFactory.getCurrentSession();
        session.save(o);
        return true;
    }

    public boolean update(Object o) {
        Session session = sessionFactory.getCurrentSession();
        session.update(o);
        return true;
    }

    public boolean delete(Object i) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(find((Integer) i));
        return true;
    }

    public List<Detail> findByName(Object i) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "select * from detail where name '"+ i.toString() +"'";
        List<Detail> list = session.createSQLQuery(sql).addEntity(Detail.class).list();
        return list;
    }

    public List<Detail> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List <Detail> list = session.createQuery("from Detail").list();
        return list;
    }
}
