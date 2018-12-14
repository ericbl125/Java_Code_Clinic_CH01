

# python script to copy and conver the .txt files into .csv from Code Clinic CH01

import csv

txt_file = r"Starter Projects/Java_Code_Clinic_CH01/Environmental_Data_Deep_Moor_2012.txt"
csv_file = r"Environmental_Data_Deep_Moor_2012.csv"

ifile = open(txt_file, "rt", encoding = "utf8")
in_txt = csv.reader(ifile, delimiter = "\t")

out_csv = csv.writer(open(csv_file,'wt'))

out_csv.writerows(in_txt)
