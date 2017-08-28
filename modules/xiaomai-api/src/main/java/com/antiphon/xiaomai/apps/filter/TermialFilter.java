package com.antiphon.xiaomai.apps.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.List; 

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig; 
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.multipart.MultipartHttpServletRequest; 
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSONObject; 
import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.common.utils.JsonWriteUtils; 
import com.antiphon.xiaomai.modules.service.user.MemberManager;

public class TermialFilter implements Filter {
	private static Log logger = LogFactory.getLog(TermialFilter.class);
	@Autowired
	MemberManager accountService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				req.getSession().getServletContext());
		commonsMultipartResolver.setDefaultEncoding("utf-8");
		MultipartHttpServletRequest multipartRequest = null;
		String token = req.getParameter("token");
		boolean flag = true;
		if (commonsMultipartResolver.isMultipart(req)) {//判断是否form-data方式

			multipartRequest = commonsMultipartResolver.resolveMultipart(req);
			token = multipartRequest.getParameter("token");
		 
			flag = false;
		}

		 

		logger.info("请求路径:" + req.getRequestURI() + "----请求参数："
				+ JSONObject.toJSON(req.getParameterMap()));

		if (this.accountService.exsitTokenid(token)) {
			if (flag) {
				chain.doFilter(request, rep);
			} else {
				chain.doFilter(multipartRequest, response);
			}

		} else {
			BaseResponseDTO dto = new BaseResponseDTO(2, "登录信息已经失效！");
			JsonWriteUtils.setJson(JSONObject.toJSON(dto), rep);

		}

	}
 

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
