package com.poly.server.B1_CRUD_1Bang.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CaSiResponse {

    private Integer id;

    private String tenCuaCaSi;

    private String que;

    private Integer tuoi;

    private String soDienThoai;

}
