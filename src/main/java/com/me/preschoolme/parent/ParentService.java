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
        String checkUid = mapper.selId(dto.getUid());
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
            throw new RuntimeException();
        }
        int success = mapper.insParent(dto);
        if (success > 0) {
            result.setResult(1);
            result.setMessage("회원가입 성공");
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

        if (vo.getIkid() < 0) {
            return null;
        }
        mapper.insKid(pk);

        return vo;

    }

    public ResVo putParent(UpParentDto dto){
        ResVo vo = new ResVo();
        if (dto.getParentNm() == null && dto.getPhoneNb() == null && dto.getAddress() == null
        && dto.getUpw()==null) {
            throw new RuntimeException();// 예외처리
        }
        int result1 = mapper.putParent(dto);
        if(result1 == 0){
            throw new RuntimeException();
        }
        log.info("vo: {}",vo);
        return vo;



    }
}













