public class Vector {

    Vector previousVector;

    float mass = 10;
    float stringLength;
    float angle;

    float velocity;
    float acceleration;
    double tipX;
    double tipY;

    double prevTipX;
    double prevTipY;

    float stringX;
    float stringY;

    float offset = 0;

    float lengthCoefficient = 1;

    int direction = 1;

    float angleRate = 0.01f;

    public Vector(Vector previousVector, float mass, float stringLength, float angle, float stringX, float stringY) {
        this.previousVector = previousVector;
        this.mass = mass;
        this.stringLength = stringLength;
        this.angle = angle;
        this.stringX = stringX;
        this.stringY = stringY;
    }

    public Vector(Vector previousVector, float mass, float stringLength, int direction) {
        this.previousVector = previousVector;
        this.mass = mass;
        this.stringLength = stringLength;
        this.direction = direction;
    }


    public Vector(float mass, float stringLength) {
        this.mass = mass;
        this.stringLength = stringLength;
    }

    public Vector(float stringLength) {
        this.mass = 10;
        this.stringLength = stringLength;
    }

    public Vector(float stringLength, int direction) {
        this.stringLength = stringLength;
        this.direction = direction;
        this.mass = 10;
    }

    public Vector(Vector previousVector, float stringLength, float angle, float stringX, float stringY) {
        this.previousVector = previousVector;
        this.stringLength = stringLength;
        this.angle = angle;
        this.stringX = stringX;
        this.stringY = stringY;
    }

    public Vector(Vector previousVector, float stringLength, float stringX, float stringY) {
        this.previousVector = previousVector;
        this.stringLength = stringLength;
        this.stringX = stringX;
        this.stringY = stringY;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getStringLength() {
        return stringLength;
    }

    public void setStringLength(float stringLength) {
        this.stringLength = stringLength;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public float getOffset() {
        return offset;
    }

    public void setOffset(float offset) {
        this.offset = offset;
    }

    public Vector getPreviousVector() {
        return previousVector;
    }

    public void setPreviousVector(Vector previousVector) {
        this.previousVector = previousVector;
    }

    public double getTipX() {
        return tipX;
    }

    public void setTipX(Double tipX) {
        this.prevTipX = this.tipX;
        this.tipX = tipX;
    }

    public double getTipY() {
        return tipY;
    }

    public void setTipY(Double tipY) {
        this.prevTipY = this.tipY;
        this.tipY = tipY;
    }

    public float getStringX() {
        return stringX;
    }

    public float getLengthCoefficient() {
        return lengthCoefficient;
    }

    public void setLengthCoefficient(float lengthCoefficient) {
        this.lengthCoefficient = lengthCoefficient;
    }

    public void setStringX(float stringX) {
        this.stringX = stringX;
    }

    public float getStringY() {
        return stringY;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setStringY(float stringY) {
        this.stringY = stringY;
    }

    public float getAngleRate() {
        return angleRate;
    }

    public void setAngleRate(float angleRate) {
        this.angleRate = angleRate;
    }

    public double getPrevXPosition() {
        return prevTipX;
    }

    public void setPrevXPosition(float prevTipX) {
        this.prevTipX = prevTipX;
    }

    public double getPrevYPosition() {
        return prevTipY;
    }

    public void setPrevYPosition(float prevTipY) {
        this.prevTipY = prevTipY;
    }
}
