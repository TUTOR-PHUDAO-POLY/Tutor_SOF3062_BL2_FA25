package com.poly.server.B2_CRUD_Join2Bang.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "loai_phieu_giam_gia")
public class LoaiPhieuGiamGia {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Nationalized
    @Column(name = "ten")
    private String ten;

}