
import re

f = open("Day4.txt", "r")
first_array = []
second_array=[]
for i in f:
    input_string  = i.replace("\n",'')
    pattern = r"Card \d+: ([\d\s]+) \| ([\d\s]+)"
    match = re.search(pattern, input_string)
    if match:
        first_array.append(list(map(int, match.group(1).split())))
        second_array.append(list(map(int, match.group(2).split())))

master_dict = {}

for i in range(len(first_array)):
    master_dict[i+1]=0

for i in range(len(first_array)):
    dict_val = master_dict[i+1]
    if dict_val == 0:
        counter = 0
        for j in range(len(first_array[i])):
            if first_array[i][j] in second_array[i]:
                counter+=1

        for k in range(counter):
            if k < len(first_array):
                master_dict[i+1+k+1]=master_dict[i+1+k+1]+1
    else:
        for a in range(dict_val):
            counter = 0
            for j in range(len(first_array[i])):
                if first_array[i][j] in second_array[i]:
                    counter+=1

            for k in range(counter):
                if k < len(first_array):
                    master_dict[i+1+k+1]=master_dict[i+1+k+1]+1
for i in range(len(first_array)):
    if master_dict[i+1]==0:
        master_dict[i+1]=master_dict[i+1]+1
    else:
        master_dict[i+1]=master_dict[i+1]*2

master_counter = 0
for i in range(len(first_array)):
    master_counter+=master_dict[i+1]

print(master_counter)
