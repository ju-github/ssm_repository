package com.xian.controller;

import com.xian.domain.Permission;
import com.xian.domain.Role;
import com.xian.domain.UserInfo;
import com.xian.service.IRoleService;
import com.xian.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserService userService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList",roleList);
        return "role_list";
    }

    @RequestMapping("/save")
    public String  save(Role role){
        roleService.save(role);
        return "redirect:findAll";
    }


    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(String id,Model model){
        UserInfo userInfo = userService.findById(id);
        List<Role> roleList =   roleService.findOtherRole(id);
        model.addAttribute("user",userInfo);
        model.addAttribute("roleList",roleList);
        return "user-role-add";

    }

    @RequestMapping(value = "/addRoleToUser")
    public String addRoleToUser(@RequestParam(name="userId") String userId, @RequestParam(name = "ids") String[] ids){
        roleService.addRoleToUser(userId,ids);
        return "redirect:findAll";


    }

    @RequestMapping(value = "/findRoleByIdAndAllPermission")
    public String findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId,Model model){
        Role role=roleService.findById(roleId);
        List<Permission> permissionList=roleService.findOtherPermission(roleId);
        model.addAttribute("role",role);
        model.addAttribute("permissionList",permissionList);
        return "role-permission-add";

    }
    @RequestMapping(value = "/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleId,@RequestParam(name = "ids",required = true) String[] ids){
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll";
    }



}
