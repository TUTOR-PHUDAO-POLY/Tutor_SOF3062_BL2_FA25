package com.poly.server.B2_CRUD_Join2Bang.repository;

import com.poly.server.B2_CRUD_Join2Bang.entity.PhieuGiamGia;
import com.poly.server.B2_CRUD_Join2Bang.model.response.PhieuGiamGiaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface PhieuGiamGiaRepository extends JpaRepository<PhieuGiamGia, Integer> {

    @Query("""
            SELECT new com.poly.server.B2_CRUD_Join2Bang.model.response.PhieuGiamGiaResponse(
                p.ma, p.ten,p.soLuong,p.loaiGiam,l.ma,l.ten
            )
            FROM PhieuGiamGia p INNER JOIN LoaiPhieuGiamGia l 
            ON p.loaiPhieu.id = l.id
            """)
    List<PhieuGiamGiaResponse> hienThiDanhSachPhieuGiamGia();

    @Query("""
            SELECT new com.poly.server.B2_CRUD_Join2Bang.model.response.PhieuGiamGiaResponse(
                p.ma, p.ten,p.soLuong,p.loaiGiam,l.ma,l.ten
            )
            FROM PhieuGiamGia p, LoaiPhieuGiamGia l 
            WHERE p.loaiPhieu.id = l.id
            AND p.id = ?1
            """)
    PhieuGiamGiaResponse detailPhieuGiamGia(@RequestParam Integer id);

    @Query("""
            SELECT new com.poly.server.B2_CRUD_Join2Bang.model.response.PhieuGiamGiaResponse(
                p.ma, p.ten,p.soLuong,p.loaiGiam,l.ma,l.ten
            )
            FROM PhieuGiamGia p, LoaiPhieuGiamGia l 
            WHERE p.loaiPhieu.id = l.id
            """)
    Page<PhieuGiamGiaResponse> phanTrangPhieuGiamGia(Pageable pageable);

}
