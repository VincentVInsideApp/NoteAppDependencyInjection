package com.vvsoftdev.noteapp.ui

import android.content.Context
import android.os.Bundle
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.android.KeyData
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

const val KeyData = "key_data"
const val CommunicationChannel = "com.app/dataShare"

// https://blog.devgenius.io/use-flutter-screens-in-native-android-app-share-data-among-them-d97d670807a6
class MyFlutterFragment: FlutterFragment() {
    var data: String? = null
    private val myFlutterFragmentRoute = "/fragment_flutter_route"
    private val callbackMethod = "shareData"

    companion object {
        fun instance(data: String): MyFlutterFragment {
            val fragment = MyFlutterFragment()
            val bundle = Bundle().apply {
                putString(KeyData,data)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {args ->
            if (args.containsKey(KeyData)) {
                data = args.getString(KeyData)
            }
        }
    }

    override fun provideFlutterEngine(context: Context): FlutterEngine? {
        val engine = FlutterEngine(requireActivity())
        engine.navigationChannel.setInitialRoute(myFlutterFragmentRoute)
        return engine
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CommunicationChannel).setMethodCallHandler {
                call, result ->
            if (call.method == callbackMethod) {
                data?.let {
                    result.success(it)
                } ?: result.error("error", "error message", null)
            } else {
                result.notImplemented()
            }
        }
    }
}