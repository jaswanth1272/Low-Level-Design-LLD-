Builder

Idea:
- Construct a complex object step by step, instead of using a big constructor.

When:
- When object has too many optional parameters (like name, age, address, phone...).
Simple example: Building a Pizza → you select size, toppings, cheese, etc.

How:
- Use a separate Builder class that sets fields one by one and then finally builds.