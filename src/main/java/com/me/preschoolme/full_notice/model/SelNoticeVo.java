package com.me.preschoolme.full_notice.model;

import lombok.Data;

import java.util.List;

@Data
public class SelNoticeVo {
    private String fullTitle;
    private String fullContents;
    private String writer;
    private String createdAt;
    private List<String> pics;
}
