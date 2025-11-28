package com.poly.server.B2_CRUD_Join2Bang.service;

import com.poly.server.B2_CRUD_Join2Bang.entity.LoaiPhieuGiamGia;
import com.poly.server.B2_CRUD_Join2Bang.entity.PhieuGiamGia;
import com.poly.server.B2_CRUD_Join2Bang.exception.ApiException;
import com.poly.server.B2_CRUD_Join2Bang.model.request.PhieuGiamGiaRequest;
import com.poly.server.B2_CRUD_Join2Bang.model.response.PhieuGiamGiaResponse;
import com.poly.server.B2_CRUD_Join2Bang.repository.LoaiPhieuGiamGiaRepository;
import com.poly.server.B2_CRUD_Join2Bang.repository.PhieuGiamGiaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PhieuGiamGiaService {

    @Autowired
    private PhieuGiamGiaRepository pggRepository;

    @Autowired
    private LoaiPhieuGiamGiaRepository loaiPhieuGiamGiaRepository;

    public List<PhieuGiamGiaResponse> getAll() {
        return pggRepository.hienThiDanhSachPhieuGiamGia();
    }

    public PhieuGiamGiaResponse getOne(Integer id) {
        // check ton tai
        // C1:
//        PhieuGiamGiaResponse pgg = pggRepository.detailPhieuGiamGia(id);
//        if (Objects.isNull(pgg)) {
//            throw new ApiException("Phieu giam gia khong ton tai", "P01");
//        }
//        return pgg;
        // C2:
        pggRepository.findById(id).orElseThrow(
                ()-> new ApiException("Phieu giam gia khong ton tai", "P01"));
        return pggRepository.detailPhieuGiamGia(id);
    }

    public Page<PhieuGiamGiaResponse> phanTrang(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return pggRepository.phanTrangPhieuGiamGia(pageable);
    }

    public void removePhieuGiamGia(Integer id) {
        // check ton tai
        pggRepository.findById(id).orElseThrow(
                ()-> new ApiException("Phieu giam gia khong ton tai", "P01"));
        pggRepository.deleteById(id);
    }

    public void addPhieuGiamGia(PhieuGiamGiaRequest request) {
        PhieuGiamGia pgg = new PhieuGiamGia();
        BeanUtils.copyProperties(request, pgg); // Mapping thong qua ten cua thuoc tinh
        // id cua loai phieu giam gia => tim duoc loai phieu gia trong csdl roi set lai ve cho object pgg
        LoaiPhieuGiamGia loaiPhieu = loaiPhieuGiamGiaRepository.findById(request.getLoaiPhieuID()).get();
        // set lai object loai phieu giam gia vao doi tuong pgg
        pgg.setLoaiPhieu(loaiPhieu);
        pggRepository.save(pgg);
    }

    public void updatePhieuGiamGia(PhieuGiamGiaRequest request, Integer idCanUpdate) {
        // check ton tai

        PhieuGiamGia pgg = pggRepository.findById(idCanUpdate).get();
        BeanUtils.copyProperties(request, pgg); // Mapping thong qua ten cua thuoc tinh
        // id cua loai phieu giam gia => tim duoc loai phieu gia trong csdl roi set lai ve cho object pgg
        LoaiPhieuGiamGia loaiPhieu = loaiPhieuGiamGiaRepository.findById(request.getLoaiPhieuID()).get();
        // set lai object loai phieu giam gia vao doi tuong pgg
        pgg.setLoaiPhieu(loaiPhieu);
        pggRepository.save(pgg);
    }
}
