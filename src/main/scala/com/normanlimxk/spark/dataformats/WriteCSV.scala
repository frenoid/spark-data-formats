package com.normanlimxk.spark.dataformats

object WriteCSV extends SparkSessionWrapper {
  def main(args: Array[String]): Unit = {

    // Read a csv file
    val df = spark.read.format("csv")
      .option("inferSchema", "true")
      .option("header", "true")
      .option("sep", ";")
      .load("src/main/resources/people.csv")

    // Show result
    df.show()

    // Print schema
    df.printSchema()

    // Write to csv
    df.write.format("csv")
      .option("header", "true")
      .option("sep", ";")
      .mode("overwrite") // overwrite if data already exists
      .save("src/main/resources/out/people2")
  }
}
