/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.*;


public class Config extends HttpServlet {
        
	private static final long serialVersionUID = 13574532L;

	public void init(ServletConfig config) throws ServletException {
            System.out.println("Start!");
            System.out.println("Start!");
            System.out.println("Start!");
            System.out.println("Start!");
            System.out.println("Start!");
            System.out.println("Start!");
            
            
            String jdbcDriverName = config.getInitParameter("DriverName");
            String jdbcUrl = config.getInitParameter("Url");
            String jdbcUserName = config.getInitParameter("UserName");
            String jdbcPassword = config.getInitParameter("Password");
            String adminLogin = config.getInitParameter("AdminLogin");
            String adminPassword = config.getInitParameter("AdminPassword");


        AdminCredentials.setLogin(adminLogin);
        AdminCredentials.setPassword(adminPassword);
    }
}
