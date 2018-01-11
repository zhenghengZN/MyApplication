package Utils;

import android.app.Activity;
import android.app.Application;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;



/**
 * function: Application的基类
 * 
 * @author:linhuan
 */
public class BaseApplication extends Application {
	
	private static final String TAG = BaseApplication.class.getSimpleName();
	
	private static BaseApplication sInstance;
	private List<WeakReference<Activity>> activities = new LinkedList<WeakReference<Activity>>();

	public static BaseApplication getInstance() {

		if (Helper.isNull(sInstance)) {
//			Log.e(TAG, "THE APPLICATION OF YOUR PROJECT MUST BE 'so.bubu.ui.test.myapplication.BaseApplication', OR SOMEONE EXTEND FROM IT");
		}
		return sInstance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
		sInstance = this;
	}



}
