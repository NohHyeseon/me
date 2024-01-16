package com.me.preschoolme.parent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ParentInsDto {
    @JsonIgnore
    private int ikid;
    @JsonIgnore
    private int iparent;
    private int irelation;
    private int isValid; // 중복체크가 되었는지 확인 (1: 문제없음, 나머지: 문제있음)
    private String parentNm;
    private String phoneNb;
    private String uid;
    private String upw;
    @JsonIgnore
    private String code;
    private int irank;
}
