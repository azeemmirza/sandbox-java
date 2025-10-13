package lab_08;

class Employee {
    private int id;
    private String name;
    private int salary;
    private int addressId;
    private int deptId;

    public Employee(int id, String name, int salary, int addressId, int deptId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.addressId = addressId;
        this.deptId = deptId;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", addressId=" + addressId +
                ", deptId=" + deptId +
                '}';
    }
}

