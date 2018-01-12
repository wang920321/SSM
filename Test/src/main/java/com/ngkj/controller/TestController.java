package com.ngkj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ngkj.commons.base.BaseController;

/**
 * 测试Controller
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    /**
     * 图标测试
     *
     * @return
     */
    @GetMapping("/dataGrid")
    public String dataGrid() {
        return "admin/test";
    }

}
