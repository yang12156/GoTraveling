package gotravel.gotravaling;

/**
 * Created by sookmyung on 2017-10-01.
 */

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button buttonLogin, buttonSignUp;
    EditText editTextID, editTextPassword;
    TextView title, title2, title3;
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        // Set up the login form.
        initializeVariable();
        clickLoginButton();
        clickSignUpButton();

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Guardians.ttf");
        title.setTypeface(typeFace);
        title2.setTypeface(typeFace);
        title3.setTypeface(typeFace);
    }

    void initializeVariable() {
        buttonLogin = (Button)findViewById(R.id.loginButton);
        buttonSignUp = (Button)findViewById(R.id.signupButton);
        editTextID = (EditText)findViewById(R.id.IdInput);
        editTextPassword = (EditText)findViewById(R.id.passwordInput);
        title = (TextView)findViewById(R.id.titleText1);
        title2= (TextView)findViewById(R.id.titleText2);
        title3 = (TextView)findViewById(R.id.titleText3);
    }

    void clickLoginButton() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String inputID, inputPassword;
                //inputID = editTextID.getText().toString();
                //inputPassword = editTextPassword.getText().toString();
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });
    }

    void clickSignUpButton() {
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Join.class);
                startActivity(intent);

            }
        });
    }

    private boolean isLoginInputValid(String email, String password) {
        /*if(email.contains("@"))
            if(passward.length()>4)
                return true;*/
        if(email.equals("pizza") || email.equals("chicken2"))
            if(password.equals("pizza") || password.equals("chicken2"))
                return true;
        return false;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mID;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mID = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mID)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }
/*
        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;

            if (success) {
                finish();
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
        }
        */
    }

}
