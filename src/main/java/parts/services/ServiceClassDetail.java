package parts.services;

import org.springframework.stereotype.Service;
import parts.dao.DaoClassDetail;
import parts.dao.DaoInterfaceDetail;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceClassDetail implements DaoInterfaceDetail {
    private DaoClassDetail daoClassDetail;

    public void setDaoClassDetail(DaoClassDetail daoClassDetail) {
        this.daoClassDetail = daoClassDetail;
    }

    @Transactional
    public Object find(Object i) {
        return daoClassDetail.find(i);
    }

    @Transactional
    public boolean add(Object o) {
        return daoClassDetail.add(o);
    }

    @Transactional
    public boolean update(Object o) {
        return daoClassDetail.update(o);
    }

    @Transactional
    public boolean delete(Object i) {
        return daoClassDetail.delete(i);
    }

    @Transactional
    public List findByName(Object i) {
        return daoClassDetail.findByName(i);
    }

    @Transactional
    public List findAll() {
        return daoClassDetail.findAll();
    }
}
