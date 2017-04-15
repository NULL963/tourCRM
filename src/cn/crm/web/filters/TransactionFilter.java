package cn.crm.web.filters;

import cn.crm.utils.jdbcUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by LEMON on 2017/4/15.
 */
public class TransactionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        try {
            chain.doFilter(request, response);
            //��ȡ��ǰ�߳��ϵ����� �ύ����ر����� �ͷ������뵱ǰ�̵߳İ�
            jdbcUtils.CommitTransaction();
        } finally {
            jdbcUtils.closeConnection();
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
