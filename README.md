# Video-Game-Sales-CSV-Parser

Video Game Sales CSV Parser is a tool for CSV file video game data pre-processing and has been created for a university project.

Video Game Sale Data format should follow the pattern below, in order to parsed without source code changes:

Warning! 1st line should be titles

Rank,Name,Ptatform,Year,Genre,Publisher,NA_Sales,JP_Sales,Other_Sales,Global_Sales
1,Wii Sports,Wii,2006,Sports,Nintendo,41.49,29.02,3.77,8.46,82.74
2,Super Mario Bros.,NES,1985,Platform,Nintendo,29.08,3.58,6.81,0.77,40.24
... more video game sales

# Play with code in order to read other CSV

1. Just create a new model POJO class in vg.sales.model package and implement CSVSheetValue interface

2. Go to JavaFXSupportApplication.java in gui package and change this line:

  CSVSheet sheet = reader.read(file, true, VGSale.class);

  to

  CSVSheet sheet = reader.read(file, true, MyModelClassName.class);

  Thats it!!!
