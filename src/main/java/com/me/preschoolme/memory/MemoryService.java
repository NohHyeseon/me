package com.me.preschoolme.memory;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.me.preschoolme.exception.AuthErrorCode;
import com.me.preschoolme.exception.RestApiException;
import com.me.preschoolme.memory.model.InsCommentDto;
import com.me.preschoolme.memory.model.InsCommentVo;
import com.me.preschoolme.memory.model.SelMemoryVo;
import com.me.preschoolme.security.AuthenticationFacade;
import com.me.preschoolme.utils.Const;
import com.me.preschoolme.utils.MyFileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoryService {
    private final MemoryMapper mapper;
    private final MyFileUtils myFileUtils;
    private final AuthenticationFacade authenticationFacade;
    private final ObjectMapper objectMapper;




    public InsCommentVo postMemoryComment(InsCommentDto dto) {
        if ((dto.getIparent() == 0) && dto.getIteacher() == 0 ||
                (dto.getIteacher() > 0 && dto.getIteacher() > 0)) {
            throw new RestApiException(AuthErrorCode.NOT_CORRECT_INFORMATION);
        }
        int writerIuser = authenticationFacade.getLoginUserPk();
        int level = authenticationFacade.getLevelPk();
        dto.setIlevel(level);

        int result = mapper.insComment(dto);
        if(result == 0){
            InsCommentVo vo = new InsCommentVo();
            vo.setResult(-1);
        }
        InsCommentVo vo = new InsCommentVo();
        vo.setResult(1);

        return null;




    }


}


