package com.me.preschoolme.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor //기본생성자
public class ResVo {
    private int result;
    private int isValid;
    private String message;
}
