import pandas as pd
import numpy as np
from numpy import polyfit, polyval

import matplotlib.pyplot as plt
from matplotlib.pyplot import figure
from matplotlib.lines import Line2D

import cartopy.crs as ccrs
import cartopy.feature as cfeature

import math

#read in the dataset
df = pd.read_csv("https://raw.githubusercontent.com/Kenny-Haworth/Projects/master/CS%204650/Project%201/Earthquake%20Data%20from%201.1.1990%20to%209.18.2019%2C%203.0's%20and%20above%20around%20California%20and%20Nevada.csv")

#overlay map of fault lines - https://www.universetoday.com/wp-content/uploads/2010/03/plate-tectonics.jpg, https://www.universetoday.com/76183/earthquake-fault-lines/

#create a graph of fault lines based upon earthquake occurrences

fig = plt.figure()
ax = plt.axes(projection=ccrs.Miller())
ax.set_extent([-124.805, -113.906, 32.049, 42.215], crs=ccrs.PlateCarree()) #coordinates of California

#add major land features, coastlines, state boundaries, and country boundaries
states_provinces = cfeature.NaturalEarthFeature(category='cultural', name='admin_1_states_provinces_lines', scale='10m', facecolor='none')
ax.add_feature(cfeature.LAND)
ax.add_feature(cfeature.COASTLINE)
ax.add_feature(cfeature.BORDERS)
ax.add_feature(cfeature.OCEAN)
ax.add_feature(states_provinces, edgecolor='gray')

#the difference in a single degree of longitude or latitude is roughly 53 miles 40 degrees north of the equator
#thus, only connect earthquakes that are within 3 miles of each other, or 5.66% of a degree or 0.0566 degrees difference

part = df[:1000]

for lat, long in zip(part['latitude'], part['longitude']):
    for lat2, long2 in zip(part['latitude'], part['longitude']):
        dist_btwn_points = math.sqrt((lat-lat2)**2 + (long-long2)**2)

        #the absolute distance between earthquakes must be less than 3 miles to be considered a fault, and cannot be itself
        if dist_btwn_points <= .0566 and dist_btwn_points != 0:
            ax.plot(long, lat, lat2, long2, color='red', marker='o', markersize=0, linewidth=5, transform=ccrs.PlateCarree()) #transform to PlateCarree coordinate mapping

plt.show()