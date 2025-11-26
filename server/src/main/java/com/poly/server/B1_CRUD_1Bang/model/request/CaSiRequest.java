package com.poly.server.B1_CRUD_1Bang.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CaSiRequest {
    // Model Mapper: ten trong request khac vs ten trong entiy (Co the hieu duoc)
    // Tu viet ham chuyen doi (Dat ten khac cung duoc)
    // Bean Utils: ten trong entiy phai trung vs ten trong request

    private Integer id;

    private String tenCaSi;

    private String queQuan;

    private Integer tuoi;

    private String congTy;

}
