package loginController;

import interfaces.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vo.MessageResult;

@Controller
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @ResponseBody
    @RequestMapping(value = "/user/{token}",method = RequestMethod.GET)
    public MessageResult getUserByToken(@PathVariable("token")String token){
        return tokenService.getUserByToken(token);
    }
}
