/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Product;


public interface ProductDAO {
    //LiProductser> findAll();
    boolean createProduct(Product product);
    boolean update(String barCode, String information);
    boolean delete(String barCode);
    Product getByBarcode(String barCode);
}
