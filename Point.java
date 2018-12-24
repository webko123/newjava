public class Point {
    
    // This class calculate the radius and the alpha angle and Converts the angle from radians to degrees.

    //instance variables
    private double _radius;
    private double _alpha;
    private final double DEFAULT_VAL=0;

    /**
     * Construct a point.
     * If one of the parameters is negative then it should be initialized to zero.
     * @param radius The x coordinate
     * @param alpha The y coordinate
     */
    public Point (double X,double Y)
    {

        _radius=(X>DEFAULT_VAL)? X:DEFAULT_VAL;
        _alpha=(Y>DEFAULT_VAL)? Y:DEFAULT_VAL;

        _radius=Math.sqrt((X*X)+(Y*Y));
        _alpha = Math.atan(Y/X)*180/Math.PI;

    }

    /**
     * Copy constructor for Point.
     * Construct a point with the same radius and alpha as other point.
     * @param other The point object from which to construct the new point
     */

    public Point (Point other)
    {

        _radius=other._radius;
        _alpha=other._alpha;

    }

    /**
     * Returns the radius of the point.
     * @return The radius of the point.
     */
    public double getX()
    {
        return Math.round ((Math.cos(_alpha*Math.PI/180)*_radius)*1000)/(double) 1000;

    }

    /**
     * Returns the alpha  of the point.
     * @return The alpha  of the point.
     */
    public double getY()
    {
        return Math.round ((Math.sin(_alpha*Math.PI/180)*_radius)*1000)/(double) 1000;

    }

    /**
     * Sets the radius of the point.
     * If a negative number is received
     * Then the radius does not change.
     * @param sets The new radius.
     */
    public void setX (double sumX)
    {

        if (sumX>= DEFAULT_VAL){

            double sumY=getY();

            _radius=Math.sqrt((sumX*sumX)+(sumY*sumY));
            _alpha = Math.atan(sumY/sumX)*180/Math.PI;

        }
    }

    /**
     * Sets the alpha of the point.
     * If a negative number is received
     * Then the alpha does not change.
     * @param setes The new alpha.
     */

    public void setY (double sumY)
    {
        if (sumY>= DEFAULT_VAL){

            double sumX=getX();

            _radius=Math.sqrt((sumX*sumX)+(sumY*sumY));
            _alpha = Math.atan(sumY/sumX)*180/Math.PI;

        }
    }

    /**
     * Returns a string representation of this point.
     * @return String representation of this point.
     */

    public String toString()
    {
        return "("+getX()+","+getY()+")";

    }

    /**
     * Check if this point equals other point.
     * @param other The point to be compared with this point.
     * @return true if this point equals other point.
     */

    public boolean equals (Point other)
    {
        return (other.getX() == getX() && other.getY() == getY());
    } 

    /**
     * Check if this point is above other point.
     * @param other The point to be compared with this point.
     * @return true if this point is above other point.
     */
    public boolean isAbove (Point other)
    {
        return (getY()>other.getY());
    }

    /**
     * Check if this point is under other point.
     * @param other The point to check if this point is under.
     * @return true if this point is under other point.
     */
    public boolean isUnder (Point other)
    {
        return other.isAbove(this);
    }

    /**
     * Check if this point is to the left of other point.
     * @param other The point to check if this point is left of.
     * @return true if this point is to the left of other point.
     */
    public boolean isLeft (Point other)
    {
        return getX() < other.getX();
    }

    /**
     * Check if this point is to the right of other point.
     * @param other The point to check if this point is right of.
     * @return true if this point is to the right of other point.
     */
    public boolean isRight (Point other)
    {
        return other.isLeft(this);
    }

    /**
     * Calculate the distance between this point and other point.
     * @param other The point to calculate the distance from.
     * @return The distance between this and p points.
     */
    public double distance (Point p)
    {

        double z = 2.0;
        double xDistance = (getX()-p.getX())*(getX()-p.getX());
        double yDistance = Math.pow((getY()-p.getY()),z);

        return Math.round(Math.sqrt(xDistance+yDistance)*1000)/(double)1000;
    }

    /**
     * Moves the x coordinate by deltaX and the y coordinate by deltaY.
     * If movement moves the point outside first quadrant then the
     * point will remain at the same place and not move.
     * @param deltaX The amount to move in the x direction.
     * @param deltaY The amount to move in the y direction.
     */
    public void move (double deltaX, double deltaY)
    {
        if ((getX() + deltaX) >= 0 && (getY() + deltaY) >= 0){
            double moveX=getX()+ deltaX;
            double moveY=getY()+ deltaY;
            _radius=Math.sqrt((moveX*moveX) + (moveY*moveY));
            _alpha=Math.atan(moveY/moveX) *180/Math.PI;
        }
    }
}
