Factory Method

Idea:
- Create objects based on input, but hide the object creation logic from the caller.

When:
- If object creation is complex
- If type depends on some input
Simple example: Based on the file type you upload (pdf, jpg, doc), the app automatically creates a correct FileReader.

How:
- Have a Factory class with a static method that returns different child objects based on input.