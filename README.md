# KiragedScript

School project made using Antlr to generate Java Bytecode.

# Example

```javascript
var randomNumber = randomInt(100);

var guessed = false;

while (guessed == false) {
    var guess = askInt();
    if (guess == randomNumber) {
        print(true);
        guessed = true;
    } else {
        print(false);
    }
}
```

More examples can be found in /src/main/kiraged
