/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import controller.Controller;
import model.Aplikasi;
import viewConsole.Console;

/**
 *
 * @author HANIZAR
 */
public class Tubes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Aplikasi apl = new Aplikasi();
        
        new Controller(apl);
        
        Console view1 = new Console(apl);
        view1.mainMenu();
    }
    
}
