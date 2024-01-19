package com.me.preschoolme.full_notice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.me.preschoolme.common.Const;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SelFullNoticeVo {

    private String fullTitle;
    private int writer;
    private int fullNoticeFix;
    private String createdAt;

}
