package com.me.preschoolme.parent;

import com.me.preschoolme.common.ResVo;
import com.me.preschoolme.parent.model.CodeDto;
import com.me.preschoolme.parent.model.CodeVo;
import com.me.preschoolme.parent.model.ParentInsDto;
import com.me.preschoolme.parent.model.ParentUpdDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/parent")
public class ParentController {
    private final ParentService service;

    //식별코드매칭
    @GetMapping("/code")
    public CodeVo postParentCheck(@RequestBody CodeDto dto) {
        return service.getMatch(dto);
    }


    //부모아이디 중복확인
    @PostMapping("/signin")
    public ResVo postParentSignup(ParentInsDto dto) {
        return service.insParent(dto);
    }

    //부모회원가입
    @PostMapping("/signup")
    public ResVo postSignup(@RequestBody ParentInsDto dto) {
        return service.chekUid(dto);
    }

    //부모 마이페이지상 식별코드로 원아등록
    @PostMapping("/kidadd")
    public CodeVo postAddkid(@RequestBody CodeDto dto) {
        return service.postKidCode(dto);
    }



}



