package com.poly.server.controller;

import com.poly.server.model.request.CaSiRequest;
import com.poly.server.model.response.CaSiResponse;
import com.poly.server.service.CaSiService;
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
@RequestMapping("api/ca-si/management")
// Restfull api => BE => JSON
// FE: doc dc JSON va hien thi
public class CaSiController {
    // trong controller co bn ham => N api

    @Autowired
    private CaSiService caSiService;

    @GetMapping
    public List<CaSiResponse> hienThiDanhSachCaSi() {
        return caSiService.getAll();
    }

    @GetMapping("phan-trang")
    public List<CaSiResponse> phanTrang(@RequestParam("pageNo1") Integer pageNo,
                                        @RequestParam("pageSize1") Integer pageSize) {
        return caSiService.phanTrang(pageNo, pageSize).getContent();
    }

    @DeleteMapping("delete/{id1}")
    public void xoaCaSi(@PathVariable("id1") Integer id) {
        caSiService.delete(id);
    }

    @GetMapping("detail/{id1}")
    public CaSiResponse detail(@PathVariable("id1") Integer id) {
        return caSiService.detail(id);
    }

    @PostMapping("add")
    public void add(@RequestBody CaSiRequest request) {
        caSiService.add(request);
    }

    @PutMapping("update/{id}")
    public void update(@RequestBody CaSiRequest request, @PathVariable("id") Integer id) {
        caSiService.update(request, id);
    }

}
