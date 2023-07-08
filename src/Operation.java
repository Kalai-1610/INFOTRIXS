import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Operation {
    File file = new File("Personal Details");
    Scanner scanner = new Scanner(System.in);
    ArrayList<EmployeeDetails> employeeDetailsList = new ArrayList<>();
    ObjectOutputStream objectOutputStream =null;
    ObjectInputStream objectInputStream=null;
    ListIterator listIterator = null;
    Validation validation = new Validation();

    public void display() throws IOException, ClassNotFoundException {
        int c;
        System.out.println(" 1- Add Details" + "\n 2- Get Details" + "\n 3- Get by Id" + "\n 4- Update Details" + "\n 5- Delete Details" + "\n Enter your choice ");
        c = scanner.nextInt();
        switch (c) {
            case 1:
                Add();
                break;
            case 2:
                getAll();
                break;
            case 3:
                getById();
                break;
            case 4:
                update();
                break;
            case 5:
                 delete();
                break;
            default:
                System.out.println("Invalid Input");
        }

    }
    private void update() throws IOException, ClassNotFoundException {
        listAdd();
        Boolean flag = false;
        System.out.println("Enter the ID ");
        int empId = scanner.nextInt();
        listIterator = employeeDetailsList.listIterator();
        while (listIterator.hasNext()){
            EmployeeDetails employeeDetails = (EmployeeDetails) listIterator.next();
            if(employeeDetails.Id == empId){
                System.out.println("Enter the new employee details : ");
                System.out.println("Name");
                String Name = scanner.next();
                System.out.println("Age");
                int Age = scanner.nextInt();
                System.out.println("PhoneNumber");
                String PhoneNumber = scanner.next();
                Boolean vPhoneNumber = validation.phoneNumberCheck(PhoneNumber);
                if(vPhoneNumber == false){
                    throw new RuntimeException("Not a Valid Phone Number");
                }
                System.out.println("Address");
                String Address = scanner.next();
                System.out.println("Email");
                String Email = scanner.next();
                Boolean Vemail = validation.emailCheck(Email);
                if(Vemail == false){
                    throw new RuntimeException("Not a valid email");
                }
                System.out.println("Salary");
                Double Salary = scanner.nextDouble();
                listIterator.set(new EmployeeDetails(empId,Name,Age,PhoneNumber,Address,Email,Salary));
                flag =true;
            }
        }
        if(flag == false){
            System.out.println("No Records Found");
        }
        else{
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(employeeDetailsList);
            objectOutputStream.close();
            System.out.println("Updated Successfully!!");
        }
        display();

    }
    private void delete() throws IOException, ClassNotFoundException {
        listAdd();
        Boolean flag = false;
        System.out.println("Enter the ID ");
        int empId = scanner.nextInt();
        listIterator = employeeDetailsList.listIterator();
        while (listIterator.hasNext()){
            EmployeeDetails employeeDetails = (EmployeeDetails) listIterator.next();
            if(employeeDetails.Id == empId){
                listIterator.remove();
                flag =true;
            }
        }
        if(flag == false){
            System.out.println("No Records Found");
        }
        else{
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(employeeDetailsList);
            objectOutputStream.close();
            System.out.println("Deleted Successfully!!");
        }
        display();
    }
    private void getById() throws IOException, ClassNotFoundException {
        listAdd();
        Boolean flag = false;
        System.out.println("Enter the ID ");
        int empId = scanner.nextInt();
        listIterator = employeeDetailsList.listIterator();
        while (listIterator.hasNext()){
            EmployeeDetails employeeDetails = (EmployeeDetails) listIterator.next();
            if(employeeDetails.Id == empId){
                System.out.println(employeeDetails.toString());
                flag =true;
            }
        }
        if(flag == false){
            System.out.println("No Records Found");
        }
        display();

    }
    private void listAdd() throws IOException, ClassNotFoundException {
        objectInputStream = new ObjectInputStream(new FileInputStream(file));
        employeeDetailsList = (ArrayList<EmployeeDetails>) objectInputStream.readObject();
        objectInputStream.close();
    }
    private void getAll() throws IOException, ClassNotFoundException {
        listAdd();
        boolean flag = false;
        listIterator = employeeDetailsList.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
            flag=true;
        }
        if(flag == false) {
            System.out.println("No Records Found");
        }
        display();
    }

    private void Add () throws IOException, ClassNotFoundException {
            System.out.println("Enter Employee no : ");
            int Id = scanner.nextInt();
            String Name;
            System.out.println("Enter the Name");
            Name = scanner.next();
            int Age;
            System.out.println("Enter the Age");
            Age = scanner.nextInt();
            String PhoneNumber;
            System.out.println("Enter the PhoneNumber");
            PhoneNumber = scanner.next();
            Boolean vPhoneNumber = validation.phoneNumberCheck(PhoneNumber);
            if(vPhoneNumber == false){
                throw new RuntimeException("Not a Valid Phone Number");
            }
            String Address;
            System.out.println("Enter the Address");
            Address = scanner.next();
            String Email;
            System.out.println("Enter the Email");
            Email = scanner.next();
            Boolean Vemail = validation.emailCheck(Email);
            if(Vemail == false){
                throw new RuntimeException("Not a valid email");
            }
            System.out.println("Enter the Salary : ");
            Double Salary = scanner.nextDouble();
            employeeDetailsList.add(new EmployeeDetails(Id,Name,Age,PhoneNumber,Address,Email,Salary));
            objectOutputStream =  new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(employeeDetailsList);
            objectOutputStream.close();
            display();
    }
}
