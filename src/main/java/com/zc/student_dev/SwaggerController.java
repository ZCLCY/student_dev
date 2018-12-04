package com.zc.student_dev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * swagger api首页.
 **/
@Controller
public class SwaggerController {
    @GetMapping(value = {"/api", "/", ""})
    public String api() {
        return "redirect:/swagger-ui.html";
    }
}
