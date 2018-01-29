package core;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Vector2D set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D vector2D) {
        return this.set(vector2D.x, vector2D.y);
    }

    public Vector2D addUp(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D addUp(Vector2D vector2D) {
        return this.addUp(vector2D.x, vector2D.y);
    }

    public Vector2D add(float x, float y) {
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D vector2D) {
        return this.add(vector2D.x, vector2D.y);
    }

    public Vector2D subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2D subtractBy(Vector2D vector2D) {
        return this.subtractBy(vector2D.x, vector2D.y);
    }

    public Vector2D subtract(float x, float y) {
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D subtract(Vector2D vector2D) {
        return this.subtract(vector2D.x, vector2D.y);
    }

    public double length(float x, float y) {
        return (Math.sqrt(x*x + y*y));
    }

    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    public Vector2D rotate(double degree) {

        return new Vector2D(this.x * (float) Math.cos(Math.toRadians(degree)) - this.y * (float) Math.sin(Math.toRadians(degree)),
                this.x * (float) Math.sin(Math.toRadians(degree)) + this.y * (float) Math.cos(Math.toRadians(degree)));
    }
    public Vector2D normalize() {
        return new Vector2D((float) (this.x / length(this.x, this.y)), (float) (this.y / length(this.x, this.y)));
    }

    public Vector2D multiply(float number) {
        this.x *= number;
        this.y *= number;
        return this;
    }
}
