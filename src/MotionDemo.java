import processing.core.PApplet;
import processing.core.PGraphics;

import java.util.ArrayList;
import java.util.function.Function;

public class MotionDemo extends PApplet {


    PGraphics canvas = new PGraphics();

//    double [] testVals = {1.9469477, 1.6669978, 2.0252397, 1.1230639, 1.7978036, 1.9344394, 0.3459814};

    int screenWidth = 1200, screenHeight = 900;
    float constant = 1000000000f;

//    float angle = PI/4;
//    float radius = 200;
//    float mass = 30;
//    float acceleration = 0;
//    float velocity = 0;
//    float gravity = 0.4f;
    float startTime = System.nanoTime() / constant;
    double currentTime;

    boolean firstRun = true;

    private Function<Double, Double> function = t ->  5  * ( 4 * ( Math.cos(2 * Math.PI * t) - 4 * Math.sin( 2 * Math.PI * t) ) );
    private Function<Double, Double> fPrime = n ->
    private Function<Double, Double> functionX = t -> Math.sin(2 * Math.PI * t) - Math.cos(2 * Math.PI * t) ;
//    private Function<Double, Double> function = x -> Math.sin(x) * currentTime;

    ArrayList<Vector> pendulums = new ArrayList<>();


    @Override
    public void settings() {
        size(screenWidth, screenHeight);

    }

    public void setup() {
        setSize(screenWidth, screenHeight);
        canvas = createGraphics(screenWidth, screenHeight);
        canvas.beginDraw();
        canvas.background(255);
        canvas.endDraw();

        createVectors(5);

    }

    public void draw() {
//        background(255);
//        linkVectors(pendulums, firstRun);
//        System.out.println(startTime);
        currentTime = System.nanoTime() / constant - startTime;
//        System.out.println(currentTime);
        linkVectorsAutomatically(pendulums, firstRun);
        firstRun = false;

//        pendulums.get(1).setLengthCoefficient(2);
//        pendulums.get(2).setLengthCoefficient(2);
//        pendulums.get(1).setOffset(2);
//        pendulums.get(2).setOffset(2);
//        pendulums.get(0).setOffset(integrate(0, 1, x -> 2 + 2*Math.cos(x)));



        image(canvas, 0,0);
        stroke(255, 0, 0);
        for (Vector pendulum : pendulums) {
            strokeWeight(2);
            if (pendulum.getPreviousVector() == null) {
                translate(pendulum.getStringX(), pendulum.getStringY());
//                pendulum.setTipX(pendulum.stringLength * pendulum.getLengthCoefficient() * cos(pendulum.getOffset() + pendulum.getAngle()));
                pendulum.setTipX(pendulum.lengthCoefficient * cos(pendulum.getOffset()) + functionX.apply(currentTime));
                pendulum.setTipY(pendulum.lengthCoefficient * sin(pendulum.getOffset()) + function.apply((currentTime)));
//                pendulum.setTipY((double) (pendulum.stringLength * pendulum.getLengthCoefficient() * sin(pendulum.getOffset() + pendulum.getAngle())));
                line(0, 0, (float) pendulum.getTipX(), (float) pendulum.getTipY());
                fill(0);

            } else {
                translate((float) pendulum.getPreviousVector().getTipX(), (float) pendulum.getPreviousVector().getTipY());
//                pendulum.setTipY((double) (pendulum.stringLength * pendulum.getLengthCoefficient() * sin(pendulum.getOffset() + pendulum.getAngle())) /*+ pendulum.getPreviousVector().getTipY()*/);
                pendulum.setTipX((double) (pendulum.stringLength * pendulum.getLengthCoefficient() * cos(pendulum.getOffset() + pendulum.getAngle())));
//                pendulum.setTipX(pendulum.lengthCoefficient * cos(pendulum.getOffset()) + functionX.apply(currentTime));
                pendulum.setTipY(pendulum.lengthCoefficient * sin(pendulum.getOffset()) + function.apply(currentTime));
                line(0,0, (float) pendulum.getTipX(), (float) pendulum.getTipY());
                fill(0);
//                System.out.println(pendulum.getTipY());
                System.out.println(currentTime);

            }
            fill(255, 0, 0);
            ellipse((float) pendulum.getTipX(), (float) pendulum.getTipY(), pendulum.getMass(), pendulum.getMass());
//            if (pendulums.get(0).getAngle() >=  2 * PI) {
//                pendulum.setAngleRate(0);
//            } else {
                pendulum.setAngle(pendulum.getAngle() + pendulum.getAngleRate() * 0.2f);
//            }
            if (pendulum == pendulums.get(pendulums.size() - 1)) {
//                System.out.println(pendulum.getTipX() + "   " + pendulum.getTipY());
                canvas.beginDraw();
                canvas.translate(screenWidth/2f, screenHeight/2f);
                canvas.strokeWeight(4);

//                canvas.translate(pendulum.getPreviousVector().getPreviousVector().getTipX(), pendulum.getPreviousVector().getPreviousVector().getTipY());
                canvas.stroke(0);
                if (frameCount > 1) {
                    canvas.line(calculateTotalPrevX(pendulums), calculateTotalPrevY(pendulums), calculateTotalX(pendulums), calculateTotalY(pendulums));
                }
                canvas.endDraw();
            }
        }

//        System.out.println(pendulums.get(0).getAngle());


//        translate(200, 50);

//        float x = radius * sin(angle);
//        float y = radius * cos(angle);



//        fill(0);
//        ellipse(x, y, mass, mass);

//        angle += 0.1;
//        acceleration = (-1 * gravity / radius) * sin(angle);
//        velocity += acceleration;
//        angle += velocity;



//        ellipse(pendulums.get(pendulums.size() - 1).getTipX(), pendulums.get(pendulums.size() - 1).getTipY(), 5, 5);

    }

//    private void linkVectors(ArrayList<Vector> pendulums, boolean firstLink) {
//
//        if (firstLink) {
//            for (int i = 0; i < pendulums.size(); i++) {
//                if (i > 0) {
//                    pendulums.get(i).setPreviousVector(pendulums.get(i - 1));
//                }
////                pendulums.get(i).setAngleRate(random(0.01f, 0.1f)/*pendulums.get(i).getAngleRate() + ( i * 0.01f)*/);
//                pendulums.get(i).setAngleRate((float) (Math.PI * 0.01f * pendulums.get(i).getVector()));
//                int finalI = i;
//            }
//        }
//
//
//        for (Vector p : pendulums) {
//            if (p.getPreviousVector() != null) {
//                p.setStringX(p.getPreviousVector().getTipX());
//                p.setStringY(p.getPreviousVector().getTipY());
//            } else {
//                p.setStringX(screenWidth/2f);
//                p.setStringY(screenHeight/2f);
//            }
//        }
//    }

