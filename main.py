import google.generativeai as genai
with open('KEY.txt', 'r') as file:
    key = file.read()
    file.close()
    pass
genai.configure(api_key=key)
with open('instructions.txt', 'r') as file:
    instructions = file.read()
    file.close()
    pass
model = genai.GenerativeModel('gemini-1.5-flash', system_instruction=instructions)
for i in range(int(input("Enter how much data you want - "))):
    text = model.generate_content(contents="Generate 100 Sample pieces of data").text
    with open('DataSet/Set.csv', 'a') as file:
        file.write(text)
        file.close()
        pass