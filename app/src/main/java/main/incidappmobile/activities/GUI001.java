package main.incidappmobile.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.logging.Logger;

import exceptions.ReadException;
import main.incidappmobile.Threads.UserThread;
import main.incidappmobile.factories.LogicFactory;
import main.incidappmobile.interfaces.iUser;
import main.incidappmobile.javabeans.UserBean;

public class GUI001 extends AppCompatActivity implements View.OnClickListener {

    private TextView txtUser;
    private TextView txtPassword;
    private EditText editTxtUser;
    private EditText editTxtPassword;
    private Button btnLogIn;
    private TextView txtRegister;
    private boolean error=false;
    private String errorContext="";
    private iUser iuser = LogicFactory.getiUser();

    private static final Logger logger = Logger.getLogger("LogInController");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gui001li);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gui001li);
        editTxtUser = findViewById(R.id.txtUser);
        editTxtPassword = findViewById(R.id.txtPassword);
        btnLogIn = findViewById(R.id.btnLogIn);
        txtRegister = findViewById(R.id.txtRegister);

        btnLogIn.setOnClickListener(this);
        txtRegister.setOnClickListener(this);

        editTxtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)  {
                handleTextChanged();
            }
        });

        editTxtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                handleTextChanged();
            }
        });
    }

    /**
     * Method that calls the method logIn when the btnLogIn is clicked
     * @param v
     */
    @Override
    public void onClick(View v) {
        if(btnLogIn.isPressed()){
            logIn();
        }else {
            signUp();
        }

    }

    public void handleTextChanged() {
        if(editTxtUser.getText().toString().trim().isEmpty() ||
                editTxtPassword.getText().toString().trim().isEmpty()){
            btnLogIn.setEnabled(false);
        }else {
            btnLogIn.setEnabled(true);
        }
    }


    /**
     * Method that creates a new User with the data in the User and Password fields and send it.
     * Catch wrong login/password, shows an alert and changes the color of the wrong field.
     */
    private void logIn() {
        UserBean user = new UserBean();
        user.setLogin(editTxtUser.getText().toString());
        user.setPassword(editTxtPassword.getText().toString());
        try {
            UserThread tc = new UserThread(user, "login");
            tc.setUncaughtExceptionHandler(this::uncaughtException);
            tc.start();
            tc.join();
            if(!error){
                user = tc.getUser();
                logInUser(user);
            }else{
                Toast toast = Toast.makeText(this, errorContext, Toast.LENGTH_SHORT);
                toast.show();
            }
            error=false;
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param thread
     * @param t
     */
    @Override
    public void uncaughtException(Thread thread, Throwable t) {
        error=true;
        if(t.getCause() instanceof ReadException){
            txtUser.setTextColor(Color.parseColor("#ff0000"));
            txtPassword.setTextColor(Color.parseColor("#237bf7"));
            errorContext="Login doesn't exist";
        } else if (t.getCause() instanceof Exception) {
            txtUser.setTextColor(Color.parseColor("#237bf7"));
            txtPassword.setTextColor(Color.parseColor("#237bf7"));
            errorContext="An error have occurred.";
        }
    }


    /**
     * Method that shows the logOut window
     * @param user
     */
    private void logInUser(UserBean user){
        Intent intent = new Intent(this, GUI010.class);
        intent.putExtra("username", user.getFullName());
        //setResult(RESULT_OK, intent);
        startActivity(intent);
        finish();
    }

    private void signUp() {
        Intent intent = new Intent(this, GUI002.class);
        startActivity(intent);
    }
}
