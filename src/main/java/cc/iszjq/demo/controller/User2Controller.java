package cc.iszjq.demo.controller;

import cc.iszjq.demo.entity.User2;
import cc.iszjq.demo.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user2")
public class User2Controller {

    @Autowired
    private User2Service user2Service;

    @RequestMapping("/register")
    public String register() {
        return "register2";
    }

    @RequestMapping("/doRegister")
    public String doRegister(User2 user2, Model model) throws Exception {
        model.addAttribute("msg", "你已经注册成功了，快去邮箱激活吧");
        user2Service.register(user2);
        return "message";
    }

    @RequestMapping("/active/{code}")
    public String active(@PathVariable String code, Model model) {
        System.out.println(code);
        User2 user2 = user2Service.findByCode(code);
        if (user2 != null) {
            model.addAttribute("msg", "激活成功");
            return "message";
        } else {
            model.addAttribute("msg", "激活失败，请重试");
            return "message";
        }

    }
}
