# Water Tank Stack (Java)

A stack (LIFO) implemented with an array, modeled as a water tank. Each bucket holds some liters; the last one poured is the first drained.

## Features
- No-argument and parameterized constructors
- `pour()` (push), `drain()` (pop), `checkTop()` (peek)
- Overflow, underflow, and invalid input handling
- `isEmpty()`, `bucketCount()`, `totalLiters()`

## Run
From the parent folder of `cce/`:

    javac cce/WaterTankDemo.java
    java cce.WaterTankDemo

## Sample output (tank2)
- 4th pour → OVERFLOW (20L spilled)
- 4th drain → UNDERFLOW
- `isEmpty()` → true
