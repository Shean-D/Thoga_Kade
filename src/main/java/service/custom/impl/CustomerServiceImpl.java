package service.custom.impl;

import dto.Customer;
import entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.CustomerDao;
import service.custom.CustomerService;
import util.DaoType;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    CustomerDao customerDao = DaoFactory.getInstance().getDao(DaoType.CUSTOMER);

    @Override
    public boolean addCustomer(Customer customer) {
        return customerDao.save(new ModelMapper().map(customer, CustomerEntity.class));
    }

    @Override
    public boolean updateCustomer(String id, Customer customer) {
        return customerDao.update(new ModelMapper().map(customer, CustomerEntity.class), id);
    }

    @Override
    public boolean deleteCustomer(String id) {
        return customerDao.delete(id);
    }

    @Override
    public Customer searchCustomer(String id) {
        CustomerEntity customerEntity = customerDao.search(id);

        if(customerEntity != null){
            return new ModelMapper().map(customerEntity, Customer.class);
        }

        return null;

    }

    @Override
    public List<Customer> getAll() {
        return null;
    }
}
