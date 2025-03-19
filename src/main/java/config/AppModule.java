package config;

import com.google.inject.AbstractModule;
import repository.custom.CustomerDao;
import repository.custom.ItemDao;
import repository.custom.OrderDao;
import repository.custom.impl.CustomerDaoImpl;
import repository.custom.impl.ItemDaoImpl;
import repository.custom.impl.OrderDaoImpl;
import service.custom.CustomerService;
import service.custom.ItemService;
import service.custom.OrderService;
import service.custom.impl.CustomerServiceImpl;
import service.custom.impl.ItemServiceImpl;
import service.custom.impl.OrderServiceImpl;

public class AppModule extends AbstractModule {

    @Override
    protected void configure(){
        bind(CustomerService.class).to(CustomerServiceImpl.class);
        bind(ItemService.class).to(ItemServiceImpl.class);
        bind(OrderService.class).to(OrderServiceImpl.class);

        bind(CustomerDao.class).to(CustomerDaoImpl.class);
        bind(ItemDao.class).to(ItemDaoImpl.class);
        bind(OrderDao.class).to(OrderDaoImpl.class);
    }
}
