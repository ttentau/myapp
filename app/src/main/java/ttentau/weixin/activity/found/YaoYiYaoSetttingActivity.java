package ttentau.weixin.activity.found;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.MenuItem;

import ttentau.weixin.R;
import ttentau.weixin.activity.BaseActivity;

/**
 * Created by ttent on 2017/2/13.
 */
public class YaoYiYaoSetttingActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yao_yi_yao_setting);
		ActionBar ab = getSupportActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
		ab.setTitle("摇一摇设置");
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home :
				finish();
				overridePendingTransition(R.anim.finish_enter_anim, R.anim.finish_exit_anim);
				break;
		}
		return true;
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch ( keyCode) {
			case KeyEvent.KEYCODE_BACK :
				finish();
				overridePendingTransition(R.anim.finish_enter_anim, R.anim.finish_exit_anim);
				break;
		}
		return true;
	}
}
