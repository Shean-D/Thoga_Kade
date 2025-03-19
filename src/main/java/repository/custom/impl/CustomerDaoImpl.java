package repository.custom.impl;

import config.HibernateConfig;
import entity.CustomerEntity;
import org.hibernate.Session;
import repository.custom.CustomerDao;

import java.util.List;
import java.util.logging.Logger;

public class CustomerDaoImpl implements CustomerDao {

    private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class.getName());

    @Override
    public boolean save(CustomerEntity entity) {

        Session session = HibernateConfig.getSession();
        session.beginTransaction();

        try{
            session.persist(entity);
            session.getTransaction().commit();

        }catch (Exception e){
            session.getTransaction().rollback();
            logger.severe("Error while saving entity"+e.getMessage());
            e.printStackTrace();
            return false;

        }finally {
            session.close();
        }

        return true;
    }

    @Override
    public boolean update(CustomerEntity entity, String s) {
        Session session = HibernateConfig.getSession();
        session.beginTransaction();

        try {

            CustomerEntity customer = session.get(CustomerEntity.class, s);
            if (customer != null) {
                entity.setId(s);
                session.merge(entity);
                session.getTransaction().commit();

                return true;
            }

            return false;

        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            logger.severe("Error while updating entity"+e.getMessage());
            e.printStackTrace();
            return false;

        }finally {
            session.close();
        }

    }

    @Override
    public CustomerEntity search(String s) {
        Session session = HibernateConfig.getSession();
        session.beginTransaction();

        try {

            return session.get(CustomerEntity.class, s);

        }catch (Exception e){
            logger.severe("Error while searching entity"+e.getMessage());
            e.printStackTrace();
            return null;

        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String s) {
        Session session = HibernateConfig.getSession();
        session.beginTransaction();

        try {
            CustomerEntity customer = session.get(CustomerEntity.class, s);

            if(customer != null){
                session.remove(customer);
                session.getTransaction().commit();
                return true;

            }
            return false;

        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            logger.severe("Error while deleting customer"+e.getMessage());
            e.printStackTrace();

            return false;
        }finally {
            session.close();
        }

    }

    @Override
    public List<CustomerEntity> getAll() {
        return List.of();
    }
}
