package cc.iszjq.demo.controller;

import cc.iszjq.demo.entity.User;
import cc.iszjq.demo.service.UserService;
import cc.iszjq.demo.utiles.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    //正常访问login页面
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //表单提交过来的路径
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public String checkLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model) {
        //调用service方法
        User user = userService.checkLogin(userName, password);
        //若有user则添加到model里并且跳转到成功页面
        if (user != null) {
            model.addAttribute("user", user);
            return "success";
        }
        return "fail";
    }

    //测试超链接跳转到另一个页面是否可以取到session值
    @RequestMapping("/anotherPage")
    public String hrefPage() {
        return "anotherPage";
    }

    //注销方法
    @RequestMapping("/outLogin")
    public String outLogin(HttpSession session) {
        //通过session.invalidata()方法来注销当前的session
        session.invalidate();
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/doRegister")
    public String doRegister(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model) {
        /* password = MD5Util.encodeToHex(userName + password + "salt");*/
        User user = new User(userName, password);
        if (userService.register(user) > 0) {
            model.addAttribute("user", user);
            return "success";
        } else
            return "fail";
    }

    @RequestMapping("/checkName")
    @ResponseBody
    public int checkName(String userName) {
        return userService.checkName(userName);
    }
}
