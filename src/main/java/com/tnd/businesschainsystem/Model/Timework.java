package com.tnd.businesschainsystem.Model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="timework")
public class Timework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="date")
    private Date date;

    @Column(name="employee")
    private int employee;

    @Column(name="status")
    private int status;

    public int getId() {
        return id;
    }

    public String getDate() {
        return (new SimpleDateFormat("yyyy/MM/dd")).format(this.date);
    }

    public void setDate(String date) {

        try {
            this.date = (new SimpleDateFormat("yyyy/MM/dd")).parse(date);
        } catch (ParseException e) {
            System.out.println("Exception : " + e);
        }
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void doMappingTimeworkDTO(TimeworkDTO timeworkDTO) {
        this.setDate(timeworkDTO.getDate());
        this.employee = timeworkDTO.getEmployeeId();
        this.status = timeworkDTO.getStatus();
    }
}
