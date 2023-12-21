package model;

public class Student {
    private int id;
    private String name;
    private String DOB;
    private String email;
    private String address;
    private String phone;
    private Classroom classroom;

    public Student(int id, String name, String DOB, String email, String address, String phone, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.classroom = classroom;
    }
    public Student( String name, String DOB, String email, String address, String phone, Classroom classroom) {
        this.name = name;
        this.DOB = DOB;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
