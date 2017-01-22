package lisc.com.happynewyear;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerlayout;
    private NavigationView navigation;
    private Toolbar toolbar;
    //创建一个Drawerlayout和Toolbar联动的开关
    private ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        //设置标题
//        toolbar.setTitle("首页");
        //设置Drawerlayout的开关,并且和Home图标联动
        toggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, 0, 0);
        drawerlayout.addDrawerListener(toggle);
        //同步drawerlayout的状态
        toggle.syncState();
        //设置侧滑菜单MenuItem点击事件
        drawerlayout.closeDrawers();//关闭抽屉
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
    }

    private void initView() {
        //初始化View
        drawerlayout = (DrawerLayout) findViewById(R.id.main_drawer);
        navigation = (NavigationView) findViewById(R.id.main_navigation);
        toolbar =   (Toolbar) findViewById(R.id.main_toolbar);

    }
}
