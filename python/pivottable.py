'''
Created on 11.05.2018

@author: makki
'''
import pandas as pd
import os


fp=os.path.join(os.pardir,"invasion.txt")
df=pd.read_csv(fp)
print(df.head())