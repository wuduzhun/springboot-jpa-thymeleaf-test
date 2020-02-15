package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    // 展示用户列表
    @RequestMapping("/")
    public String findAll(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "list";
    }
    // 跳转新增页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }
    // 保存增加的方法
    @RequestMapping("/save")
    public String save(User user){
        userService.add(user);
        return "redirect:/";   // 跳转到列表页  内部根目录
    }

    /**
     * 跳转到用户编辑页面
     */
    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Long id,Model model){
        User user = userService.findOne(id);
        model.addAttribute("user",user);
        //跳转到编辑页面
        return "edit";
    }

    /**
     * 修改保存用户信息
     * @param user
     * @return
     */
    @RequestMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/";
    }

    /**
     * 删除指定id用户信息
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/";
    }
}
