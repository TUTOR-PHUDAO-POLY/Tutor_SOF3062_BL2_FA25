package com.poly.server.B2_CRUD_Join2Bang.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Ma khong duoc de trong")
    private String ma;

    @NotBlank(message = "Ten khong duoc de trong")
    private String ten;

    @NotNull(message = "So luong khong duoc de trong")
    private Integer soLuong;

    @NotBlank(message = "Loai giam khong de trong")
    private String loaiGiam;

    // Rieng khoa ngoai chung ta se mapping kieu khac
    @NotNull(message = "Phai chon phieu giam gia")
    private  Integer loaiPhieuID;

}
