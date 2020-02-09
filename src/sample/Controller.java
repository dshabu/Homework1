package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ListView<Employee> employeeListView;

    @FXML
    private Button deleteEmployeeBtn;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private CheckBox activeCheckbox;

    @FXML
    private Button clearFieldsBtn;

    @FXML
    private Button newEmployeeBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // fill employeeListView with random data
        ObservableList<Employee> employeeList = employeeListView.getItems();

        for (int i = 0; i < 15; i++) {
            int activeInt = (int)(Math.random() * 2);
            Employee employee = new Employee(genRandomString(5), genRandomString(8), activeInt % 2 == 0);
            employeeList.add(employee);
        }

        // add listener for fields
        employeeListView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Employee> ov, Employee oldVal, Employee newVal) -> {
            Employee selectedItem = employeeListView.getSelectionModel().getSelectedItem();

            if (selectedItem != null) {
                firstNameField.setText(selectedItem.getFirstName());
                lastNameField.setText(selectedItem.getLastName());
                activeCheckbox.setSelected(selectedItem.isActive());
            }
        });

        clearFieldsBtn.setOnAction(event -> {
            firstNameField.clear();
            lastNameField.clear();
            activeCheckbox.setSelected(false);
        });

        newEmployeeBtn.setOnAction(event -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            boolean activeStatus = activeCheckbox.isSelected();

            Employee employee = new Employee(firstName, lastName, activeStatus);

            employeeList.add(employee);
        });

        deleteEmployeeBtn.setOnAction(event -> {
            Employee selectedItem = employeeListView.getSelectionModel().getSelectedItem();

            if (selectedItem != null) {
                employeeList.remove(selectedItem);
            }
        });
    }

    private String genRandomString(int len) {
        char[] charArray = new char[len];

        for (int i = 0; i < len; i++) {
            charArray[i] = (char)((int)(Math.random() * 25) + 97);
        }

        return String.valueOf(charArray);
    }
}
