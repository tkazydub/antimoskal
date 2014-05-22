/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.action;

import dao.DAOFactory;

/**
 *
 * @author Amdrii
 */
public class DataSourceDAOFactory {
    public static DAOFactory getDAOFactory(){
        return DAOFactory.getDAOFactory(DAOFactory.ConnTypes.DataSourceConnPool);
    }
}