    private void createVectors( int numVectors ) {
        for (int i = 0; i < numVectors; i++) {
            pendulums.add(new Vector(50));
        }
    }

    private void linkVectorsAutomatically(ArrayList<Vector> pendulums, boolean firstLink) {

        int vectorSimilarity = 1;
        int vectorQuantity = 0;
        int vectorMagnitude = 1;

        if (firstLink) {



            for (int i = 0; i < pendulums.size(); i++) {

                if (vectorSimilarity <= 0) {
                    vectorMagnitude++;
                    vectorSimilarity = 2;
                }

//                pendulums.get(i).setOffset(random(0, 2 * PI));

                if (i > 0) {
                    pendulums.get(i).setPreviousVector(pendulums.get(i - 1));
                } else {
                    pendulums.get(i).setPreviousVector(null);
                }
//                pendulums.get(i).setAngleRate(random(0.01f, 0.1f)/*pendulums.get(i).getAngleRate() + ( i * 0.01f)*/);
                if (i != 0 && i % 2 == 0) {
                    pendulums.get(i).setDirection(vectorMagnitude);
                } else if (i % 2 != 0) {
                    pendulums.get(i).setDirection(-vectorMagnitude);
                } else {
                    pendulums.get(i).setDirection(0);
                }
                pendulums.get(i).setAngleRate((float) (2*Math.PI * 0.01f * pendulums.get(i).getDirection()));
                int finalI = i;
                float num = integrate(0, 1, x ->((function.apply(x)) * pendulums.get(finalI).getAngleRate()/* * currentTime*/));
                pendulums.get(i).setOffset(num * pendulums.get(i).getAngleRate());
//                System.out.println(pendulums.get(i).getOffset());

                pendulums.get(i).setLengthCoefficient(cos(num));
//                System.out.println(currentTime);
//                pendulums.get(i).setLengthCoefficient((float) Math.pow(0.5f * random(1, 3), 2));
//                pendulums.get(i).setLengthCoefficient((float) testVals[i]);


                vectorSimilarity--;

//                System.out.println(pendulums.get(i).getLengthCoefficient());

            }

        }


        for (Vector p : pendulums) {
            if (p.getPreviousVector() != null) {
                p.setStringX((float) p.getPreviousVector().getTipX());
                p.setStringY((float) p.getPreviousVector().getTipY());
            } else {
                p.setStringX(screenWidth/2f);
                p.setStringY(screenHeight/2f);
            }
        }
    }


    private float calculateTotalX(ArrayList<Vector> pendulums) {
        float sum = 0;
        for (Vector pendulum : pendulums) {
            sum += pendulum.getTipX();
        }
        return sum;
    }

    private float calculateTotalPrevX(ArrayList<Vector> pendulums) {
        float sum = 0;
        for (Vector pendulum : pendulums) {
            sum += pendulum.getPrevXPosition();
        }
        return sum;
    }

    private float calculateTotalY(ArrayList<Vector> pendulums) {
        float sum = 0;
        for (Vector pendulum : pendulums) {
            sum += pendulum.getTipY();
        }
        return sum;
    }

    private float calculateTotalPrevY(ArrayList<Vector> pendulums) {
        float sum = 0;
        for (Vector pendulum : pendulums) {
            sum += pendulum.getPrevYPosition();
        }
        return sum;
    }

    public static float integrate(double a, double b, Function<Double, Double> function) {

        double increment = 1E-4;
        double area = 0;
        double modifier = 1;

        if (a > b) {
            double tempA = a;
            a = b;
            b = tempA;
            modifier = -1;
        }

        for (double i = a + increment; i < b; i+= increment) {
            double distFromA = i - a;
            area += (increment/2) * (function.apply(a + distFromA) + function.apply(a + distFromA - increment));
        }

        return (float) area;

    }

    public static void main(String[] args) {
        PApplet.main("MotionDemo");
    }



}
