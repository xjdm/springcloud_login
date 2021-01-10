package com.idstaa;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.Date;

/**
 * @author chenjie
 * @date 2021/1/7 15:41
 */
public class FootProcessor implements PageProcessor {

    //抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(10).setSleepTime(1000);
    //博文数量
    private static int num = 0;
    //数据库持久化对象，用于将博文信息存入数据库
    public static void main(String[] args) throws Exception {
        long startTime ,endTime;
        System.out.println("========懂球帝小爬虫【启动】喽！=========");
        startTime = new Date().getTime();
        String url = "http://m.weibo.cn/api/container/getIndex?containerid=100103type%3D1%26q%3D%25E4%25B8%2581%25E7%259C%259F&page_type=searchall&page=1";
        Spider.create(new FootProcessor()).addUrl(url).thread(5).run();
        endTime = new Date().getTime();
        System.out.println("========懂球帝小爬虫【结束】喽！=========");
        System.out.println("一共爬用时为："+(endTime-startTime)/1000+"s");
    }


    @Override
    public void process(Page page) {
        String content1 = page.getHtml().get();
    }

    @Override
    public Site getSite() {

        return this.site;
    }

}
