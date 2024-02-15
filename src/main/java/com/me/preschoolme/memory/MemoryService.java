package com.me.preschoolme.memory;

import com.me.preschoolme.common.Const;
import com.me.preschoolme.exception.AuthErrorCode;
import com.me.preschoolme.exception.RestApiException;
import com.me.preschoolme.memory.model.SelMemoryVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoryService {
    private final MemoryMapper mapper;

    public SelMemoryVo selMemory(int imemory){
        //한개의 앨범안에 여러개의 사진이 들어가야함
        String exist = mapper.selImemory(imemory);
        if(exist ==null){
            throw new RestApiException(AuthErrorCode.NOT_CORRECT_INFORMATION);
        }
        if(imemory < 0 ){
            throw new RestApiException(AuthErrorCode.NOT_CORRECT_INFORMATION);
        }
        SelMemoryVo memory = mapper.selMemory(imemory);
        List<String> pics = mapper.selMemoryPic(imemory);
        memory.setMemoryPic(pics);
       //한개의 memory 안에 여러개의 사진을 넣어서 return  해줘야함

        return memory;
    }
}
