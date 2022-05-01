// import 'package:flutter/material.dart';
// import 'package:flutter_barcode_scanner/flutter_barcode_scanner.dart';

// void main() => runApp(
//     rmiApp()); //funcion que no devuelve nada y ejecuta el primer widget de la aplicacion

// class rmiApp extends StatelessWidget {
//   const rmiApp({Key? key}) : super(key: key);

//   @override
//   Widget build(BuildContext context) {
//     //aca se construye lo que contiene el widget principal
//     return MaterialApp(
//       //material define un patron de diseno de google
//       title: "clienteRMI",
//       home:
//           Inicio(), //indica cual es el widget que se va a mostrar en la pagina de incio
//     );
//   }
// }

// class Inicio extends StatefulWidget {
//   Inicio({Key? key}) : super(key: key);

//   @override
//   State<Inicio> createState() => _InicioState();
// }

// class _InicioState extends State<Inicio> {
//   String _data = "";

//   _scan() async {
//     await FlutterBarcodeScanner.scanBarcode(
//             "#000000", "Cancel", true, ScanMode.BARCODE)
//         .then((value) => setState(() => _data = value));
//   }

//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(
//         title: const Center(child: Text("LOCAL X store - cliente RMI")),
//         backgroundColor: Color.fromARGB(255, 64, 77, 255),
//       ),
//       body: Center(
//         child: Column(
//           children: <Widget>[
//             Text(
//               "Consultar Producto",
//               style: TextStyle(fontSize: 20),
//             ),
//             ElevatedButton(
//               onPressed: () => _scan(),
//               child: Text("Escanear"),
//             ),
//             Text(_data)
//           ],
//         ),
//       ),
//     );
//   }
// }
