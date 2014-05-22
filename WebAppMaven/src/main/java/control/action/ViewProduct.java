/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.action;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.DAOFactory.ConnTypes;
import dao.ProductDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

import util.AdminCredentials;


public class ViewProduct implements Action{
    public String execute(HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
       
        
        DAOFactory daoFactory = DAOFactory.getDAOFactory(ConnTypes.DataSourceJDBC);
        ProductDAO productDAO = daoFactory.getProductDAO();
        
        
        Product product = productDAO.getByBarcode(request.getParameter("barcode"));
        String page = "ViewProduct";
        
        request.setAttribute("product", product);
   
        return page;
    }
}