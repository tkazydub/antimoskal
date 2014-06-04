/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.action;

import dao.DAOFactory;
import dao.DAOFactory.ConnTypes;
import dao.ProductDAO;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author Alexandr
 */
public class SendToClient implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        DAOFactory daoFactory = DAOFactory.getDAOFactory(ConnTypes.DataSourceJDBC);
        ProductDAO productDAO = daoFactory.getProductDAO();
        
        Product product = productDAO.getByBarcode(request.getParameter("barcode"));
        PrintWriter out = response.getWriter();
      
        out.println(product.getInformation());
        return null;
    }
    
}
