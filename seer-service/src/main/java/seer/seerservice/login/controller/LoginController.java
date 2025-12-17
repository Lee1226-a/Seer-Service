package seer.seerservice.login.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seer.seerservice.login.model.User;


/**@RestController是Spring框架中的一个组合注解，本质上是@Controller和@ResponseBody的合并。
 * 它的核心作用是将类标记为Web请求处理器，且所有方法的返回值会自动序列化为JSON/XML响应体。
 */
@RestController
@RequestMapping("/Login")
public class LoginController {

    /**
     * @RequestMapping是Spring框架中用于映射Web请求的核心注解，
     * 主要用于定义控制器方法的URL路径和请求方式。以下是关键要点：
     * 定义基础路径，所有方法路径会继承该路径
     * 支持细粒度路径和HTTP方法限定：@RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
     *
     */
    @RequestMapping("/updateEmp")
    public String updateEmp(@RequestBody User user) {
        boolean editFlag = false;
        if (editFlag) {
            return "success";
        }else {
            return "error";
        }
    }
}
