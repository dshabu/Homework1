package sample;

import java.util.UUID;

public class Employee {
    private String firstName, lastName;
    private boolean isActive;
    private UUID employeeId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Employee(String fName, String lName, boolean iA) {
        setFirstName(fName);
        setLastName(lName);
        setActive(iA);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s, %s\n", isActive() ? "ACTIVE" : "INACTIVE", getLastName(), getFirstName());
    }
}
