/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.ionicframework.myapp227834;

import android.os.Bundle;
import org.apache.cordova.*;
import org.apache.cordova.syssc.sysssc_test;

import android.util.Log;

import com.tencent.android.tpush.XGCustomPushNotificationBuilder;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.Constants;

public class MainActivity extends CordovaActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);



      XGPushConfig.enableDebug(this, true);
      // 注册接口
      XGPushManager.registerPush(getApplicationContext(),
        new XGIOperateCallback() {
          @Override
          public void onSuccess(Object data, int flag) {

            //sysssc_test.token = data.toString();

            Log.w(Constants.LogTag, "+++ register push sucess. token:" + data);

          }

          @Override
          public void onFail(Object data, int errCode, String msg) {
            Log.w(Constants.LogTag, "+++ register push fail. token:" + data + ", errCode:" + errCode + ",msg:" + msg);
          }
        });
    }
}
