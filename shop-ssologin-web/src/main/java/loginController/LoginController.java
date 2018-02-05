package loginController;

import interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.CookieUtils;
import vo.MessageResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "user/login",method = RequestMethod.POST)
    public MessageResult login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        MessageResult result = null;
        result = loginService.loginByPassword(username,password);
        //登陆成功，把用户信息写入cookie
        if(result.isSuccess()){
            String token = result.getData().toString();
            //写入cookie
            CookieUtils.setCookie(request,response,"tt_token",token);
        }
        return result;
    }
}
