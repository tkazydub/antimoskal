/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.action;


import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


public class ActionFactory {

    private Map<String,Action> actions;
    /*static{
        actions = new HashMap<String, Action>();
        actions.put("/viewproduct", new ViewProduct());
        actions.put("/updateproduct", null);
    }*/
    

 
    ActionFactory(Map<String,Action> actions){
    	this.actions = actions;  
    }
    
    public Action getAction(HttpServletRequest request) {
        System.out.println(request.getPathInfo());
        return actions.get(request.getPathInfo());
    }
}
