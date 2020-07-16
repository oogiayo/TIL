import os

os.chdir(r'C:\Users\aclasss\Desktop\file_practice\dummy')

filenames = os.listdir('.')

for filename in filenames:
    new_filename = filename.replace('SAMSUNG_', 'SSAFY_')
    os.rename(filename, new_filename)
