package com.xian.controller;

import com.xian.domain.Permission;
import com.xian.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping(value = "/findAll")
    public String findAll(Model model){
        List<Permission> permissionList = permissionService.findAll();
        model.addAttribute("permissionList",permissionList);
        return "permission_list";
    }

    @RequestMapping(value = "/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll";

    }
}
