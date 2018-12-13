package springexample.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;

import springexample.main.constants.CommonConstants;

public class BaseController {
	
	@Autowired
    private HttpServletRequest request;
  
	
	protected boolean isXmlRequested() {
        String accept = request.getHeader(HttpHeaders.ACCEPT);

        if (!StringUtils.isEmpty(accept) && (accept.toLowerCase().contains(CommonConstants.XML))) {
            return true;
        }

        if (request.getRequestURI().endsWith("." + CommonConstants.XML)) {
            return true;
        }
        String queryParameter = request.getParameter(CommonConstants.FORMAT_QUERY_PARAMETER);

        return CommonConstants.XML.equalsIgnoreCase(queryParameter);
    }

}
