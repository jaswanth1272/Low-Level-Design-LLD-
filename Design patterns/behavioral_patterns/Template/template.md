Template

Idea:
- Define the steps of an algorithm, but let subclasses change specific steps.

When:
- When multiple classes have the same algorithm structure but different parts inside it.

Simple example:
-   Game flow: initialize → start → end;
    Football and Cricket games have different implementations but same steps.

How:
- Parent abstract class defines final method (template) and calls abstract methods implemented by child classes.