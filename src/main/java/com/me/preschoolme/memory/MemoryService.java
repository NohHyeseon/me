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

    public SelMemoryVo getMemoryEdit(int imemory){
        return null;
    }

}
