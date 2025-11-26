package com.poly.server.B2_CRUD_Join2Bang.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhieuGiamGiaRequest {

    // cac thuoc tinh con lai (beanutils)
    // ten phai trung vs ten trong entity
    private String ma;

    private String ten;

    private Integer soLuong;

    private String loaiGiam;

    // Rieng khoa ngoai chung ta se mapping kieu khac
    private  Integer loaiPhieuID;

}
