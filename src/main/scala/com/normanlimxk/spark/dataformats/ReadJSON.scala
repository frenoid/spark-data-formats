package com.normanlimxk.spark.dataformats

object ReadJSON extends SparkSessionWrapper {
  def main(args: Array[String]): Unit = {
    val df = spark.read.format("json")
      .option("inferSchema","true")
      .option("header","true")
      .option("sep",";")
      .load("src/main/resources/people.json")

    df.show()
    df.printSchema

    val df2 = spark.read.json("src/main/resources/people.json")
    df2.show()
  }
}
