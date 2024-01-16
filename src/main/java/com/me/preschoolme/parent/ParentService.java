package com.me.preschoolme.parent;

import com.google.rpc.Code;
import com.me.preschoolme.common.Const;
import com.me.preschoolme.common.ResVo;
import com.me.preschoolme.parent.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.me.preschoolme.common.Const.*;

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
                return null;//에러코드 송출
            }
            return vo;

        } catch (Exception e) {
            return null;//에러메세지 송출
        }
    }

    //아이디중복체크
    public ResVo chekUid(ParentInsDto dto) {
        String checkUid = mapper.checkParentInfo(dto.getUid());
        ResVo response = new ResVo();
        if (checkUid != null) {
            response.setIsValid(-2);
            response.setMessage("이미 있는 아이디");

        }
        if (dto.getUid() == null) {
            response.setIsValid(-1);//값이 비었음
            response.setMessage("입력하지않음");
        }
        if (checkUid == null) {
            response.setIsValid(1); //회원가입 가능
            response.setMessage("사용가능한 아이디");
        }
        return response;
    }

    //회원가입
    public ResVo insParent(ParentInsDto dto) {
        ResVo result = new ResVo();
        if (dto.getIsValid() != 1) {
            result.setResult(-1);//회원가입 불가
            result.setMessage("아이디 중복체크를 누르세요");
            return result;
        }
        int success = mapper.insParent(dto);

        if (success > 0) {
            result.setResult(1);
            result.setMessage("회원가입 성공");
            ParentKid pk = new ParentKid();
            pk.setIkid(dto.getIkid());
            pk.setIparent(dto.getIparent());
            mapper.insKid(pk);
            return result;
        } else {
            // 데이터베이스 삽입이 실패한 경우
            throw new RuntimeException("회원가입 실패: 데이터베이스 삽입 오류");
        }
    }

    //iparent, ikid 테이블에 추가
    public CodeVo postKidCode(CodeDto dto) {
        CodeVo vo = mapper.selCode(dto);
        //code를 이용해서 PK가져옴

        ParentKid pk = new ParentKid();
        pk.setIkid(vo.getIkid());
        pk.setIparent(dto.getIparent());
        mapper.insKid(pk);
        if (vo.getIkid() < 0) {
            throw new RuntimeException(RUNTIME_EX_MESSAGE);
        }


        return vo;

    }

    //부모 마이페이지ㅏ 정보수정
    public ResVo putParent(UpParentDto dto) {
        ResVo vo = new ResVo();
        if (dto.getParentNm() == null && dto.getPhoneNb() == null && dto.getAddress() == null
                && dto.getUpw() == null) {
            throw new RuntimeException(RUNTIME_EX_MESSAGE);// 예외처리
        }
        int result1 = mapper.putParent(dto);
        if (result1 == 0) {
            throw new RuntimeException();
        }
        log.info("vo: {}", vo);
        return vo;

    }

    public ParentKid parentSignin(ParentSigninDto dto){
        ParentSigninVo saveVo = new ParentSigninVo();
        ParentKid pk = new ParentKid();
        if(dto.getUid() != null && dto.getUpw() !=null &&dto.getUpw().equals(saveVo.getUpw())){
            mapper.selParent(dto);
            dto.setIparent(pk.getIparent());
//            pk.setIkid(mapper.selKid());
        }
        return null;
    }

}













