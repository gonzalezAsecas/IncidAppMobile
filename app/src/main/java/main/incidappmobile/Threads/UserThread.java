package main.incidappmobile.Threads;

public class UserThread extends Thread{

    private entities.UserBean user;

    private String action;

    public UserThread(UserBean user, String action){
        this.user=user;
        this.action=action;
    }

    public UserBean getUser(){
        return user;
    }

    @Override
    public void run(){
        if(){

        }
        //comprobar el action y crear la interfaz de user
    }
}
