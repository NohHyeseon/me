package com.me.preschoolme.full_notice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "공지사항")
public class SelFullNoticeFixVo {
    private int fullNoticeFix;
}
