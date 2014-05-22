/*
 To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSourceDAOJDBCFactory extends DAOFactory {
	private String serverName;
	private Integer portNumber;
	private String databaseName;
	private String user;
	private String password;
        private MongoClient mongo = null;
	
	public void setServerName(String serverName){
		this.serverName = serverName;
	}
	
	public void setPortNumber(Integer portNumber){
		this.portNumber = portNumber;
	}
	
	public void setDatabaseName(String databaseName){
		this.databaseName = databaseName;
	}
	
	public void setUser(String user){
		this.user = user;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
    @Override
    public DB getConnection() {
        try {
            mongo = new MongoClient();
        } catch (UnknownHostException ex) {
            Logger.getLogger(DataSourceDAOJDBCFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        DB ds = null;
        
        if(mongo!=null) {
            ds = mongo.getDB(databaseName);
        }
        
        return ds;
    }


	@Override
	public ProductDAO getProductDAO() {
            return new ProductDAOJDBC(this);
	}
}
