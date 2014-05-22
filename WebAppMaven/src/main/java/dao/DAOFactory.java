/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.DB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class DAOFactory {
    
    public enum ConnTypes{
        DriverManagerJDBC, DataSourceJDBC, DataSourceConnPool
    }

    public static DAOFactory getDAOFactory(ConnTypes connType){
    	ApplicationContext context = new ClassPathXmlApplicationContext
    			(new String[] {"daos.xml"});
    	
        switch(connType){
            case DriverManagerJDBC:  
                return context.getBean(DriverManagerDAOJDBCFactory.class); 
            case DataSourceJDBC:
                return context.getBean(DataSourceDAOJDBCFactory.class);
            //case DataSourceConnPool:
            //    return  new DataSourceConnPoolFactory();
            default: return null;
        }
    };
       
    public abstract DB getConnection();

    public abstract ProductDAO getProductDAO();  
}
