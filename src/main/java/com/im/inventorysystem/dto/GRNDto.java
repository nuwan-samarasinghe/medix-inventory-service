package com.im.inventorysystem.dto;

import lombok.Data;

import java.util.List;

@Data
public class GRNDto {

    private String grcnId;
    private String poNo;
    private String supplierName;
    private List<GRNItemDto> itemRequests;

}
