package com.me.preschoolme.preschool;

import com.me.preschoolme.preschool.model.KidProfileVo;
import com.me.preschoolme.preschool.model.TeacherProfileVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PreschoolMapper {

    List<KidProfileVo> getKidProfile();
    List<TeacherProfileVo> getTeacherProfile();
}
