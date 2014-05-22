/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

import dao.DAOFactory;
import dao.ProductDAO;
import dao.DAOFactory.ConnTypes;


public class UpdateProduct implements Action {


    public String execute(HttpServletRequest request, HttpServletResponse response) {      
         DAOFactory daoFactory = DAOFactory.getDAOFactory(ConnTypes.DataSourceJDBC);
         ProductDAO productDAO = daoFactory.getProductDAO();
         
                         System.out.println();
                System.out.println();
                System.out.println(request.getParameter("information"));
                System.out.println();
                System.out.println();
         
         productDAO.update(request.getParameter("barcode"), request.getParameter("information"));
         
         return "Updated";
    }
    
}
