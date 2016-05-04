Android-Push-SDK
=========
Android客户端SDK

###AndroidManifest.xml

```
        自定义类YYNotificationReceiver,处理通知栏点击事件
        <receiver
            android:name=".YYNotificationReceiver"
            android:exported="true" >

            <!-- 这里com.xiaomi.mipushdemo.DemoMessageRreceiver改成app中定义的完整类名 -->
            <intent-filter>
                <action android:name="com.yy.httpproxy.service.RemoteService.INTENT" />
            </intent-filter>
        </receiver>
        <!-- 以下四个服务是在一个远端进程中运行，所以必须设定android:process的值 -->
        <service android:name="com.yy.httpproxy.service.BindService" android:process=":push" android:enabled="true"/>
        <service android:name="com.yy.httpproxy.service.ConnectionService" android:process=":push" android:enabled="true"/>
        <service android:name="com.yy.httpproxy.service.ForegroundService" android:process=":push" android:enabled="true"/>
        <service android:name="com.yy.httpproxy.service.DummyService" android:process=":push" android:enabled="true"/>

```     
###创建ProxyClient
```
    //初始化ProxyClient，其中PUSH_SERVICE_URL为要访问的主机地址，ConnectCallback和PushCallback设置成自己实现的ConnectCallback和PushCallback
    ProxyClient proxyClient = new ProxyClient(new Config(this)
                    .setHost(PUSH_SERVICE_URL)
                    .setConnectCallback(this)
                    .setPushCallback(this)
                    .setRequestSerializer(new JsonSerializer()));
    //在接收消息之前需要绑定相应的topic，这个topic相当于聊天室的额标签。
    proxyClient.subscribeAndReceiveTtlPackets(chatTopic);


    //ConnectCallback是获取链接状态的回调接口，实现示例如下：
    private void updateConnect() {
        String connectState = proxyClient.isConnected() ? "(connected)" : "(disconnected)";
        setTitle("ChatRoom" + connectState);
    }

    @Override
    public void onConnect(String uid) {
        updateConnect();
    }

    @Override
    public void onDisconnect() {
        updateConnect();
    }


    //PushCallback是获取聊天数据的回调接口，实现示例如下（其中topic为接下来要绑定的话题标签，传递和接收聊天信息都通过topic来进行判断，data为传递的聊天信息）：
    @Override
    public void onPush(String topic, byte[] data) {
        Log.i(TAG, "on push " + topic);
        if (chatTopic.equals(topic)) {
            try {
                Message message = new Gson().fromJson(new String(data, "UTF-8"), Message.class);
                chatMessagesAdapter.addData(message);
                recyclerViewMessages.scrollToPosition(chatMessagesAdapter.getItemCount() - 1);
            } catch (UnsupportedEncodingException e) {
            }
        }
    }

```
###重要类的解释
####ProxyClient
 1.用途：将对网络的操作进行封装。
    * 包括对网络状态的检查：isConnected()。
    * 对广播的绑定subscribeBroadcast(String topic)，其中topic参数传递消息和接收消息的一个参数，实现消息传递的对应
    * 还有对Push消息的接收。
 2.注意：
    * 创建时必须设置Config
    * 这个类在Application中只能被创建一次，如果设置在Application初始化中要保证Application只被创建一次，否则服务在远端进程中运行时会再次创建Application，会使ProxyClient被创建两次，从而出现错误
####Config
 1.用途：网络连接所需要的配置信息，如host、pushId（随机生成，SharedPreference保存）、ConnectCallback、PushCallback等。
 2.注意：创建之后最好设置好host的值之后再创建ProxyClient。ConnectCallback、PushCallback等可以后面进行设置。
####ConnectionService
 1.开启前台服务。
 2.初始化SocketIO的Socket（通过初始化SocketIOProxyClient）。
 3.初始化Notification，
 4.实现检查长链接状态、Push消息接收、消息回应、以及Notification回调接口以供SocketIOProxyClient使用。
####BindService
 处理Config中的RemoteClient发来的广播绑定、设置PUSH_ID、request请求、初始化Messenger、解除广播绑定、解除UID绑定等消息