package com.me.preschoolme.parent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ParentSigninDto {
    @JsonIgnore
    private int ikid;
    @JsonIgnore
    private int iparent;
    private String uid;
    private String upw;



}
