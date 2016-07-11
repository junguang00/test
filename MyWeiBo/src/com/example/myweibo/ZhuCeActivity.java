package com.example.myweibo;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.RequestSMSCodeListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ZhuCeActivity extends Activity {
	private Button bt;
	private EditText et;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhuce);	
//		Bmob.initialize(this, "a3c34d118212065e18ead9004aca9107");
		bt = (Button) this.findViewById(R.id.zhece_yanzhengma);
		et = (EditText) this.findViewById(R.id.zhuce_et);
	}

	public void yanZhengOnClick(View v) {
		BmobSMS.requestSMSCode(this, et.getText().toString().trim(), "haha",new RequestSMSCodeListener() {
//
////		    @Override
////		    public void done(Integer smsId,BmobException ex) {
////		        // TODO Auto-generated method stub
////		        if(ex==null){//验证码发送成功
////		            Log.i("bmob", "短信id："+smsId);//用于查询本次短信发送详情
////		        }
////		    }
//
			@Override
			public void done(Integer smsId,BmobException ex) {
				// TODO Auto-generated method stub
				if(ex==null){
					System.out.println("bmob,"+"短信Id:"+smsId);
				}
			}
		});
	}
}
