/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
