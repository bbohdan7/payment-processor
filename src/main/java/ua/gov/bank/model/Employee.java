package ua.gov.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "employee_name")
    @XmlElement(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_salary")
    @XmlElement(name = "employee_salary")
    private Integer employeeSalary;

    @Column(name = "employee_age")
    @XmlElement(name = "employee_age")
    private Integer employeeAge;

    @Column(name = "profile_image")
    @XmlElement(name = "profile_image")
    private String profileImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Integer employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", employeeName='" + employeeName + '\'' + ", employeeSalary=" + employeeSalary + ", employeeAge=" + employeeAge + ", profileImage='" + profileImage + '\'' + '}';
    }
}
