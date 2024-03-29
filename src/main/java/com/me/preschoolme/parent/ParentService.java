package com.me.preschoolme.parent;

import com.me.preschoolme.common.ResVo;
import com.me.preschoolme.exception.*;
import com.me.preschoolme.parent.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;


@Service
@Slf4j
@RequiredArgsConstructor
public class ParentService {
    private final ParentMapper mapper;

    //식별코드 매칭
    public CodeVo getMatch(CodeDto dto) {
        try {
            CodeVo vo = mapper.selCode(dto);
            if (!dto.getCode().equals(vo.getCode())) {
                throw new RestApiException(AuthErrorCode.CHECK_DUPLICATION_ID);
            }
            return vo;
        } catch (Exception e) {
            throw new RestApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    //아이디중복체크
    public ResVo chekUid(ParentInsDto dto) {
        String checkUid = mapper.checkParentInfo(dto.getUid());
        ResVo response = new ResVo();
        if (checkUid != null) {
            throw new RestApiException(AuthErrorCode.ALREADY_EXIST_ID);
        }
        if (dto.getUid() == null) {
            throw new RestApiException(AuthErrorCode.NOT_ENTER_ID);
        }
        if (checkUid == null) {
            response.setIsValid(1); //회원가입 가능
            response.setIsValid(1); //회원가입 가능
            response.setMessage("사용가능한 아이디");
        }
        return response;
    }

    //회원가입, 성공시 t_parent_kid 테이블에 ikidPK, iparentPK 인서트
    public ResVo insParent(ParentInsDto dto) {

        if (dto.getIsValid() != 1) {
            throw new RestApiException(AuthErrorCode.CHECK_DUPLICATION_ID);
        }

        if (dto.getIsValid() == 1) {
            ResVo vo = new ResVo();
            mapper.insParent(dto);
            ParentKid pk = new ParentKid();
            pk.setIkid(dto.getIkid());
            pk.setIparent(dto.getIparent());
            mapper.insParentKidTable(pk);
            vo.setResult(1);
            return vo;
        } else {
            // 데이터베이스 삽입이 실패한 경우
            throw new RestApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    //부모님 로그인
    public ParentKid parentSignin(ParentSigninDto dto) {
        ParentSigninDto saveVo = mapper.selParent(dto);
        ParentKid pk = new ParentKid();
        if (dto.getUid() != null && dto.getUpw() != null && dto.getUpw().equals(saveVo.getUpw())) {
            pk.setIparent(saveVo.getIparent());
            pk.setIkid(saveVo.getIkid());
        }
        return pk;
    }

    //원래정보 불러오기
    public ParentBeforInfoVo getParentEdit(ParentBeforinfoDto dto) {
        ParentBeforinfoDto beforinfoDto = new ParentBeforinfoDto();
        if(dto.getIparent() != beforinfoDto.getIparent() ){
            throw new RestApiException(AuthErrorCode.NOT_CORRECT_INFORMATION);
        }
        ParentBeforInfoVo vo = mapper.selBeforeInfo(dto);
        return vo;
    }


    //부모 마이페이지ㅏ 정보수정
    public ResVo putParent(UpParentDto dto) {
        ResVo vo = new ResVo();
        if (dto.getParentNm() == null && dto.getPhoneNb() == null && dto.getEmail() == null
                && dto.getUpw() == null) {
            return vo;
            //throw new RestApiException(AuthErrorCode.CHECK_CODE);
        }
        int result1 = mapper.putParent(dto);
        if (result1 == 0) {
            vo.setResult(-1);
            return vo;
            //throw new RestApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
        }
        vo.setResult(result1);

        return vo;

    }

    //마이페이지 원아추가
    public CodeVo postKidCode(CodeDto dto) {
        CodeVo vo = new CodeVo();
        if(dto.getCode()!= vo.getCode()){
            throw new RestApiException(AuthErrorCode.CHECK_CODE);
        }else {
        vo = mapper.selCode(dto);
        ParentKid pk = new ParentKid();
        pk.setIkid(vo.getIkid());
        pk.setIparent(dto.getIparent());
        mapper.insParentKidTable(pk);
        return vo;}
    }

    //부모 정보 삭제
    public ResVo delParentSelf(ParentDeleteDto dto) {
        ResVo vo = new ResVo();
        int delete = mapper.delParent(dto);
        if(delete ==0){
            throw new RestApiException(AuthErrorCode.NOT_CORRECT_INFORMATION);

        }else vo.setResult(1);
            return vo;
    }
}














