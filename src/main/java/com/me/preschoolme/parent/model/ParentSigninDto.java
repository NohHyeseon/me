package com.me.preschoolme.parent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ParentSigninDto {

    private String uid;
    private String upw;
    @JsonIgnore
    private int iparent;

}
