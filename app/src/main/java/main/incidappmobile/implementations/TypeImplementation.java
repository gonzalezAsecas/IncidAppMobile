/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.incidappmobile.implementations;

import exceptions.ReadException;
import main.incidappmobile.interfaces.iType;
import java.util.List;
import main.incidappmobile.javabeans.TypeBean;

/**
 *
 * @author Jon Gonzalez
 */
public class TypeImplementation implements iType{
    @Override
    public List<TypeBean> findAllTypes() throws ReadException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
