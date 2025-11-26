package com.poly.server.B2_CRUD_Join2Bang.repository;

import com.poly.server.B2_CRUD_Join2Bang.entity.LoaiPhieuGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiPhieuGiamGiaRepository extends JpaRepository<LoaiPhieuGiamGia,Integer> {
}
