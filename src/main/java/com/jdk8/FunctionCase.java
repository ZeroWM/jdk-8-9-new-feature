package com.jdk8;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class FunctionCase {
    /**
     * 接口类型：consumer supplier predicate  function
     * <p>
     * 区别：
     * consumer 泛型参数 不返回值
     * supplier 不传参 返回一个值
     * predicate 接口传一个参数 返回一个布尔值
     * function 接口传入一个参数，返回一个值
     */

    private HtmlImageURLProxier proxy;

    @Autowired
    public FunctionCase(HtmlImageURLProxier proxy) {
        this.proxy = proxy;
    }

    public void run() {
        proxy.process("http://www. baidu. com", src -> {
            return println(src);
        });
    }

    private String println(String word) {
        return word.trim();
    }
}


class HtmlImageURLProxierImpl implements HtmlImageURLProxier {

    @Override
    public String process(String content, Function<String, String> relativeUrlTransformer) {
        String finalStr = content + "?username = wm";
        relativeUrlTransformer.apply(content);
        return finalStr;
    }
}

interface HtmlImageURLProxier {
    String process(String content, Function<String, String> relativeUrlTransformer);
}
