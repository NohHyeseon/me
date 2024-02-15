package com.me.preschoolme.memory;

import com.me.preschoolme.memory.model.SelMemoryVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/memory")
public class MemoryController {
    private final MemoryService service;

    @GetMapping("/eidt")
    public SelMemoryVo getMemoryEdit(@RequestParam int imemory){
        return service.selMemory(imemory);
    }

}
