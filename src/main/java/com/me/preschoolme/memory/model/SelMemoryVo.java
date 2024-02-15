package com.me.preschoolme.memory.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SelMemoryVo {
    private String memoryTitle;
    private String memoryContents;
    private List<String> memoryPic = new ArrayList<>(); //빈방 만들어줌

}
