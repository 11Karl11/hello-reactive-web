package com.example.demo.test;

import com.zhangaochong.spring.starter.openapi.annotation.OpenApiAuth;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @author karl xie
 * Created on 2020-12-09 17:17
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @OpenApiAuth
    @PostMapping("secret")
    public String testSecret(@RequestBody AnnounceOperaDto param) {

        return "111";
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        String paramString = "accessKey=firefly&id=1&nonce=abcdef&secretKey=321&timestamp=1607565747979&type=3&userId=2";
        String sign = DigestUtils.md5Hex(paramString.toString().trim().getBytes("UTF-8"));
        System.out.println(sign);
    }
}