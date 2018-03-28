package com.wst.firecheck;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.lidroid.xutils.util.LogUtils;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;
import com.wst.firecheck.model.User;
import com.wst.firecheck.utils.*;
/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });


    }
    private void attemptLogin() {
        mEmailView.setError(null);
        mPasswordView.setError(null);
        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel =false;
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            cancel=true;
        }
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            cancel=true;
        }
        if(cancel) {
            return;
        }
        String md5pwd=MD5Utils.encode(password+"fc2017");
        MyOkHttp client=new MyOkHttp();
        client.get()
                .url("http://192.168.0.105:8080/api/User/Login")
                .addParam("userName",email)
                .addParam("password",md5pwd)
                .tag(this)
                .enqueue(new RawResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, String response) {
                        User user= JSON.parseObject(response,User.class);//反序列化
                        if(user.getName()!=null)
                        {
                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                            intent.putExtra("user",response);
                            startActivity(intent);
                            finish();
                        }else{
                            Alert();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        LogUtils.d(error_msg);
                    }
                });
    }
    private void Alert()
    {
        new AlertDialog.Builder(this)
                .setTitle("登录失败")
                .setMessage("用户名或密码无效!")
                .setPositiveButton("确定",null)
                .show();
    }
}

