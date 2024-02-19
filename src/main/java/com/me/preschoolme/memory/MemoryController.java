package com.me.preschoolme.memory;

import com.me.preschoolme.memory.model.InsCommentDto;
import com.me.preschoolme.memory.model.InsCommentVo;
import com.me.preschoolme.memory.model.SelMemoryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/memory")
@Tag(name = "추억앨범", description = "추억앨범 관련 기능 설정")
public class MemoryController {
    private final MemoryService service;


    @GetMapping("/eidt")
    @Operation(summary = "추억앨범 수정 전 정보 불러오기", description ="<strong>추억앨범 수정 전 정보 불러오기</strong><br><br>" )
    public SelMemoryVo getMemoryEdit(int imemory){
        return null;
    }

    @PutMapping("/comment")
    @Operation(summary = "추억앨범 댓글 등록", description = "<strong>추억앨범 댓글 등록, 푸시기능</strong><br><br>")
    public InsCommentVo postMemoryComment(InsCommentDto dto){
        return service.postMemoryComment(dto);
    }

}
