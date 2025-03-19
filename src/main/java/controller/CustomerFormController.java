package controller;

import com.google.inject.Inject;
import dto.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

        boolean isAdded = customerService.addCustomer(new Customer(id, name, address, salary));

        if(isAdded){
            clearFields();
            alert(Alert.AlertType.CONFIRMATION, "Do you want to add this new customer ?");
            alert(Alert.AlertType.INFORMATION, id+" has been added successfully");
        }else {
            clearFields();
            alert(Alert.AlertType.ERROR, id+" added failed");
        }


    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String id = txtId.getText();
        boolean isDeleted = customerService.deleteCustomer(id);

        if(isDeleted){
            clearFields();
            alert(Alert.AlertType.CONFIRMATION, "Do  u want to delete this customer ?");
            alert(Alert.AlertType.INFORMATION, id+" has been deleted successfully");
        }else {
            clearFields();
            alert(Alert.AlertType.ERROR, id+" delete failed");
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

        String id = txtId.getText();
        Customer customer = customerService.searchCustomer(id);

        if(customer != null){

            txtName.setText(customer.getName());
            txtAddress.setText(customer.getAddress());
            txtSalary.setText(String.valueOf(customer.getSalary()));

        }else {
            clearFields();
            alert(Alert.AlertType.ERROR, id+" Not found");

        }



    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();

        boolean isUpdated = customerService.updateCustomer(id, new Customer(txtId.getText()
                , txtName.getText()
                , txtAddress.getText()
                , Double.parseDouble(txtSalary.getText())));

        if(isUpdated){

            clearFields();
            alert(Alert.AlertType.CONFIRMATION, "Do you want to update "+id+" ?");
            alert(Alert.AlertType.INFORMATION, id+" has been updated successfully");

        }else {
            new Alert(Alert.AlertType.ERROR, id+" update failed").showAndWait();
        }

    }

    private void clearFields(){
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtSalary.clear();
    }

    private void alert(Alert.AlertType type, String msg){
        new Alert(type, msg).showAndWait();
    }

}
