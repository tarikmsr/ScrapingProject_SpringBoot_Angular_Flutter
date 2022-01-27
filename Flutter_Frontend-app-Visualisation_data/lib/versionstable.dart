import 'dart:convert';

import 'package:flutter/material.dart';
import 'dart:convert' as convert;
import 'package:flutter/cupertino.dart';
// import 'package:http/http.dart';

import 'package:syncfusion_flutter_charts/charts.dart';
import 'package:syncfusion_flutter_charts/sparkcharts.dart';


class Details extends StatefulWidget {
  const Details({Key? key}) : super(key: key);

  @override
  _DetailsState createState() => _DetailsState();
}
class GDPData {
  GDPData(this.continent, this.gdp);
  final String continent;
  final int gdp;
}

class _DetailsState extends State<Details> {
  late List<GDPData> _chartData;
  late List<GDPData> _chartData2;
  late TooltipBehavior _tooltipBehavior;
  late TooltipBehavior _tooltipBehavior2;
  Map<String, dynamic> data = Map<String, dynamic>();
  //final url ="http://192.168.100.4:8080/FlutterTest";
  var _postsJson=[];
  var _getprieces=[];
  void fetchPrice() async {
    try{
      //final resp=await get(Uri.parse(url));
      //final jsonData=jsonDecode(resp.body) as List;
      setState(() {
        //_getprieces=jsonData;
        _chartData2 = [
          GDPData('Gourziana à Tanger',1200),
          GDPData('Hanaa3-Soussi à Tanger',400),
          GDPData('Boukhalef à Tanger',2755),
          GDPData('LallaChafia à Tanger',1950),
          GDPData('Ahlane à Tanger',3000),
          GDPData('Mesnana à Tanger',3002),
          GDPData('PortTangerville à Tanger',2300),
          GDPData('Jirrari à Tanger',1764),
          GDPData('AouamaGharbia à Tanger',2050),
          GDPData('Ennasr à Tanger',2800)


        ];

      });
    }catch(err){
    }

  }
  void fetchPoste() async {
    try{
      //final resp=await get(Uri.parse(url));
      //final jsonData=jsonDecode(resp.body) as List;
      setState(() {
        //_postsJson=jsonData;
        _chartData = [
          GDPData('Centre à Tanger', 345),
          GDPData('Malabata à Tanger', 202),
          GDPData('Tanger', 183),
          GDPData('DeLaPlage à Tanger', 86),
          GDPData('Administratif à Tanger', 85),
          GDPData('TangerMedina à Tanger', 77),
          GDPData('TangerCityCenter à Tanger', 40),
          GDPData('Marjane à Tanger', 39),
          GDPData('Mozart à Tanger', 38)
        ];
        _tooltipBehavior = TooltipBehavior(enable: true);
      });
    }catch(err){
    }

  }
  @override
  void initState() {
    fetchPoste();

    _chartData2 = [
      GDPData('Gourziana à Tanger',1200),
      GDPData('Hanaa3-Soussi à Tanger',400),
      GDPData('Boukhalef à Tanger',2755),
      GDPData('LallaChafia à Tanger',1950),
      GDPData('Ahlane à Tanger',3000),
      GDPData('Mesnana à Tanger',3002),
      GDPData('PortTangerville à Tanger',2300),
      GDPData('Jirrari à Tanger',1764),
      GDPData('AouamaGharbia à Tanger',2050),
      GDPData('Ennasr à Tanger',2800)


    ];
    _tooltipBehavior = TooltipBehavior(enable: true);
    _tooltipBehavior2 = TooltipBehavior(enable: true);
    super.initState();
  }
  int currentPage = 0;
  GlobalKey bottomNavigationKey = GlobalKey();
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        //backgroundColor: Colors.transparent,
          appBar: AppBar(
            leading: IconButton(onPressed:(){}, icon: Icon(Icons.arrow_back)),
            backgroundColor: Colors.blue,
            title: Text(
              "STATISTIQUE",
              style: TextStyle(
                fontSize: 24,
                //fontWeight: FontWeight.bold,
                color: Colors.white,
              ),
            ),
            actions: [
              Stack(
                children: <Widget>[
                  Container(
                    width: 50,
                    height: 50,
                    child: IconButton(
                      icon: Icon(Icons.add_alert_sharp),
                      onPressed: () {
                        _Detection(context);
                      },
                    ),
                  ),
                  Positioned(
                    right: 9,
                    top: 10,
                    child: Container(
                      width: 15,
                      height: 15,
                      decoration: BoxDecoration(
                          color: Colors.red,
                          shape: BoxShape.circle,
                          border: Border.all(color: Colors.white, width: 2)),
                    ),
                  ),
                ],
              )
            ],
          ),
          //-------------------------------------------------fin AppBar ----------------------------------------
          body:SingleChildScrollView(
            child: Padding(
              padding: const EdgeInsets.symmetric(vertical: 35,horizontal: 15),
              child: Center(
                child: Column(
                    children: <Widget>[
                      SfCircularChart(
                        title:
                        ChartTitle(text: "Monopoly de localisation"),
                        legend:
                        Legend(isVisible: true, overflowMode: LegendItemOverflowMode.wrap),
                        tooltipBehavior: _tooltipBehavior,
                        series: <CircularSeries>[
                          PieSeries<GDPData, String>(
                            dataSource: _chartData,
                            xValueMapper: (GDPData data, _) => data.continent,
                            yValueMapper: (GDPData data, _) => data.gdp,
                            dataLabelSettings: DataLabelSettings(isVisible: true),
                            enableTooltip: true,

                            //maximumValue: 40000
                          ),

                        ],
                        borderColor: Colors.indigo,

                      ),

                      SfCartesianChart(title: ChartTitle(text:"Nombre d'annonces par Localisation à Tanger" ),
                        series: <ChartSeries>[
                          BarSeries<GDPData, String>(
                              dataSource: _chartData,
                              xValueMapper: (GDPData data, _) => data.continent,
                              yValueMapper: (GDPData data, _) => data.gdp),
                        ],
                        primaryXAxis: CategoryAxis(),palette: [Colors.deepOrangeAccent],
                        primaryYAxis: NumericAxis(edgeLabelPlacement: EdgeLabelPlacement.shift),
                        borderColor: Colors.indigo,
                      ),
                      SfCartesianChart(title: ChartTitle(text:"Vente moyen par Localisation  et Price à Tanger" ),
                        series: <ChartSeries>[
                          BarSeries<GDPData, String>(
                              dataSource: _chartData2,
                              xValueMapper: (GDPData data, _) => data.continent,
                              yValueMapper: (GDPData data, _) => data.gdp)
                        ],
                        primaryXAxis: CategoryAxis(),
                        primaryYAxis: NumericAxis(edgeLabelPlacement: EdgeLabelPlacement.shift),
                        borderColor: Colors.indigo,
                      ),
                      SfCartesianChart(title: ChartTitle(text:"Nombre d'annonces par Localisation à Tanger" ),
                        series: <ChartSeries>[
                          ScatterSeries<GDPData, String>(
                              dataSource: _chartData,
                              xValueMapper: (GDPData data, _) => data.continent,
                              yValueMapper: (GDPData data, _) => data.gdp)
                        ],

                        primaryXAxis: CategoryAxis(),
                        primaryYAxis: NumericAxis(edgeLabelPlacement: EdgeLabelPlacement.shift),
                        palette: [Colors.lightGreen],
                        borderColor: Colors.indigo,
                      ),




                    ]
                ),
              ),
            ),
          )

      ),

    );

  }

}
void _Detection(BuildContext context) {
  final route = MaterialPageRoute(builder: (BuildContext context) {
    return const Details(
    );
  });
  Navigator.of(context).push(route);
}

Widget lineSection = Container(
  color: Colors.grey[200],
  padding: EdgeInsets.all(4),
);

Widget subTitleSection = Container(
  margin: EdgeInsets.all(20),
  child: Row(
    children: [
      Container(
        color: Colors.indigoAccent,
        width: 5,
        height: 25,
      ),
      SizedBox(width: 10),
      Text(
        'Curriculum',
        style: TextStyle(
          fontSize: 20,
          fontWeight: FontWeight.w600,
        ),
      )
    ],
  ),
);
class Price{
  Price(this.location,this.prix);
  final String location;
  final double prix;
}
List<Price>getChartData(){
  final List<Price>chartData = [
    Price('Gourziana à Tanger',120.0),
    Price('Hanaa3-Soussi à Tanger',400.0),
    Price('Boukhalef à Tanger',2755.0),
    Price('LallaChafia à Tanger',1950.0),
    Price('Ahlane à Tanger',3000.0),
    Price('Mesnana à Tanger',3002.0),
    Price('PortTangerville à Tanger',2300.0),
    Price('Jirrari à Tanger',1764.0),
    Price('AouamaGharbia à Tanger',2050.0),
    Price('Ennasr à Tanger',2800.0),
  ];
  return getChartData();
}