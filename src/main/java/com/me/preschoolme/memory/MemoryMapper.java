package com.me.preschoolme.memory;

import com.me.preschoolme.memory.model.InsCommentDto;
import com.me.preschoolme.memory.model.SelMemoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
public interface MemoryMapper {
    SelMemoryVo selMemory(int imemory);
    SelMemoryVo selMemoryPic(int imemory);
    String selImemory(int imemory);

    int insComment(InsCommentDto dto);


}
