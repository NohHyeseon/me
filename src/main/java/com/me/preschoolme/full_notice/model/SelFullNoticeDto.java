package com.me.preschoolme.full_notice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.me.preschoolme.common.Const;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SelFullNoticeDto {
    @JsonIgnore//시큐리티 쓰면 지울 거
    private int ilevel;
    @Schema(title="상단고정")
    private int fullNoticeFix;
    @Schema(title="페이지")
    private int page;
    @JsonIgnore
    private int starIdx;
    @JsonIgnore
    private int row= Const.FEED_COUNT_PER_PAGE;




    public void setPage(int page){

        this.starIdx=(page-1)*row;
    }
}

