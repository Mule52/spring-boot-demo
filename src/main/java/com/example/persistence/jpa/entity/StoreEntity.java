package com.example.persistence.jpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by alex on 10/7/15.
 */
@Entity
@Table(name = "store", schema = "", catalog = "sakila")
public class StoreEntity {
    private byte storeId;
    private byte managerStaffId;
    private short addressId;
    private Timestamp lastUpdate;

    @Id
    @GeneratedValue
    @Column(name = "store_id")
    public byte getStoreId() {
        return storeId;
    }

    public void setStoreId(byte storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "manager_staff_id")
    public byte getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(byte managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    @Basic
    @Column(name = "address_id")
    public short getAddressId() {
        return addressId;
    }

    public void setAddressId(short addressId) {
        this.addressId = addressId;
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

        StoreEntity that = (StoreEntity) o;

        if (storeId != that.storeId) return false;
        if (managerStaffId != that.managerStaffId) return false;
        if (addressId != that.addressId) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) storeId;
        result = 31 * result + (int) managerStaffId;
        result = 31 * result + (int) addressId;
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
