'''
num_arr=['1','2','3','4','5','6','7','8','9','0']
non_symbol_arr=['1','2','3','4','5','6','7','8','9','0','.']
def symbol_checker(r,c,arr):
     max_r = len(arr)
     max_c = len(arr[0])
     prev_r = r-1
     next_r = r+1
     prev_c = c-1
     next_c = c+1
     
     if prev_r>=0 and prev_c>=0 and arr[prev_r][prev_c] not in non_symbol_arr:
          return True
     elif prev_r>=0 and arr[prev_r][c] not in non_symbol_arr:
          return True
     elif prev_r>=0 and next_c<max_c and arr[prev_r][next_c] not in non_symbol_arr:
          return True
     elif prev_c>=0 and arr[r][prev_c] not in non_symbol_arr:
          return True
     elif next_c<max_c and arr[r][next_c] not in non_symbol_arr:
          return True
     elif next_r<max_r and prev_c>=0 and arr[next_r][prev_c] not in non_symbol_arr:
          return True
     elif next_r<max_r and arr[next_r][c] not in non_symbol_arr:
          return True
     elif next_r<max_r and next_c<max_c and arr[next_r][next_c] not in non_symbol_arr:
          return True
     else:
          return False

f = open("Day3.txt", "r")
data_arr = []
for i in f:
    data_arr.append(i.replace("\n",''))

master_arr=[]
for i in range(len(data_arr)):
    part_num_arr=[]
    is_part_num=False
    for j in range(len(data_arr[i])):
            if data_arr[i][j] in num_arr:
                part_num_arr.append(int(data_arr[i][j]))
                if not is_part_num:
                    is_part_num = symbol_checker(i,j,data_arr)
                if j==len(data_arr[0])-1 and is_part_num:
                    master_arr.append(part_num_arr)
            else:
                if is_part_num:
                    master_arr.append(part_num_arr)
                part_num_arr = []
                is_part_num=False

master_counter = 0
for i in master_arr:
     i.reverse()
     counter = 0
     for j in range(len(i)):
        counter += i[j]*10**j
     master_counter+=counter
print(master_counter)
'''


num_arr=['1','2','3','4','5','6','7','8','9','0']
non_symbol_arr=['1','2','3','4','5','6','7','8','9','0','.']
def symbol_checker(r,c,arr):
     max_r = len(arr)
     max_c = len(arr[0])
     prev_r = r-1
     next_r = r+1
     prev_c = c-1
     next_c = c+1
     
     if prev_r>=0 and prev_c>=0 and arr[prev_r][prev_c] == '*':
          return prev_r, prev_c, True
     elif prev_r>=0 and arr[prev_r][c] == '*':
          return prev_r, c, True
     elif prev_r>=0 and next_c<max_c and arr[prev_r][next_c] == '*':
          return prev_r, next_c, True
     elif prev_c>=0 and arr[r][prev_c] == '*':
          return r, prev_c, True
     elif next_c<max_c and arr[r][next_c] == '*':
          return r, next_c, True
     elif next_r<max_r and prev_c>=0 and arr[next_r][prev_c] == '*':
          return next_r, prev_c, True
     elif next_r<max_r and arr[next_r][c] == '*':
          return next_r, c, True
     elif next_r<max_r and next_c<max_c and arr[next_r][next_c] == '*':
          return next_r, next_c, True
     else:
          return None, None, False

f = open("Day3.txt", "r")
data_arr = []
for i in f:
    data_arr.append(i.replace("\n",''))

master_dict = {}
for i in range(len(data_arr)):
     master_dict[i] = {}
     for j in range(len(data_arr[i])):
          master_dict[i][j]=[]

for i in range(len(data_arr)):
    star_row = None
    star_column = None
    part_num_arr=[]
    is_part_num=False
    for j in range(len(data_arr[i])):
            if data_arr[i][j] in num_arr:
                part_num_arr.append(int(data_arr[i][j]))
                if not is_part_num:
                    star_row, star_column, is_part_num = symbol_checker(i,j,data_arr)
                if j==len(data_arr[0])-1 and is_part_num:
                    master_dict[star_row][star_column].append(part_num_arr)
            else:
                if is_part_num:
                    master_dict[star_row][star_column].append(part_num_arr)
                part_num_arr = []
                is_part_num=False


master_counter = 0
for i in range(len(data_arr)):
     for j in range(len(data_arr[i])):
          if len(master_dict[i][j]) > 1:
               m_counter = 1
               arr = master_dict[i][j]
               for a in arr:
                    a.reverse()
                    mini_counter = 0
                    for b in range(len(a)):
                         mini_counter += a[b]*10**b
                    m_counter*=mini_counter
               master_counter+=m_counter
print(master_counter)