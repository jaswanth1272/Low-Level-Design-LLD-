Command

Idea:
- Encapsulate a request as an object, so you can log, queue, or undo operations.

When:
- When you want to decouple the object that invokes the operation from the one that knows how to perform it.
- Basically decoupling request from execution
- When you want to provide undo/redo functionality.

Simple example:
- Remote Control: Press a button → send a command to device.

How:
- Create Command classes with execute() method, store them if needed.

