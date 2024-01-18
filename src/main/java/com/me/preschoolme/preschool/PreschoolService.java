package com.me.preschoolme.preschool;

import com.me.preschoolme.preschool.model.KidProfileVo;
import com.me.preschoolme.preschool.model.TeacherProfileVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PreschoolService {
    private final PreschoolMapper mapper;

    public List<KidProfileVo> getKidProfile(){
        List<KidProfileVo> vo = mapper.getKidProfile();
        return vo;
    }

    public List<TeacherProfileVo> getTeacherProfile(){
        List<TeacherProfileVo> vo = mapper.getTeacherProfile();
        return vo;
    }



}
