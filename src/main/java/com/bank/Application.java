package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author: QQ:553039957
 * @Date: 2023/9/25 15:24
 * @Description:
 * 1. gitcode主页： https://gitcode.net/tbb414 （推荐）
 * 2. github主页：https://github.com/doudoutangs
 * 3. gitee(码云)主页：https://gitee.com/spdoudoutang
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
        System.out.println("银行OA启动成功啦！！");
        System.out.println(" * 0. QQ:553039957\n" +
                " * 1. gitcode主页： https://gitcode.net/tbb414 （推荐）\n" +
                " * 2. github主页：https://github.com/doudoutangs\n" +
                " * 3. gitee(码云)主页：https://gitee.com/spdoudoutang");
    }
}