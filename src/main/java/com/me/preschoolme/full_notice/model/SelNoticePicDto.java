package com.me.preschoolme.full_notice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SelNoticePicDto {
    @JsonIgnore
    private int ilevel;
    private List<String> pics = new ArrayList<>();
    private int iFullNotice;
}
