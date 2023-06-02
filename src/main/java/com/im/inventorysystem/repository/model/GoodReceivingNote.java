package com.im.inventorysystem.repository.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Getter
@Setter
public class GoodReceivingNote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer grcnId;
    private String poNo;
    private String supplierName;
    private Date receivedDate;
    private String itemId;
    private String itemName;
    private String category;
    private String expiryDate;
    private String batchNo;
    private String partNo;
    private String receivedQty;
    private String location;
    private String itemUnit;
    private String status;
    private String remark;
}
