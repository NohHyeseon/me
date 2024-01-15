package com.me.preschoolme.parent;

import com.google.rpc.Code;
import com.me.preschoolme.parent.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParentMapper {
    CodeVo selCode(CodeDto dto);
    String selId(String uid);
    int insParent(ParentInsDto dto);
    int insKid(ParentKid dto);
    int putParent(UpParentDto dto);

}
