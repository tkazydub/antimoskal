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


public class AddProduct implements Action {


    public String execute(HttpServletRequest request, HttpServletResponse response) {
         DAOFactory daoFactory = DAOFactory.getDAOFactory(ConnTypes.DataSourceConnPool);
         ProductDAO productDAO = daoFactory.getProductDAO();
         Product newProduct = new Product();
         newProduct.setBarcode(request.getParameter("barcode"));
         newProduct.setInformation(request.getParameter("information"));
         if(productDAO.getByBarcode(newProduct.getBarcode()) != null){
        	 return "AlreadyExists";
         }
         productDAO.createProduct(newProduct);
         return "Registered";
    }
    
}
