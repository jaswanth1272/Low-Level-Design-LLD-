Singleton Pattern

Idea:
- Only one object of a class exists across the application.

When:

- Database connections
- Logging
- Config Managers
Simple example: Government has only one Prime Minister at a time.

How:

- Make constructor private.
- Give a static method to create/get the instance.