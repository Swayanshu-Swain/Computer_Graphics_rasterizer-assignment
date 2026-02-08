# Rasterization Assignment

You have to implement the following algorithms:

- Bresenham Line Drawing Algorithm
- Midpoint Circle Drawing Algorithm
- DDA Line Drawing Algorithm
- Wu's Line Drawing Algorithm (Bonus)

## Prerequisites

You will need **Java JDK 17 or higher** (tested with JDK 25)
and JogAmp. Download `jogamp-fat.jar` from [the official
website](https://jogamp.org/deployment/jogamp-current/fat/) and
put it in the current directory.

## Project Structure

Your directory should look like this:

```
.
├── BresenhamRasterizer.java
├── jogamp-fat.jar
├── LineRasterizer.java
├── LineRasterizerTest.java
├── processing
│   ├── awt
│   ├── core
│   ├── data
│   ├── event
│   └── opengl
└── README.md

7 directories, 5 files
```

## Compilation

Compile all Processing source files first, then compile the test file:

```bash
find processing -name "*.java" -print | xargs javac -classpath .:jogamp-fat.jar
javac -classpath .:jogamp-fat.jar LineRasterizerTest.java
```

## Running the Test

```bash
java -classpath .:jogamp-fat.jar LineRasterizerTest
```

## Using the Framework

When you run the program, you'll see:
- A 50×50 grid where each cell represents a pixel
- A thin **red line** showing the ideal continuous line between two
endpoints
- **Blue filled cells** showing your rasterization algorithm's output
- Two **red circle endpoints** that you can click and drag to test
different line orientations

## Implementing Your Algorithm

1. Locate the `LineRasterizer.java` interface in the code:
```java
interface LineRasterizer {
    Point[] rasterize(Point p1, Point p2);
}
```

2. Create your implementation class (`BresenhamRasterizer.java` for example):
```java
class BresenhamRasterizer implements LineRasterizer {
    // Your algorithm here
    // Return an array of Points representing the rasterized pixels
}
```

3. Update the line in `setup()` to use your implementation:
```java
rasterizer = new BresenhamRasterizer();
```

4. Recompile and run to see your results

## Tips

- The `Point` class uses grid coordinates (0-49 for both x and y)
- Each point you return will be rendered as a filled cell in the grid
- Drag the endpoints to test your algorithm with different slopes and
orientations
- The red reference line shows what the "ideal" continuous line looks
like

## Testing Different Algorithms

Implement the following files:

- `BresenhamRasterizer.java`
- `DDARasterizer.java`
- `WuRasterizer.java`
- `MidpointCircleRasterizer.java`

and switch between them by changing which one is instantiated in
`setup()`. For midpoint, the points `p1` and `p2` in the LineRasterizer
interface are the end points of the diameter.
