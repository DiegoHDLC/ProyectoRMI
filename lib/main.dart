import 'package:flutter/material.dart';

void main() {
  runApp(new MaterialApp(
    home: MyApp(),
  ));
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final double iconSize = 40.0;
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("Stateless widget"),
      ),
      body: new Container(
        alignment: Alignment.center,
        child: new Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: <Widget>[
            new MyCard(
                title: new Text("Me gusta flutter"),
                icon: new Icon(
                  Icons.favorite,
                  size: iconSize,
                )),
            new MyCard(
                title: new Text("Me gusta este video"),
                icon: new Icon(
                  Icons.thumb_up,
                  size: iconSize,
                )),
          ],
        ),
      ),
    );
  }
}

class MyCard extends StatelessWidget {
  final Widget title;
  final Widget icon;

  MyCard({required this.title, required this.icon});
  @override
  Widget build(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.only(bottom: 1.0),
      child: new Card(
        child: new Container(
          padding: const EdgeInsets.all(10),
          child: Column(
            children: [this.title, this.icon],
          ),
        ),
      ),
    );
  }
}
