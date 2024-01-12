package com.me.preschoolme.parent;

import com.google.rpc.Code;
import com.me.preschoolme.common.Const;
import com.me.preschoolme.common.ResVo;
import com.me.preschoolme.parent.model.CodeDto;
import com.me.preschoolme.parent.model.CodeVo;
import com.me.preschoolme.parent.model.ParentUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParentService {
    private final ParentMapper mapper;

    public CodeVo getMatch(CodeDto dto) {
        try {
            CodeVo vo = mapper.selCode(dto);
            if (!dto.getCode().equals(vo.getCode())) {
                return null;
            }
            return vo;

        } catch (Exception e) {
            return null;//에러메세지 송출
        }
    }

    public ResVo postSignup(ParentUpdDto dto) {

        return null;
    }


}
