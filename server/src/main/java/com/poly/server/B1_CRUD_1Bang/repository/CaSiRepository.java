package com.poly.server.B1_CRUD_1Bang.repository;

import com.poly.server.B1_CRUD_1Bang.entity.CaSi;
import com.poly.server.B1_CRUD_1Bang.model.response.CaSiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaSiRepository extends JpaRepository<CaSi,Integer> {
    // Hien thi => Load du lieu len table
    // Du lieu tra ra => request ? response

    // xu ly convert trong repository
    @Query("""
        SELECT new com.poly.server.B1_CRUD_1Bang.model.response.CaSiResponse(
            c.id, c.tenCaSi, c.queQuan, c.tuoi, c.sdt
        )
        FROM CaSi c
        """)
    List<CaSiResponse>hienThiDanhSachCaSi();

    @Query("""
        SELECT new com.poly.server.B1_CRUD_1Bang.model.response.CaSiResponse(
            c.id, c.tenCaSi, c.queQuan, c.tuoi, c.sdt
        )
        FROM CaSi c
        WHERE c.id = ?1
        """)
    CaSiResponse detailCaSi(Integer id);

    @Query("""
        SELECT new com.poly.server.B1_CRUD_1Bang.model.response.CaSiResponse(
            c.id, c.tenCaSi, c.queQuan, c.tuoi, c.sdt
        )
        FROM CaSi c
        """)
    Page<CaSiResponse>hienThiDanhSachPhanTrang(Pageable pageable);

}
