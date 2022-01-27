
import 'package:flutter/material.dart';
import 'package:flutterdashboard/versionstable.dart';

// import 'bar.dart';
// import 'kmeans.dart';
Future  main() async{
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Anti Covid Projet',
      debugShowCheckedModeBanner: false,

      theme: ThemeData(

        primarySwatch: Colors.teal,
      ),
      home: const Details(),
    );
  }
}