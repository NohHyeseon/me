package com.me.preschoolme.fullnotice;

import com.me.preschoolme.exception.AuthErrorCode;
import com.me.preschoolme.exception.RestApiException;
import com.me.preschoolme.fullnotice.model.SelFullNoticeDto;
import com.me.preschoolme.fullnotice.model.SelFullNoticeVo;
import com.me.preschoolme.fullnotice.model.SelNoticeVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FullNoticeService {
    private final FullNoticeMapper mapper;

    //전체게시판 조회
    public List<SelFullNoticeVo> getAllFullNotice(SelFullNoticeDto dto) {

        List<SelFullNoticeVo> noticeFix = mapper.getFullNoticeFix();
        if (noticeFix.size() == 0 || noticeFix.size()>3) {
            throw new RestApiException(AuthErrorCode.NOT_IMPORTED);
        }
        //size 0일때 예외처리, 두개값 합쳤을시 10 초과나 미만일시 예외처리
        List<SelFullNoticeVo> noticelist = mapper.getFullNoticelist(dto);
        if (noticelist.size() == 0) {
            throw new RestApiException(AuthErrorCode.NOT_IMPORTED);
        }
        List<SelFullNoticeVo> voList = new ArrayList<>();
        voList.addAll(noticeFix);
        voList.addAll(noticelist);
        if(voList.size()>10){
            throw new RestApiException(AuthErrorCode.OVER_FIX_NOTICE);
        }

        return voList;
    }

    //우선 받은값들을 가져와서 사진여러개를 공지사항 안에 넣어줘야함
    //개별게시판 조회
    public SelNoticeVo getFullNotice(int iFullNotice) {
        SelNoticeVo notice = mapper.getNotice(iFullNotice);
        List<String> pics = mapper.selNoticePic(iFullNotice);
        notice.setPics(pics);




        return notice;
    }


}
