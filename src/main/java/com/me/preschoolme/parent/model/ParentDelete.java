package com.me.preschoolme.parent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "Parent isDel 처리")
public class ParentDelete {
    private int iparent;
    private int isdel;
}
