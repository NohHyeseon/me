package com.me.preschoolme.full_notice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.me.preschoolme.common.Const;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(title = "유치원 소식 전체 조회")
public class SelFullNoticeVo {
    private String fullTitle;
    private int writer;
    private int fullNoticeFix;
    private String createdAt;


}
