package com.Kobiton.uiautomator;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.SdkSuppress;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnitRunner;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.Direction;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static  androidx.test.core.app.ApplicationProvider.getApplicationContext;
import androidx.test.rule.ActivityTestRule;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class UiAutomatorTesting {
    private  UiDevice mDevice;
    private  static final String PACKAGE_NAME_APP="io.github.hidroh.materialistic";
    //private  static final String PACKAGE_NAME_APP="com.lge.filemanager";
    private  static  final  int LAUNCH_TIMEOUT = 5000;
    private static  final  String STRING_TO_BE_TYPED = "UiAutomator";


    @Before
    public void StartMainActivityFromHomeScreen()
    {
        mDevice = UiDevice.getInstance(getInstrumentation());
        mDevice.pressHome();
        final String LauncherPackage = mDevice.getLauncherPackageName();
        assertThat(LauncherPackage,notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(LauncherPackage).depth(0)),LAUNCH_TIMEOUT);
        Context context = getApplicationContext();
        final Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME_APP);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        mDevice.wait(Until.hasObject(By.pkg(PACKAGE_NAME_APP).depth(0)),LAUNCH_TIMEOUT);
    }
    @Test
    public  void LoginAccount() throws  UiObjectNotFoundException
    {
        UiObject2 buttonMenu = mDevice.wait(Until.findObject(By.res("io.github.hidroh.materialistic:id/toolbar")),5000);
        List<UiObject2> listItem = buttonMenu.getChildren();
        if (listItem!=null) {
            listItem.get(0).click();

        }
        UiObject2 buttonLogin = mDevice.wait(Until.findObject(By.res("io.github.hidroh.materialistic:id/drawer_account")),5000);
        if(buttonLogin!=null && buttonLogin.isClickable()==true)
        {
            buttonLogin.click();
        }
        // Type name Account and Password

        UiObject2 textboxName = mDevice.wait(Until.findObject(By.res("io.github.hidroh.materialistic:id/edittext_username")),5000);
        UiObject2 textboxPass = mDevice.wait(Until.findObject(By.res("io.github.hidroh.materialistic:id/edittext_password")),5000);
        UiObject2 buttonSubmitLogin = mDevice.wait(Until.findObject(By.text("LOGIN")),5000);
        if(textboxName!=null && textboxName.isClickable()==true)
        {
          textboxName.setText("KobitonTesting");
        }
        else if(textboxPass!=null && textboxPass.isClickable()==true)
        {
            textboxPass.setText("12345678");
        }
        else if(buttonSubmitLogin.isClickable()==true)
        {
            buttonSubmitLogin.click();
        }

    }
    @Test
    public void Testing() throws UiObjectNotFoundException
    {

       UiObject2 buttonMenu = mDevice.wait(Until.findObject(By.res("io.github.hidroh.materialistic:id/toolbar")),5000);
        List<UiObject2> listItem = buttonMenu.getChildren();
       if (listItem!=null) {
           listItem.get(0).click();

       }
       UiObject2 buttonSetting = mDevice.wait(Until.findObject(By.res("io.github.hidroh.materialistic:id/drawer_settings")),5000);
       if(buttonSetting!=null)
       {

           buttonSetting.click();
       }
       else
       {
           UiObject2 layoutMenu = mDevice.wait(Until.findObject(By.res("io.github.hidroh.materialistic:id/drawer")),5000);
           if(layoutMenu!=null)
           {
               layoutMenu.scroll(Direction.DOWN,500,500);
               buttonSetting = mDevice.wait(Until.findObject(By.res("io.github.hidroh.materialistic:id/drawer_settings")),5000);
               buttonSetting.click();

           }

       }

       //mDevice.findObject(new UiSelector().text("Settings").className("android.widget.TextView")).click();
       //UiObject2 loginButton = mDevice.findObject(By.text("LOGIN"));
       //loginButton.click();
       // mDevice.waitForIdle(5000);
       // mDevice.pressBack();

       //UiObject2 settingButton = mDevice.findObject(By.text("Settings"));

      // mDevice.findObject(new UiSelector().resourceId("io.github.hidroh.materialistic:id/drawer_account")).click();
       UiObject2 viewMenu = mDevice.findObject(By.res("io.github.hidroh.materialistic:id/drawer"));
       viewMenu.scroll(Direction.DOWN,1000,100);

    }
    @Test
    public void TestSettingDisplayOption() throws UiObjectNotFoundException
    {
        UiObject2 buttonMenu = mDevice.wait(Until.findObject(By.res("io.github.hidroh.materialistic:id/toolbar")),5000);
        List<UiObject2> listItem = buttonMenu.getChildren();
        if (listItem!=null) {
            List<UiObject2> morebutton = listItem.get(3).getChildren();
            
            morebutton.get(1).click();

            UiObject2 settingDisplay = mDevice.findObject(By.textContains("display"));
            if(settingDisplay!=null && settingDisplay.isClickable()==true)
            {
                settingDisplay.click();
            }
        }
    }
    


}