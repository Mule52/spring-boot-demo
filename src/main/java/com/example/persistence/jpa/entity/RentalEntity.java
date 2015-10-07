package com.example.persistence.jpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by alex on 10/7/15.
 */
@Entity
@Table(name = "rental", schema = "", catalog = "sakila")
public class RentalEntity {
    private int rentalId;
    private Timestamp rentalDate;
    private int inventoryId;
    private short customerId;
    private Timestamp returnDate;
    private byte staffId;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "rental_id")
    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    @Basic
    @Column(name = "rental_date")
    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    @Basic
    @Column(name = "inventory_id")
    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    @Basic
    @Column(name = "customer_id")
    public short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(short customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "return_date")
    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    @Basic
    @Column(name = "staff_id")
    public byte getStaffId() {
        return staffId;
    }

    public void setStaffId(byte staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentalEntity that = (RentalEntity) o;

        if (rentalId != that.rentalId) return false;
        if (inventoryId != that.inventoryId) return false;
        if (customerId != that.customerId) return false;
        if (staffId != that.staffId) return false;
        if (rentalDate != null ? !rentalDate.equals(that.rentalDate) : that.rentalDate != null) return false;
        if (returnDate != null ? !returnDate.equals(that.returnDate) : that.returnDate != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rentalId;
        result = 31 * result + (rentalDate != null ? rentalDate.hashCode() : 0);
        result = 31 * result + inventoryId;
        result = 31 * result + (int) customerId;
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + (int) staffId;
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
