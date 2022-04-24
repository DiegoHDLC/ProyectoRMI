import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:get/route_manager.dart';
import 'package:platform_channel_demo/pages/home_page.dart';

void main() {
  runApp(PlatiniumApp());
}

class PlatiniumApp extends StatefulWidget {
  PlatiniumApp({Key? key}) : super(key: key);

  @override
  State<PlatiniumApp> createState() => _PlatiniumAppState();
}

class _PlatiniumAppState extends State<PlatiniumApp> {
  int batteryLevel = -1;
  final MethodChannel _channel =
      const MethodChannel('com.example.platform_channel_demo/common');

  Future<void> getBatteryLevel() async {
    batteryLevel = await _channel.invokeMethod("getBatteryLevel");
    setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Platform Channel Demo',
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Platform Channel Demo'),
        ),
        body: Center(
          child: Text('$batteryLevel'),
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: getBatteryLevel,
          tooltip: 'Get Battery Level',
          child: const Icon(Icons.battery_alert_outlined),
        ),
      ),
    );
  }
}
