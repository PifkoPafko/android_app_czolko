import jellyfish

file_path_input = "SongList.txt"

try:
    file_input = open(file_path_input, 'r')
except FileNotFoundError:
    print("File not found.")
    exit(1)

string_list = file_input.read().splitlines()
newlist = string_list.copy()

index_first_list = 0
index_second_list = 0
indexes_to_delete = []

for index_first_list in range(len(string_list)):
    for index_second_list in range(index_first_list + 1, len(string_list)):

        distance = jellyfish.levenshtein_distance(string_list[index_first_list], string_list[index_second_list])
        if distance < 4:
            print(string_list[index_first_list] + "     " + string_list[index_second_list])
            indexes_to_delete.append(index_second_list)

indexes_to_delete_without_duplicates = set(indexes_to_delete)
indexes_to_delete_without_duplicates = sorted(indexes_to_delete_without_duplicates, reverse=True)
print(indexes_to_delete_without_duplicates)

for index in indexes_to_delete_without_duplicates:
    del newlist[index]

file_input.close()


# file_path_output = "SongList.txt"
# try:
#     file_output = open(file_path_output, 'w')
        
# except FileNotFoundError:
#     print("File not found.")
#     exit(1)

# if len(newlist) > 0:
#     file_output.write(newlist[0])

# if len(newlist) > 1:
#     for song_index in range(1, len(newlist)):
#         file_output.write('\n' + newlist[song_index])

# file_output.close()