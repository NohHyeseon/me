package com.me.preschoolme.parent;

import com.me.preschoolme.common.ResVo;
import com.me.preschoolme.parent.model.CodeDto;
import com.me.preschoolme.parent.model.CodeVo;
import com.me.preschoolme.parent.model.ParentUpdDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/parent")
public class ParentController {
    private final ParentService service;

    @GetMapping("/code")
    public CodeVo getMatch(@RequestBody CodeDto dto){
        return service.getMatch(dto);
    }


    @PostMapping("/signup")
    public ResVo postSignup(@RequestBody ParentUpdDto dto){
        return service.postSignup(dto);
    }

}
