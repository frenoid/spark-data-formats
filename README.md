# spark-data-formats

An introduction of data formats used in Spark and how to read from and write to them.

The workshop was given as part of the [Big Data Engineering for Analytics](https://www.iss.nus.edu.sg/executive-education/course/detail/big-data-engineering-for--analytics/data-science) module which fulfills a requirement for the Engineering Big Data certificate issued by [NUS-ISS](https://www.iss.nus.edu.sg/)

I have translated the original Python code to Scala

The section on PyArrow is omitted since Scala code runs natively on the JVM

## Getting started

### Clone the repo
```
git clone https://github.com/frenoid/tour-of-spark.git
```

### Structure
Each object demonstrates an IO operation to a format
1. [Read from CSV](src/main/scala/com/normanlimxk/spark/dataformats/ReadCSV.scala)
2. [Write to CSV](src/main/scala/com/normanlimxk/spark/dataformats/WriteCSV.scala)
3. [Read from JSON](src/main/scala/com/normanlimxk/spark/dataformats/ReadJSON.scala)
4. [Read and write to Parquet](src/main/scala/com/normanlimxk/spark/dataformats/ParquetExample.scala)

Data is located in src/main/resources

### Running the Spark job
You have 2 options to run the spark job
1. Compile and run on a spark-cluster
2. Use Intellij (Recommended)

### (Option 1) Compile and run on a spark-cluster
Do this if you have a spark cluster to spark-submit to <br />
Take note of these versions. See also [build.sbt](./build.sbt)
```
scala = 2.12.10
spark = 3.0.3
sbt = 1.6.1
```
Use [sbt]((https://www.scala-sbt.org/)) to compile into a jar
```
sbt compile
```
The jar file will be in target/scala-2.12

Use spark-submit to submit the spark job
```
spark-submit {your-jar-file}
```

### (Option 2 RECOMMENDED) Use Intellij
Install [Intellij](https://www.jetbrains.com/idea/) and use it to Open the [build.sbt](./build.sbt) file as a Project

Intellij will resolve the dependencies listed in [build.sbt](./build.sbt)

Go to Run > Edit Configurations > Modify options > Add dependencies with "provided" scope to classpath

Run > Run Main

## Giter8 template
I used  [spark-sbt.g8 from MrPowers](https://github.com/MrPowers/spark-sbt.g8)