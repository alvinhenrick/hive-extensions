# Hive UDF Examples

## Compile

```
mvn compile
```

## Test

```
mvn test
```

## Build
```
mvn package
```

## Run

```
%> hive
hive> ADD JAR /path/to/assembled.jar;
hive> create temporary function hello as 'com.matthewrathbone.example.SimpleUDFExample';
hive> select hello(firstname) from people limit 10;

```

