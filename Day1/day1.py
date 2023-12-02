import csv

with open('day1.csv', newline='') as f:
    reader = csv.reader(f)
    data = list(reader)

num_lst = ["1", "2", "3","4","5","6","7","8","9","0"]

unparsed_lst = []
for element in data:
    test_data = element[0]
    pos_word_dict = {}
    num_word_lst = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    

    for i in range(len(num_word_lst)):
        pos = test_data.find(num_word_lst[i])
        if pos != -1:
            test_data = test_data.replace(num_word_lst[i], num_word_lst[i][0]+str(i)+num_word_lst[i][-1])

    unparsed_lst.append([test_data])
            



string_num_arr = []
for i in unparsed_lst:
    word = i[0]
    digit_holder = 0
    is_first_digit = True
    first_digit = 0
    for j in word:
        if j == "1" or j == "2" or j == "3"or j == "4"or j == "5"or j == "6"or j == "7"or j == "8"or j == "9"or j == "0":
            if is_first_digit:
                first_digit = int(j)
                is_first_digit = False
            else:
                digit_holder = first_digit*10+int(j)
    if digit_holder<10:
        string_num_arr.append(first_digit*10+first_digit)
    else:
        string_num_arr.append(digit_holder)
    

counter = 0
for i in string_num_arr:
    counter = counter+ i
print(counter)
