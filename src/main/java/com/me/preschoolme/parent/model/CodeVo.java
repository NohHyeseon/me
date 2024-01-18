package com.me.preschoolme.parent.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Schema(title = "코드인증 후 아이정보")
public class CodeVo {
    private String  code;
    private int ikid;
    private String kidNm;
    private int iclass;



}
