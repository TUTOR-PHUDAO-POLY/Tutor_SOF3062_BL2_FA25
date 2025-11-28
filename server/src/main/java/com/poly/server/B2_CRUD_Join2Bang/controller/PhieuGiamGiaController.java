package com.poly.server.B2_CRUD_Join2Bang.controller;

import com.poly.server.B2_CRUD_Join2Bang.model.request.PhieuGiamGiaRequest;
import com.poly.server.B2_CRUD_Join2Bang.model.response.PhieuGiamGiaResponse;
import com.poly.server.B2_CRUD_Join2Bang.service.PhieuGiamGiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/phieu-giam-gia")
public class PhieuGiamGiaController {

    @Autowired
    private PhieuGiamGiaService pggService;

    @GetMapping
    public List<PhieuGiamGiaResponse> hienThiDanhSach() {
        return pggService.getAll();
    }


    @GetMapping("paging")
    public List<PhieuGiamGiaResponse> phanTrangDanhSach(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return pggService.phanTrang(pageNo, pageSize).getContent();
    }

    @GetMapping("detail")
    public PhieuGiamGiaResponse detailPhieuGiamGia(@RequestParam("id") Integer id) {
        return pggService.getOne(id);
    }

    @PostMapping("add")
    public void add(@Valid @RequestBody PhieuGiamGiaRequest request) {
        pggService.addPhieuGiamGia(request);
    }

    @PutMapping("update/{id}")
    public void update(@Valid @RequestBody PhieuGiamGiaRequest request, @PathVariable("id") Integer id) {
        pggService.updatePhieuGiamGia(request, id);
    }

    @DeleteMapping("delete")
    public void remove(@RequestParam Integer id){
        pggService.removePhieuGiamGia(id);
    }
}
