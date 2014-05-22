/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DriverManagerDAOJDBCFactory extends DAOFactory{
	private String url;
	private String user;
	private String password;
        private MongoClient mongo = null;
    
	public void setUrl(String url){
		this.url = url;
	}
	
	public void setUser(String user){
		this.user = user;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
    @Override
    public DB getConnection() {
            if (mongo != null) {
                return mongo.getDB(url);
            }
            try {
                mongo = new MongoClient();
            } catch (UnknownHostException ex) {
                Logger.getLogger(DriverManagerDAOJDBCFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println();
        System.out.println();
        System.out.println("Client created!");
        System.out.println();
        System.out.println();
        DB db = null;
        if (mongo != null) {
            db = mongo.getDB(url);
        }
            
        return db;
        //return DriverManager.getConnection(url, user, password);
    }

    @Override
    public ProductDAO getProductDAO() {
        return new ProductDAOJDBC(this);
    }

}
