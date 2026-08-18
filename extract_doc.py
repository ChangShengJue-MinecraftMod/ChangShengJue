from docx import Document

doc = Document(r'd:\Mod\forge-1.20.1-47.3.0-mdk\规律学.docx')
with open(r'd:\Mod\forge-1.20.1-47.3.0-mdk\规律学_content.txt', 'w', encoding='utf-8') as f:
    for p in doc.paragraphs:
        f.write(p.text + '\n')
print('Done')
