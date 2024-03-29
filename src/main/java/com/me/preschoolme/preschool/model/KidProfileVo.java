package com.me.preschoolme.preschool.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "원아 정보 불러오기")
public class KidProfileVo {
    @Schema(title = "반 PK")
    private int iclass;
    @Schema(title = "아이 이름")
    private String kidNm;
    @Schema(title = "아이 사진")
    private String profile;
}
