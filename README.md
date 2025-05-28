# pre-decimal-converter

A simple Java command-line application for converting between post-1971 decimal British currency (new pennies) and pre-decimal currency (pounds, shillings, pence).

## Features
- Convert new (decimal) pennies to pre-decimal currency
- Pretty-print pre-decimal currency values
- Input validation and error handling for user-friendly experience

## Usage

### Requirements
- Java 8 or higher

### Compile

Open a terminal in the project directory and run:

```
javac Main.java UserInterface.java PreDecimalCurrency.java DecimalCurrency.java
```

### Run

```
java Main
```

### Example

```
What would you like to do?
1. Pretty print pre-decimal currency.
2. Convert new pennies to pre-decimal currency.
2
Enter the number of new pennies
50
50p in pre-decimal currency is £0 10s 0d
```

## File Overview
- `Main.java`: Entry point for the application
- `UserInterface.java`: Handles user input and output
- `PreDecimalCurrency.java`: Represents pre-decimal currency values
- `DecimalCurrency.java`: Handles conversion from decimal to pre-decimal currency

## License
See [LICENSE](LICENSE)