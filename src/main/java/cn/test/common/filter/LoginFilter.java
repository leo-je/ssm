package cn.test.common.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.test.common.dao.CommonDao;

/** 
 * @Type LoginFilter.java 
 * @Desc 用于自定义过滤器，过滤用户请求时是否是登录状态 
 * @author 
 * @date 
 * @version  
 */ 
public class LoginFilter extends AuthorizationFilter {

	@Autowired
	public CommonDao dao;

	@SuppressWarnings("deprecation")
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object object) throws Exception {
		System.out.println(new Date().toLocaleString()+"  LoginFilter 检测："+"isAccessAllowed");
		Subject subject = getSubject(request, response);
		if (null != subject.getPrincipals()) {
			return true;
		}
		return false;
	}

	/**
	 * 会话超时或权限校验未通过的，统一返回401，由前端页面弹窗提示
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		System.out.println(new Date().toLocaleString()+"  LoginFilter 检测："+"会话超时或权限校验未通过的");
		if (isAjax((HttpServletRequest) request)) {
			WebUtils.toHttp(response).sendError(401);
		} else {
			String unauthorizedUrl = getUnauthorizedUrl();
			if (StringUtils.hasText(unauthorizedUrl)) {
				WebUtils.issueRedirect(request, response, unauthorizedUrl);
			} else {
				WebUtils.toHttp(response).sendError(401);
			}
		}
		return false;
	}

	private boolean isAjax(HttpServletRequest request) {
		String header = request.getHeader("x-requested-with");
		if (null != header && "XMLHttpRequest".endsWith(header)) {
			return true;
		}
		return false;
	}

}
