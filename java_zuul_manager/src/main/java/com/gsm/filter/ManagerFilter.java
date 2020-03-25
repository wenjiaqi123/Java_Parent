package com.gsm.filter;

import com.gsm.utils.JwtUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * zuul网关过滤器
 */
@Component
@SuppressWarnings("all")
public class ManagerFilter extends ZuulFilter {
    @Autowired
    private JwtUtils jwtUtils;
    @Value("${jwt.saltKey}")
    private String saltKey;
    @Autowired
    private HttpServletResponse response;

    @Override
    public String filterType() {
        //改变同源策略，允许任意源请求
        response.setHeader("Access-Control-Allow-Origin", "*");
        //改变同源策略，允许任意请求方式
        response.setHeader("Access-Control-Allow-Methods", "*");
        //改变同源策略，允许任意请求头
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        //浏览器缓存预检请求时长 单位秒 24 * 60 * 60 = 86400 一天
        response.setHeader("Access-Control-Max-Age", "600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
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
         * 过滤器的具体逻辑，返回任何值都是放行，
         *  //终止运行
         *  currentContext.setSendZuulResponse(false);
         */
        //得到Request上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //得到request域
        HttpServletRequest request = currentContext.getRequest();

        if(request.getMethod().equals("OPTIONS")){
            return null;
        }
        if(request.getRequestURI().indexOf("login")>0){
            return null;
        }

        //得到头信息
        String authorization = request.getHeader("Authorization");
        //判断是否有头信息
        if (authorization != null && !"".equals(authorization)) {
            Claims claims = null;
            try {
                //解析 token
                claims = jwtUtils.parseJwt(authorization);
                //获取过期时间
                Date expiration = claims.getExpiration();
                //如果过期时间在当前时间之前，
                if(expiration.before(new Date())){
                    //终止运行
                    currentContext.setSendZuulResponse(false);
                }
                //头信息转发
                currentContext.addZuulRequestHeader("Authorization", authorization);
                return null;
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Authorization 非法");
                //终止运行
                currentContext.setSendZuulResponse(false);
            }
        }

        //终止运行
        currentContext.setSendZuulResponse(false);
        currentContext.setResponseStatusCode(403);
        currentContext.setResponseBody("权限不足");
        currentContext.getResponse().setContentType("application/json;charset=utf-8");
        return null;
    }
}
