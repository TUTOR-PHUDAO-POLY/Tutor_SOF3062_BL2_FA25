package com.poly.server.B2_CRUD_Join2Bang.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhieuGiamGiaResponse {
    // Mã phiếu, Tên phiếu, Số lượng, Loại giảm, Mã loại phiếu, Tên loại phiếu

    private String maPhieu;

    private String tenPhieu;

    private Integer soLuong;

    private String loai;

    private String maLoaiPhieu;

    private String tenLoaiPhieu;

}
