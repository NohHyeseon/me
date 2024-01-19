package com.me.preschoolme.full_notice;

import com.me.preschoolme.full_notice.model.SelFullNoticeFixVo;
import com.me.preschoolme.full_notice.model.SelFullNoticeDto;
import com.me.preschoolme.full_notice.model.SelFullNoticeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FullNoticeMapper {
    List<SelFullNoticeVo> getFullNoticeFix();
    List<SelFullNoticeVo> getFullNoticelist(SelFullNoticeDto dto);

    List<String> selNoticePic(int ifeed);


}
