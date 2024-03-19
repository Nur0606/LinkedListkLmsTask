package LinkedList_LMS.model;

public class Producer {
    private String firstName;

    private String lastName;

    public Producer() {
    }

    public Producer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

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

    @Override
    public String toString() {
        return "\nProducer{" +
               "\n  firstName='" + firstName + '\'' +
               ",\n  lastName='" + lastName + '\'' +
               "}\n";
    }
}
