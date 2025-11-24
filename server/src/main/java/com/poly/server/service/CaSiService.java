package com.poly.server.service;

import com.poly.server.entity.CaSi;
import com.poly.server.model.request.CaSiRequest;
import com.poly.server.model.response.CaSiResponse;
import com.poly.server.repository.CaSiRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaSiService {

    @Autowired
    private CaSiRepository caSiRepo;

    public List<CaSiResponse>getAll(){
        return  caSiRepo.hienThiDanhSachCaSi();
    }

    public void delete(Integer id){
        caSiRepo.deleteById(id);
    }

    public CaSiResponse detail(Integer id){
        return caSiRepo.detailCaSi(id);
    }

    public Page<CaSiResponse>phanTrang(Integer pageNo, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return caSiRepo.hienThiDanhSachPhanTrang(pageable);
    }

    public void add(CaSiRequest request){
        // co request => can entity
        // C1: viet ham chuyen doi
//        caSiRepo.save(convertRequestToEntity(request));
        CaSi caSi = new CaSi();
        BeanUtils.copyProperties(request,caSi); // TEN REQUEST PHAI TRUNG VS TEN TRONG ENTITY
        caSiRepo.save(caSi);
    }

    public void update(CaSiRequest request, Integer idCanUpdate){
        CaSi caSi = caSiRepo.findById(idCanUpdate).get();
        BeanUtils.copyProperties(request,caSi); // TEN REQUEST PHAI TRUNG VS TEN TRONG ENTITY
        caSiRepo.save(caSi);
    }

//    private CaSi convertRequestToEntity(CaSiRequest request){
//        // chuyen doi tu request -> entity
//        CaSi casi = new CaSi();
//        casi.setId(request.getId());
//        casi.setTuoi(request.getTuoi());
//        // liet ke cac thuoc tin con lai
//        return casi;
//    }

}
