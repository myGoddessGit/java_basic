import 'dart:collection';

import 'dart:math';

class Person {
  String name;
  int age;
  /// 构造方法不能重载
  Person(this.name, this.age);
}

class User {
  String userName;

  User(this.userName);

  String get name {
    return "user:" + this.name;
  }

  set name(String name){
    this.name = name;
  }
}

class User2 {
  String userName;

  int age;

  User2(this.userName, this.age);
  /// 命名构造方法
//  User2.fromData(Map data){
//    this.userName = data['name'];
//    this.age = data['age'];
//  }
}


class ConstPoint {
  final num x;
  final num y;
  /// 使用const修饰构造方法
  const ConstPoint(this.x, this.y);
  /// 编译时常量对象  需使用const来创建对象
  static final ConstPoint origin = const ConstPoint(0, 0);
}

class Point {
  num x;
  num y;

  /// 同名构造方法
  Point(this.x, this.y);

  /// 命名构造方法重定向到同名构造方法  中间使用冒号
  Point.alongXAxis(num x) : this(x, 0);
}

/// 工厂构造方法
class Logger {
  final String name;

  static final Map _cache = HashMap<String, Logger>();

  /// 下划线"_"修饰  将构造方法私有化
  Logger._internal(this.name);

  factory Logger(String name){
    if (_cache.containsKey(name)){
      return _cache[name];
    } else {
      final logger = new Logger._internal(name);
      _cache[name] = logger;
      return logger;
    }
  }
}

class PointX {
  final num x;
  final num y;
  final num distance;

  PointX(x, y) : x = x, y = y, distance = sqrt(x * x + y * y){
    print("这是一个构造方法");
  }
}

class Father {
  myFunction(){

  }
}

class Son extends Father {
  @override
  myFunction() {
    // TODO: implement myFunction
    return super.myFunction();
  }
}

abstract class Base {
  fun1();
  fun2();
}

class basic extends Base {
  @override
  fun1() {
    // TODO: implement fun1
    throw UnimplementedError();
  }

  @override
  fun2() {
    // TODO: implement fun2
    throw UnimplementedError();

  }
  /// 字面量写法
  var infos = <String>['ss', 'a', 'cc'];

  var pages = <String, String>{
    'index' : "22",
    'dex' : "88"
  };

}
class TestMap {
   test(){
     var testMap = new HashMap<String, String>();
     testMap['a'] = "A";
     testMap['b'] = "B";
     testMap['c'] = "C";
     for(MapEntry<String, String> entry in testMap.entries){
        print("key" + entry.key + "value" + entry.value);
     }
   }
}

void main(){
  var testMap = new LinkedHashMap<String, String>();
  testMap['a'] = "A";
  testMap['b'] = "B";
  testMap['c'] = "C";
  for(MapEntry<String, String> entry in testMap.entries){
    print("key: " + entry.key + "   value: " + entry.value);
  }
  var testMap2 = HashMap.of(testMap);
  testMap2.forEach((key, value) {
    print("key: " + key + "   value: " + value);
  });
}