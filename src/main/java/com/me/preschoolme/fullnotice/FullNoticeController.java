package com.me.preschoolme.fullnotice;

import com.me.preschoolme.fullnotice.model.SelFullNoticeDto;
import com.me.preschoolme.fullnotice.model.SelFullNoticeVo;
import com.me.preschoolme.fullnotice.model.SelNoticeVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "유치원 소식", description = "유치원 소식 불러오기")
public class FullNoticeController {
    private final FullNoticeService service;


    @GetMapping("/listall")
    @Operation(summary = "유치원 전체 소식 불러오기", description = "<strong>게시판 전체불러오기</strong><br><br>" +
            "게시판 전체보내기<br>" +
            "성공시 페이지 띄우기<br>" +
            "실패시 에러메세지송출<br>")
    public List<SelFullNoticeVo> getAllFullNotice(SelFullNoticeDto dto) {
        return service.getAllFullNotice(dto);
    }

    @GetMapping
    @Operation(summary = "유치원 소식 불러오기", description = "<strong>소식 불러오기</strong><br><br>" +
            "유치원 소식<br>" +
            "성공시 페이지 띄우기<br>" +
            "실패시 에러메세지송출<br>")
    public SelNoticeVo getNotice(int iFullNotice){
        return service.getFullNotice(iFullNotice);
    }


}
