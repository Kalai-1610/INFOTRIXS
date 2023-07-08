import java.io.Serializable;

public class EmployeeDetails implements Serializable {
    int Id;
    String Name;
    int Age;
    String PhoneNumber;
    String Address;
    String Email;
    Double Salary;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public EmployeeDetails(int id, String name, int age, String phoneNumber, String address, String email, Double salary) {
        Id = id;
        Name = name;
        Age = age;
        PhoneNumber = phoneNumber;
        Address = address;
        Email = email;
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Address='" + Address + '\'' +
                ", Email='" + Email + '\'' +
                ", Salary=" + Salary;
    }
}
