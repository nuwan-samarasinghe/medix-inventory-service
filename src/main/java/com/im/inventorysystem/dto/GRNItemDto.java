package com.im.inventorysystem.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class GRNItemDto {
    private String supplierId;
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
