import re
import string

frequency = {}
document_text = open('C:\\Users\\clair\\OneDrive\\Documents\\2019\\AI\\Assignment1\\PatrickAbstracts.txt', 'r', encoding="utf8")
text_string = document_text.read().lower()
match_pattern = re.findall(r'\b[a-z]{3,15}\b', text_string)

for word in match_pattern:
    count = frequency.get(word, 0)
    frequency[word] = count + 1

frequency_list = frequency.keys()

for words in frequency_list:
    print (words, frequency[words])