/*
 To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSourceDAOJDBCFactory extends DAOFactory {
	private String serverName;
	private Integer portNumber;
	private String databaseName;
	private String user;
	private String password;
        private Map<String, String> shards;

    public Map<String, String> getShards() {
        return shards;
    }

    public void setShards(Map<String, String> shards) {
        this.shards = shards;
    }
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
            mongo = new MongoClient(serverName, portNumber);
        } catch (UnknownHostException ex) {
            Logger.getLogger(DataSourceDAOJDBCFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        DB ds = null;
        
        if(mongo!=null) {
            ds = mongo.getDB(databaseName);
            for(String shardName : shards.keySet()) {
                ds.command(new BasicDBObject("addShard", (shardName+":"+shards.get(shardName))));
            }
            if(shards.size() > 0) {
                ds.command(new BasicDBObject("enablesharding", "products"));
            }
        }
        
        return ds;
    }


	@Override
	public ProductDAO getProductDAO() {
            return new ProductDAOJDBC(this);
	}
}
