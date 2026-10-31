# lab_6

Parallel programming lab (Java threads): a character histogram of a random 25x40 image of ASCII characters (33-126).

- `Obraz.java`: the image ("obraz"), sequential and partial histogram methods, synchronized merge
- `Watek.java`: task 1a, one `Thread` subclass per character (94 threads)
- `Watek2.java`: task 1b, a `Runnable` that handles a range of characters; the thread count is read from stdin
- `Histogram_test.java`: `main`
- `wateek1`, `watek2`: saved sample output

## Build & run
```bash
javac -d out src/*.java
java -cp out Histogram_test
```
