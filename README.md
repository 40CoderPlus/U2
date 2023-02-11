# U2

Unified UDF for Bigdata, such as Hive/Flink/Spark/Trino/Doris

# Goals

- Define your UDF(must be an `Java interface`) extends `UnifiedUdf(n)` in module `u2-functions`, implement call method;
- Build project, then your find jars with different suffix(such as Hive,Flink,Spark,Trino,Doris, and so on). 