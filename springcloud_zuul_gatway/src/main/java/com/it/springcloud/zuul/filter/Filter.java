package com.it.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 网关过滤器的基本使用
 */
@Component
public class Filter extends ZuulFilter {

    @Autowired
    private HttpServletRequest request;

    /**
     * 设置过滤器的类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 设置过滤器执行的优先级，值越小越先执行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 3;
    }

    /**
     * 是否使用过滤器
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {

        String requestURI = request.getRequestURI();
        System.out.println("URI：" + requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("URL：" + requestURL);
        //如果请求的是这个资源路径就进行拦截
        if ("/api/v1/gatway/data/product/findAllProductPage/0/2".equals(requestURI)) {
            return true;
        }
        return false;
    }

    /**
     * 过滤器拦截的具体业务
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        String token = request.getHeader("token");
        String cookie = request.getHeader("cookie");
        RequestContext currentContext = RequestContext.getCurrentContext();
        System.out.println("token：" + token);
        System.out.println("cookie：" + cookie);
        if (StringUtils.isBlank(token)) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            System.out.println("由于token值为空被拦截了。。。。。");
            return "token值为空";
        }
        return null;
    }
}
