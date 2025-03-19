package service.custom.impl;

import dto.Item;
import service.custom.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Override
    public boolean addItem(String id) {
        return false;
    }

    @Override
    public boolean deleteItem(String id) {
        return false;
    }

    @Override
    public boolean updateItem(String id) {
        return false;
    }

    @Override
    public Item searchItem(String code) {
        return null;
    }

    @Override
    public List<Item> getAll() {
        return List.of();
    }
}
