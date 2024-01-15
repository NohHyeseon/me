package com.me.preschoolme.common;

import lombok.Data;

@Data
public class Const {
    public static final int NOTICE_COUNT_PER_PAGE = 10;


    public static final int FAIL = -1;
    public static final int SUCCESS = 1;

    public static final int LOGIN_NO_UID = 2;
    public static final int LOGIN_DIFF_UPW = 3;
    public static final String RUNTIME_EX_MESSAGE ="제공된 데이터가 충분하지 않음";
    String BAD_INFO_EX_MESSAGE = "잘못된 요청 데이터";


}
