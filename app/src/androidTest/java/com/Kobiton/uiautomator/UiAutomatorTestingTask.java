package com.Kobiton.uiautomator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.provider.Contacts;


import androidx.test.espresso.core.internal.deps.guava.util.concurrent.Uninterruptibles;
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

import java.io.File;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class UiAutomatorTestingTask {


    private  UiDevice mDevice;
    private  static final String PACKAGE_NAME_APP="com.example.android.architecture.blueprints.master.mock";
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
    public void AddManyTasks() throws UiObjectNotFoundException
    {
        for(int i=0;i<10;i++)
        {
            String name = "Kobiton "+Integer.toString(i);
            AddTask(name,"Hello");
        }

    }

    private void AddTask(String name,String content)
    {
        UiObject2 AddTask= mDevice.wait(Until.findObject(By.res("com.example.android.architecture.blueprints.master.mock:id/add_task_fab")),5000);
        AddTask.click();
        mDevice.wait(Until.findObject(By.res("com.example.android.architecture.blueprints.master.mock:id/add_task_title_edit_text")),5000).setText(name);
        mDevice.wait(Until.findObject(By.res("com.example.android.architecture.blueprints.master.mock:id/add_task_description_edit_text")),5000).setText(content);
        mDevice.wait(Until.findObject(By.res("com.example.android.architecture.blueprints.master.mock:id/save_task_fab")),5000).click();

    }
}
