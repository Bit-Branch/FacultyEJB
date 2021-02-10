package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="faculty")
public class Faculty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false)
    private int numberOfPeople;

    @Column(nullable = false)
    private double semesterFee;

    public Faculty() {
    }

    public Faculty(String name, int numberOfPeople, double semesterFee) {
        this.name = name;
        this.numberOfPeople = numberOfPeople;
        this.semesterFee = semesterFee;
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

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public double getSemesterFee() {
        return semesterFee;
    }

    public void setSemesterFee(double semesterFee) {
        this.semesterFee = semesterFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id &&
                numberOfPeople == faculty.numberOfPeople &&
                Double.compare(faculty.semesterFee, semesterFee) == 0 &&
                Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        long lBits;
        int result = id + prime;
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + numberOfPeople;
        lBits = Double.doubleToLongBits(semesterFee);
        result = prime * result + (int)(lBits ^ (lBits >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", semesterFee=" + semesterFee;
    }
}