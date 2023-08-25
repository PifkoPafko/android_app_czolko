import json

# Function to read text file and convert to a list of strings
def read_text_file(file_path):
    with open(file_path, 'r') as file:
        lines = file.read().splitlines()
    return lines

# Function to write a list of strings to a JSON file
def write_to_json(strings, output_file):
    with open(output_file, 'w') as file:
        list_of_song_sets = []
        for string in strings:
            list_of_song_sets.append({"isSanah" : False, "isOtherShit" : False, "title" : string})
        json_data = {"songs" : list_of_song_sets}
        json.dump(json_data, file, ensure_ascii=False, indent=4)

# Input and output file paths
input_file = 'NewSongList.txt'
output_file = '.\\app\\src\\main\\assets\\songs_data.json'

# Read the text file into a list of strings
strings = read_text_file(input_file)

# Write the list of strings to a JSON file
write_to_json(strings, output_file)

print(f'Successfully converted {len(strings)} strings to JSON in {output_file}.')