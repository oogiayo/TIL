import os

os.chdir(r'C:\Users\aclasss\Desktop\file_practice\dummy')

filenames = os.listdir('.')

for filename in filenames:
    os.rename(filename, f'SAMSUNG_{filename}')
