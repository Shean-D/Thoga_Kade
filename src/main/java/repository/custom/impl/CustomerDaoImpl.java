package repository.custom.impl;

import dto.Customer;
import repository.custom.CustomerDao;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(Customer entity) {
        return false;
    }

    @Override
    public boolean update(Customer entity, String s) {
        return false;
    }

    @Override
    public Customer search(String s) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return List.of();
    }
}
