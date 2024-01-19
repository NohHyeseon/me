package com.me.preschoolme.full_notice;

import com.me.preschoolme.full_notice.model.SelFullNoticeDto;
import com.me.preschoolme.full_notice.model.SelFullNoticeVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fullnotice/")
public class FullNoticeController {
    private final FullNoticeService service;


    @GetMapping("/listall")
    public List<SelFullNoticeVo> getAllFullNotice(SelFullNoticeDto dto) {
        return service.getAllFullNotice(dto);
    }





}
