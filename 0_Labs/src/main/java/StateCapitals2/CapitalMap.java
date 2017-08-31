/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateCapitals2;


/**
 *
 * @author jeffc
 */
public class CapitalMap {
    public void meetSpecs() {
        CapitalMapMethods capMapMeth = new CapitalMapMethods();
        
        capMapMeth.initializeCaptials();
        capMapMeth.instantiateCapitals();
        capMapMeth.printStateCapitalPairs();
        capMapMeth.printStateCapitalPairsOver();
        
    }
}
