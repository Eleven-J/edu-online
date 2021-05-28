package com.bupt.service_edu.controller;

import com.bupt.commonutils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class UserLoginController {
    @RequestMapping("/login")
    public R userLogin(){

        return R.ok().data("token","1108");
    }

    @RequestMapping("/info")
    public R userInfo(){
        return R.ok().data("roles","root").data("name","eleven").data("avatar","https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201903%2F15%2F20190315004339_nWjPf.thumb.700_0.jpeg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1623422760&t=fc146b8aeddcd8c66b742dc59971d2f7");
    }
}
