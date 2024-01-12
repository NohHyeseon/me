package com.me.preschoolme.parent;

import com.me.preschoolme.parent.model.CodeDto;
import com.me.preschoolme.parent.model.CodeVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParentMapper {
    CodeVo selCode(CodeDto dto);

}
