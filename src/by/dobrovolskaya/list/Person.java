package by.dobrovolskaya.list;

public class Person {
    private String name;
    private  String phone;
    private  String email;


    public Person() {
        this.name = name;
    }

    public Person(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Person(Person person) {
        name = person.name;
        phone = person.phone;
        email = person.email;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;

    }

    @Override

    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;

    }

    public String getName() {
        return name;
    }
}
