#Kendall Haworth
#CS 4650, Assignment 2

#1. read in the data set

import pandas as pd
from datetime import datetime
import matplotlib.pyplot as plt
from matplotlib.pyplot import figure

url = 'https://raw.githubusercontent.com/fivethirtyeight/uber-tlc-foil-response/master/uber-trip-data/uber-raw-data-sep14.csv'
df = pd.read_csv(url)
df['Date/Time'] = pd.to_datetime(df['Date/Time'], infer_datetime_format=True) #convert the first column to a datetime format
print(df)

#2. Display the first 50 rows and the last 50 rows
print("\nFirst 50 rows:\n", df[:50])
print("\nLast 50 rows:\n", df[-50:])

#3. Display statistical information on each numerical column
#   The following information is displaying for each column:
#     Mean
#     Max
#     Min
#     Median
#     Count
#     Standard Deviation

col1 = df["Date/Time"]
print("\nColumn 1, Date/Time, is a date column, so it is not applicable for standard statistical analysis such as mean, median, max, min, etc.")

col2 = df["Lat"]
print("\nColumn 2, Latitude")
print("\tMean:", col2.mean())
print("\tMax:", col2.max())
print("\tMin:", col2.min())
print("\tMedian:", col2.median())
print("\tCount:", col2.count())
print("\tStandard Deviation:", col2.std())

col3 = df["Lon"]
print("\nColumn 3, Longitude")
print("\tMean:", col3.mean())
print("\tMax:", col3.max())
print("\tMin:", col3.min())
print("\tMedian:", col3.median())
print("\tCount:", col3.count())
print("\tStandard Deviation:", col3.std())

print("\nColumn 4, Base, is the Uber base affiliated with each Uber driver, so it is not applicable for standard statistical analysis such as mean, median, max, min, etc.")

#4. Select a subset of rows. Display the first 10 data entries selected.
#   For this subset, let's select the first 10 entries collected on September 21

mask = (df['Date/Time'] >= '21-09-2014') & (df['Date/Time'] <= '21-09-2014')
sep21 = df.loc[mask]

print('\nThe first 10 entries on September 21, 2014:')
print(sep21[:10])

#5. Select a subset of columns, display the first 10 data entries with selected columns
#   For this subset, let's select only the latitutde and longitude columns.

lat_lon = df[['Lat', 'Lon']]

print("\nThe first 10 entries containing only Latitude and Longitude columns:")
print(lat_lon[:10])

#6. Filter out some data and display the first 50 data entries.
#   For this subset, let's select only the entries whose base is Danach - base code B02764.

danach = df.loc[df['Base'] == 'B02764']

print("\nThe first 50 entries with the Uber Base of Danach - Base code B02764.")
print(danach[:50])

#7. Display the first 10 entries with missing values.
#   In this data set, there are no missing values. I will print the number of missing values in each column.

print("\nNumber of missing values in each column:")
print(df.isnull().sum())

#8. Manipulate the data by changing numerical values of specific columns.
#   For this subset, let's increase the longitude and latitude base by 10% for the first 10 entries.

manipulated_df = df[:10].copy() #copy the first 10 rows of the dataframe
manipulated_df['Lat'] = manipulated_df['Lat'].apply(lambda x: x*1.1) #10% boost to value
manipulated_df['Lon'] = manipulated_df['Lon'].apply(lambda x: x*1.1) #10% boost to value

print("\nBefore update - first 10 entries in database:")
print(df[:10])

print("\nAfter update - first 10 entries in database with latitude and longitude columns getting a 10% boost in value:")
print(manipulated_df)

#9. Sort the data set in step 8 in a certain way.
#   For this subset, let's sort by the latitude column ascending.

manipulated_df = manipulated_df.sort_values('Lat')

print("\nSame dataset as previous, but now the data is sorted by latitude column in ascending order:")
print(manipulated_df)

#10. Group data from step 9 based on a certain category.
#    For this subset, the dates are already the same and the base is already the same, so grouping makes no sense.
#    I will group on the entire data set based upon the Base category, since there is nothing else to group by in my data set from step 9.

df_by_base = df['Date/Time'].groupby(df['Base'])

print('\nGrouping by base and counting how many rows have the same base for the entire data set:')
print(df_by_base.count())

#11. Graph in different ways.
#    For this, let's graph the following:
#        A bar graph of the number of pickups for each base vs the base
#        A scatter plot of Latitude vs Longitude coordinates for all entries

figure(num=None, figsize = (8,6), dpi = 125) #increase the default graph size

print("\nGraphing the number of pickups for each base vs the base:")

count = df_by_base.count().tolist()
types = df_by_base.count().index.to_list()

plt.bar(range(len(count)), count, color="blue")
plt.xticks(range(5), types)
plt.xlabel('Uber Base Code')
plt.ylabel('Number of Pickups')
plt.show()

figure(num=None, figsize = (8,6), dpi = 125) #increase the default graph size

print("\nGraphing latitude vs longitude for all entries:")
plt.plot(df['Lon'], df['Lat'], 'ro')
plt.xlabel('Longitude')
plt.ylabel('Latitude')
plt.show()