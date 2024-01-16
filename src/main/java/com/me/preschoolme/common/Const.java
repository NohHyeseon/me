package com.me.preschoolme.common;

import lombok.Data;


public interface Const {
    public static final int NOTICE_COUNT_PER_PAGE = 10;


    public static final int FAIL = -1;
    public static final int SUCCESS = 1;
    String RUNTIME_EX_MESSAGE = "알 수 없는 오류로 실패";
    public static final int LOGIN_NO_UID = 2;
    public static final int LOGIN_DIFF_UPW = 3;

    String BAD_INFO_EX_MESSAGE = "잘못된 요청 데이터";


}
