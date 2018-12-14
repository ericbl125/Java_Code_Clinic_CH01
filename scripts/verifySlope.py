# python script to verify Code Clinic response

import csv
import numpy as np
from scipy import stats
from scipy.stats import linregress
import matplotlib.pyplot as plt

csv_file = r"Environmental_Data_Deep_Moor_2012.csv"
 

with open(csv_file, "rt" , newline='') as txt:
	d_reader = csv.DictReader(txt)

	#get fieldnames from DictReader object and store in list
	headers = d_reader.fieldnames
	baro = []
	time = []
	count = 1
	for line in d_reader:
		baro.append(line["Barometric_Press"])
		time.append(count)
		count += 1

    #this just accepts all the data
	#data = np.array(csv.reader(txt))

#	((X*Y).mean(axis=1) - X.mean()*Y.mean(axis=1)) / ((X**2).mean() - (X.mean())**2)

baro_array = np.array(baro).astype(np.float)
time_array = np.array(time)

X = time_array
Y = baro_array

slope, intercept, r, p, std = linregress(time_array, baro_array)

print(slope)

plt.plot(time_array, baro_array, "o", label="original data")
plt.plot(time_array, intercept + slope*time_array, "r", label="fitted line")
plt.legend()
plt.show()

