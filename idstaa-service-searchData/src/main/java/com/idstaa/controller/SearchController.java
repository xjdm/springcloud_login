package com.idstaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author chenjie
 * @date 2021/1/7 14:30
 */
@RestController
public class SearchController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 注⼊RestTemplate
     *
     * @return
     */

    @GetMapping(value = "/search")
    public Object getWeiBoData(HttpServletRequest request) {
        /**
         * 调取微博的接口
         * https://m.weibo.cn/search?containerid=100103type=1&q=丁真
         *
         * https://m.weibo.cn/api/container/getIndex?containerid=100103type%3D1%26q%3D%25E4%25B8%2581%25E7%259C%259F&page_type=searchall&page=1
         */
        String url = "http://m.weibo.cn/api/container/getIndex?containerid=100103type%3D1%26q%3D%25E4%25B8%2581%25E7%259C%259F&page_type=searchall&page=1";
        String url2 = "http://localhost:8096/other/test/1";

        HttpHeaders requestHeaders = new HttpHeaders();
        List<String> cookieList = this.getCookieList();
        requestHeaders.put("Cookie", cookieList);
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, requestHeaders);
        Map body = restTemplate.exchange(url, HttpMethod.GET, requestEntity, HashMap.class).getBody();
        // Map<String,Object> forObject = restTemplate.getForObject(url, HashMap.class);

        // System.out.println(forObject);
        return body;

    }

    public static List<String> getCookieList() {
        List<String> cookieList = new ArrayList<>();
        String cookie = "_T_WM=47771115115; WEIBOCN_FROM=1110005030; MLOGIN=0; Hm_lvt_eaa57ca47dacb4ad4f5a257001a3457c=1610000228,1610001254,1610001300,1610001312; Hm_lpvt_eaa57ca47dacb4ad4f5a257001a3457c=1610003433; XSRF-TOKEN=cb667e; M_WEIBOCN_PARAMS=luicode%3D10000011%26lfid%3D100103type%253D1%2526q%253D%2525E4%2525B8%252581%2525E7%25259C%25259F%26fid%3D100103type%253D1%2526q%253D%2525E4%2525B8%252581%2525E7%25259C%25259F%26uicode%3D10000011";
        return Arrays.asList(cookie.split(";"));
    }
}
