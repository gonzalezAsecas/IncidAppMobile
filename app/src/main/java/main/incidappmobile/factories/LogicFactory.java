/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.incidappmobile.factories;

import main.incidappmobile.implementations.IncidentImplementation;
import main.incidappmobile.implementations.LocationImplementation;
import main.incidappmobile.implementations.SignatureImplementation;
import main.incidappmobile.implementations.TownHallImplementation;
import main.incidappmobile.implementations.TypeImplementation;
import main.incidappmobile.implementations.UserImplementation;
import main.incidappmobile.interfaces.iLocation;
import main.incidappmobile.interfaces.iSignature;
import main.incidappmobile.interfaces.iTownHall;
import main.incidappmobile.interfaces.iType;
import main.incidappmobile.interfaces.iUser;
import main.incidappmobile.interfaces.iIncident;

/**
 *
 * @author Jon Gonzalez
 */
public class LogicFactory {
    public static iIncident getiIncident(){
        return new IncidentImplementation();
    }
    public static iLocation getiLocation(){
        return new LocationImplementation();
    }
    public static iSignature getiSignature(){
        return new SignatureImplementation();
    }
    public static iTownHall getiTownHall(){
        return new TownHallImplementation();
    }
    public static iType getiType(){
        return new TypeImplementation();
    }
    public static iUser getiUser(){
        return new UserImplementation();
    }
}
