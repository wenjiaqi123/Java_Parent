package com.gsm.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * zuul网关过滤器
 */
@Component
@SuppressWarnings("all")
public class ManagerFilter extends ZuulFilter {
    @Override
    public String filterType() {
        /**
         * 返回值有4种
         * pre      路由请求前调用
         * route    路由请求时调用
         * post     在route和error过滤器之后调用
         * error    处理请求发生错误时调用
         */
        return "pre";
    }

    @Override
    public int filterOrder() {
        /**
         * 当有多个过滤器，返回值越小优先级越高
         */
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        /**
         * 是否启用该过滤器
         * true     表示启用
         * false    表示弃用
         */
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        /**
         * 过滤器的具体逻辑
         */
        //得到Request上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //得到request域
        HttpServletRequest request = currentContext.getRequest();
        //得到头信息
        String header = request.getHeader("Authorization");
        //判断是否有头信息
        if (header != null && !"".equals(header)) {
            //头信息转发
            currentContext.addZuulRequestHeader("Authorization", header);
        }
        //终止运行
        //requestContext.setSendZuulResponse(false);
        return null;
    }
}
