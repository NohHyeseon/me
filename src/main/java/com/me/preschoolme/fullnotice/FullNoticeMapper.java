package com.me.preschoolme.fullnotice;

import com.me.preschoolme.fullnotice.model.SelFullNoticeDto;
import com.me.preschoolme.fullnotice.model.SelFullNoticeVo;
import com.me.preschoolme.fullnotice.model.SelNoticeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FullNoticeMapper {
    List<SelFullNoticeVo> getFullNoticeFix();
    List<SelFullNoticeVo> getFullNoticelist(SelFullNoticeDto dto);

    List<String> selNoticePic(int iFullNotice); //notice안 사진 불러오기
    SelNoticeVo getNotice(int iFullNotice); //notice불러오기


}
