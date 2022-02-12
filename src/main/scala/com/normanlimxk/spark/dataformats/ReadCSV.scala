package com.normanlimxk.spark.dataformats

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object ReadCSV extends SparkSessionWrapper {
  def main(args: Array[String]): Unit = {

    // Read CSF file peope.csv
    val df = spark.read
      .format("csv")
      .option("inferSchema", "true")
      .option("header", "true")
      .option("sep", ";")
      .load("src/main/resources/people.csv")

    // Show results
    df.show()

    // Print schema
    df.printSchema()

    // Define your own schema
    val schema = new StructType()
      .add(StructField("name", StringType, true))
      .add(StructField("age", IntegerType, true))
      .add(StructField("job", StringType, true))
    val peopleDF = spark.read.format("csv")
      .schema(schema)
      .option("sep", ";")
      .option("header", "true")
      .load("src/main/resources/people.csv")
    peopleDF.show()
    peopleDF.printSchema()
  }
}
