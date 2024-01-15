package com.me.preschoolme.parent.model;

import lombok.Data;

@Data
public class ParentInsDto {

    private int isValid; // 중복체크가 되었는지 확인 (1: 문제없음, 나머지: 문제있음)
    private String parentNm;
    private String phoneNb;
    private String uid;
    private String upw;
    private String code; //ikid PK
    private int irank;
}
