/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.incidappmobile.implementations;

import interfaces.iFTP;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Jon Gonzalez
 */
public class FTPCliente implements iFTP{
    /**
     * The logger for the desktop app
     */
    protected static final Logger LOGGER = Logger.getLogger("incidappdesktop");
    private FTPClient ftpclient = new FTPClient();
    private ResourceBundle properties;

    @Override
    public void login() {
        LOGGER.info("Beginning login");
        properties = ResourceBundle.getBundle("properties.ftpClientProperties");
        try {
            ftpclient.connect(properties.getString("ftpserver"));
            ftpclient.login(properties.getString("ftpuser"), properties.getString("ftppassword"));
            ftpclient.changeWorkingDirectory(properties.getString("ftpdirectory"));
        } catch (IOException ex) {
            Logger.getLogger(FTPCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOGGER.info("Ending login");
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showFiles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeDirectory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void downloadFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
