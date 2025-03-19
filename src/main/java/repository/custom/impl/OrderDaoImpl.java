package repository.custom.impl;

import dto.Order;
import repository.custom.OrderDao;

import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean save(Order entity) {
        return false;
    }

    @Override
    public boolean update(Order entity, String s) {
        return false;
    }

    @Override
    public Order search(String s) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Order> getAll() {
        return List.of();
    }
}
