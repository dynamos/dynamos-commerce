package com.dynamos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by adelmo on 2/14/16.
 */
@Controller
@RequestMapping(value = "/layout")
public class LayoutController {


    @RequestMapping(method = RequestMethod.GET)
    public String returnView(@RequestParam("view") String viewName) {
        return viewName;
    }
}
