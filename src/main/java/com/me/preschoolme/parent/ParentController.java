package com.me.preschoolme.parent;

import com.me.preschoolme.common.ResVo;
import com.me.preschoolme.parent.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/parent")
@Tag(name = "부모님", description = "부모님 등록 삭제 외 수정, 아이 연결 ")
public class ParentController {
    private final ParentService service;

    //식별코드매칭
    @GetMapping("/check")
    @Operation(summary = "식별코드 체크", description = "<strong>식별코드 체크</strong><br><br>" +
            "식별코드로 회원가입 전 검증단계<br>" +
            "성공시 원아 정보응답<br>" +
            "실패시 에러메세지송출 <br>")
    public CodeVo postParentCheck(@RequestBody CodeDto dto) {
        return service.getMatch(dto);
    }


    //부모아이디 중복확인
    @GetMapping("/signup")
    @Operation(summary = "아이디 중복체크", description = "<strong>아이디 중복 체크</strong><br><br>" +
            "회원가입 전 아이디 중복체크<br>" +
            "성공시 1로 응답<br>" +
            "실패시 에러메세지송출 <br>")
    public ResVo postParentSignup(ParentInsDto dto) {
        return service.chekUid(dto);
    }

    //부모회원가입
    @PostMapping("/signup")
    @Operation(summary = "부모님 회원가입", description = "<strong>부모님 회원가입</strong><br><br>" +
            "이상없을 경우 회원가입 성공<br>" +
            "성공시 1로 응답<br>" +
            "실패시 에러메세지송출 <br>")
    public ResVo postSignup(@RequestBody ParentInsDto dto) {
        return service.insParent(dto);
    }

    //부모님 로그인
    @PostMapping("/signin")
    @Operation(summary = "로그인", description = "<strong>부모님 로그인</strong><br><br>" +
            "uid와 upw로 로그인<br>" +
            "성공시 아이PK, 부모 PK 응답<br>" +
            "실패시 에러메세지송출 <br>")
    public ParentKid postParentSignin(@RequestBody ParentSigninDto dto){
        return service.parentSignin(dto);
    }

    @GetMapping("/edit")
    public ParentBeforInfoVo getParentEdit(@RequestBody ParentBeforinfoDto dto){
        return service.getParentEdit(dto);
    }

    @PutMapping("/putparent")
    public ResVo putParent(@RequestBody UpParentDto dto){
        return service.putParent(dto);
    }



    //부모 마이페이지상 식별코드로 원아등록
    @PostMapping("/kidadd")
    public CodeVo postParentKidAdd(@RequestBody CodeDto dto) {
        return service.postKidCode(dto);
    }




}



