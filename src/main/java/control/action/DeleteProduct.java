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


public class DeleteProduct implements Action {


    public String execute(HttpServletRequest request, HttpServletResponse response) {
         DAOFactory daoFactory = DAOFactory.getDAOFactory(ConnTypes.DataSourceJDBC);
         ProductDAO productDAO = daoFactory.getProductDAO();
         productDAO.delete(request.getParameter("barcode"));
         return "Deleted";
    }
    
}
