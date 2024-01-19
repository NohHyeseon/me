package com.me.preschoolme.preschool.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "선생님 정보 불러오기")
public class TeacherProfileVo {
    @Schema(title = "반 PK")
    private int iclass;
    @Schema(title = "선생님 이름")
    private String teacherNm;
    @Schema(title = "선생님 사진")
    private String teacherProfile;
    @Schema(title = "선생님 소개")
    private String teacherIntroduce;
}
