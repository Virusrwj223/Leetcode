import re
f = open("day2.txt", "r")


records_dict = {}
counter = 1
for i in f:
    records_dict[counter] = {}
    records_dict[counter]['red'] = {}
    records_dict[counter]['blue'] = {}
    records_dict[counter]['green'] = {}

    pattern_r = r'(\d+)\s+red'
    matches_r = re.findall(pattern_r, i)
    numbers_before_red = [int(match) for match in matches_r]
    records_dict[counter]["red"] = numbers_before_red

    pattern_b = r'(\d+)\s+blue'
    matches_b = re.findall(pattern_b, i)
    numbers_before_blue = [int(match) for match in matches_b]
    records_dict[counter]["blue"] = numbers_before_blue

    pattern_g = r'(\d+)\s+green'
    matches_g = re.findall(pattern_g, i)
    numbers_before_green = [int(match) for match in matches_g]
    records_dict[counter]["green"] = numbers_before_green


    counter+=1

master_counter = 0
for i in range(len(records_dict)):
    red_lst = records_dict[i+1]['red']
    blue_lst = records_dict[i+1]['blue']
    green_lst = records_dict[i+1]['green']
    red_min = max(red_lst)
    blue_min = max(blue_lst)
    green_min = max(green_lst)
    master_counter+=red_min*blue_min*green_min

print(master_counter)
'''
max_red = 12
max_blue = 14
max_green = 13
def is_less_than(dict):
    red_lst = dict['red']
    blue_lst = dict['blue']
    green_lst = dict['green']
    red_bool = True
    blue_bool = True
    green_bool = True
    for i in red_lst:
        if i>max_red:
            red_bool = False
    for i in blue_lst:
        if i>max_blue:
            blue_bool = False
    for i in green_lst:
        if i>max_green:
            green_bool = False
    return red_bool and green_bool and blue_bool

master_counter = 0
for i in range(len(records_dict)):
    if is_less_than(records_dict[i+1]):
        num = i+1
        master_counter+=num

print(master_counter)
'''