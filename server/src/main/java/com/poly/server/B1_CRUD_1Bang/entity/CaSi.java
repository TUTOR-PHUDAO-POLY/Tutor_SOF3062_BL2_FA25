package com.poly.server.B1_CRUD_1Bang.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "ca_si")
public class CaSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "ten_ca_si", length = 100)
    private String tenCaSi;

    @Nationalized
    @Column(name = "que_quan", length = 100)
    private String queQuan;

    @Column(name = "tuoi")
    private Integer tuoi;

    @Nationalized
    @Column(name = "cong_ty", length = 100)
    private String congTy;

    @Column(name = "sdt", length = 20)
    private String sdt;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

}