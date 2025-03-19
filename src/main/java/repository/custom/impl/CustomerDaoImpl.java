package repository.custom.impl;

import dto.Customer;
import entity.CustomerEntity;
import repository.custom.CustomerDao;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean save(CustomerEntity entity) {
        return false;
    }

    @Override
    public boolean update(CustomerEntity entity, String s) {
        return false;
    }

    @Override
    public CustomerEntity search(String s) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<CustomerEntity> getAll() {
        return List.of();
    }
}
