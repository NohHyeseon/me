package com.me.preschoolme.parent;

import com.google.rpc.Code;
import com.me.preschoolme.parent.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParentMapper {
    CodeVo selCode(CodeDto dto); //식별코드확인
    String checkParentInfo(String uid);//아이디중복체크
    int insParent(ParentInsDto dto); //부모회원가입
    int selParent(ParentSigninDto dto);
    int insKid(ParentKid dto); //마이페이지 아이 추가
    int putParent(UpParentDto dto);//마이페이지 정보수정

    int selKid(ParentKid kid);

}
