package repository.custom;

import dto.Item;
import dto.Order;
import repository.CrudDao;

public interface ItemDao extends CrudDao<Item , String> {
    interface OrderDao extends CrudDao<Order, String> {
    }
}
