import java.util.ArrayList;

class DDARasterizer implements LineRasterizer {

    @Override
    public Point[] rasterize(Point p1, Point p2) {

        ArrayList<Point> points = new ArrayList<>();

        int dx = p2.x - p1.x;
        int dy = p2.y - p1.y;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xInc = dx / (float) steps;
        float yInc = dy / (float) steps;

        float x = p1.x;
        float y = p1.y;

        for (int i = 0; i <= steps; i++) {
            points.add(new Point(Math.round(x), Math.round(y)));
            x += xInc;
            y += yInc;
        }

        return points.toArray(new Point[0]);
    }
}
