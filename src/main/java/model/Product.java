/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Product {
    String barcode;
    String information;

   
    public void setBarcode(String barCode) {
        this.barcode = barCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setInformation(String informationAbout) {
        this.information = informationAbout;
    }

    public String getInformation() {
        return information;
    }

    
    @Override
    public String toString() {
        return "Product{" + "BarCode=" + barcode + ", Information=" + information + '}'+"\n";
    }
    
    
}
