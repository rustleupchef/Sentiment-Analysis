import google.generativeai as genai
with open('KEY.txt', 'r') as file:
    key = file.read()
    file.close()
    pass
genai.configure(api_key=key)

model = genai.GenerativeModel('gemini-1.5-flash')

print(model.generate_content(contents="Howdy").text)