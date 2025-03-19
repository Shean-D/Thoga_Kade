package controller;

import com.google.inject.Inject;
import dto.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import service.custom.CustomerService;


public class CustomerFormController {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableView<?> tblCustomers;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSalary;

    @Inject
    CustomerService customerService;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        Double salary = Double.parseDouble(txtSalary.getText());

        customerService.addCustomer(new Customer(id, name, address, salary));

        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtSalary.clear();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String id = txtId.getText();
        customerService.deleteCustomer(id);
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

        String id = txtId.getText();
        Customer customer = customerService.searchCustomer(id);

        txtName.setText(customer.getName());
        txtAddress.setText(customer.getAddress());
        txtSalary.setText(String.valueOf(customer.getSalary()));
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        Customer customer = customerService.searchCustomer(id);

        customerService.updateCustomer(id, customer);

    }

}
