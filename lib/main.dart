import 'package:flutter/material.dart';
import 'package:flutter_barcode_scanner/flutter_barcode_scanner.dart';

void main() {
  runApp(new MaterialApp(
    home: MyButton(),
  ));
}

class MyButton extends StatefulWidget {
  MyButton({Key? key}) : super(key: key);

  @override
  State<MyButton> createState() => _MyButtonState();
}

class _MyButtonState extends State<MyButton> {
  String _data = "";
  _scan() async {
    await FlutterBarcodeScanner.scanBarcode(
            "#000000", "Cancel", true, ScanMode.BARCODE)
        .then((value) => setState(() => _data = value));
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("Stateful Widget"),
        backgroundColor: Colors.orangeAccent,
      ),
      body: new Container(
        child: new Column(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: <Widget>[
            new Text(
              "Hello world",
              style: TextStyle(fontSize: 30),
            ),
            ElevatedButton(
              onPressed: () => _scan(),
              child: Text("Escanear"),
            ),
            Text(_data)
          ],
        ),
      ),
    );
  }
}
