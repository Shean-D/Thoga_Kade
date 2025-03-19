package service.custom;

import dto.Item;
import service.SuperService;

import java.util.List;

public interface ItemService extends SuperService {

    boolean addItem(String id);

    boolean deleteItem(String id);

    boolean updateItem(String id);

    Item searchItem(String code);

    List<Item> getAll();
}
