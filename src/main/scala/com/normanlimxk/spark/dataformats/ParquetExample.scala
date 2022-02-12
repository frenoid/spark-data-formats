package com.normanlimxk.spark.dataformats

object ParquetExample extends SparkSessionWrapper {
  def main(args: Array[String]): Unit = {

    // Read the people.json file
    val peopleDF = spark.read.json("src/main/resources/people.json")

    // Dataframes can be saved as Parquet files that keep the schema information
    peopleDF.write.format("parquet")
      .mode("overwrite")
      .save("src/main/resources/out/people.parquet")

    // Read the Parquet file you created
    // Parquet files are self-described so the schema is preserved
    // Loading a Parquet file also creates a Dataframe
    val parquetFile = spark.read.parquet("src/main/resources/out/people.parquet")

    // Parquet files can be used to create a temporary views and then used in SQL statements
    parquetFile.createOrReplaceTempView("parquetFile")
    val teenagers = spark.sql("SELECT name FROM parquetFile WHERE age >= 13 AND age <= 19")
    teenagers.show()
  }
}
