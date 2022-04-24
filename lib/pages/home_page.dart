import 'package:flutter/material.dart';
import 'package:platform_channel_demo/native/my_first_platform_channel.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
          child: ElevatedButton(
              onPressed: () {
                MyFirstPlatformChannel _ = MyFirstPlatformChannel();
                _.version();
              },
              child: Text("GET VERSION"))),
    );
  }
}
