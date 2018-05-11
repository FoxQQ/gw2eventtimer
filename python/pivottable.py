'''
Created on 11.05.2018

@author: makki
'''
import pandas as pd
import os


def get_colName(row):
    print(row)

fp=os.path.join(os.pardir,"invasion.txt")
df=pd.read_csv(fp)


df1=pd.DataFrame(columns=("UTC","Mo","Tu","We","Th","Fr","Sa","Su"))
print(df1.columns)
for i, row in df.iterrows():
    df1.loc[i,"UTC"]=df.loc[i,"Server Time (UTC)"]
    for j in enumerate(row):
        if(j[0]!=0):
            df1.loc[i,j[1]]=df.columns[j[0]]  
    
    

df1.to_csv(os.path.join(os.pardir,"invasion_new.txt"))