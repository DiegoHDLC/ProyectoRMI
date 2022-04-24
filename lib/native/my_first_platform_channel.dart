import 'package:flutter/services.dart';

class MyFirstPlatformChannel {
  final MethodChannel _methodChannel =
      MethodChannel("com.example.platform_channel_demo/common");

  Future<void> version() async {
    final result = await _methodChannel.invokeMethod("version");
    print("$result");
  }
}
