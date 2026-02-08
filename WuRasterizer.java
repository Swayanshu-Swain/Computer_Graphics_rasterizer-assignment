import java.util.ArrayList;

class WuRasterizer implements LineRasterizer {

    @Override
    public Point[] rasterize(Point p1, Point p2) {

        ArrayList<Point> points = new ArrayList<>();

        int x1 = p1.x, y1 = p1.y;
        int x2 = p2.x, y2 = p2.y;

        boolean steep = Math.abs(y2 - y1) > Math.abs(x2 - x1);

        if (steep) {
            int t;
            t = x1; x1 = y1; y1 = t;
            t = x2; x2 = y2; y2 = t;
        }

        if (x1 > x2) {
            int t;
            t = x1; x1 = x2; x2 = t;
            t = y1; y1 = y2; y2 = t;
        }

        int dx = x2 - x1;
        int dy = y2 - y1;
        float gradient = (dx == 0) ? 1 : dy / (float) dx;

        float y = y1;

        for (int x = x1; x <= x2; x++) {
            if (steep) {
                points.add(new Point(Math.round(y), x));
            } else {
                points.add(new Point(x, Math.round(y)));
            }
            y += gradient;
        }

        return points.toArray(new Point[0]);
    }
}
