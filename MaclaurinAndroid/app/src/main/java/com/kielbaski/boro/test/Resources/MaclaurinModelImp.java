package com.kielbaski.boro.test.Resources;

import java.util.Vector;

/**
 * Contains problem logic. There is all computing.
 *
 * @author Bartosz Borys
 * @version 4.0
 */
public class MaclaurinModelImp implements MaclaurinModel{

    private int accuracy = 0;
    private double argumentX = 0;
    private Vector<Double> ArgumentsX = null;
    private static final MaclaurinModelImp Instance = new MaclaurinModelImp();
        
    /**
     * Own defined exception thrown when algorithm result is lower than zero.
     */
    private class ResultLowerThanZero extends Exception {

        public ResultLowerThanZero(final double result) {
            super(String.valueOf(result).concat(" is impossible result for e^x function!"));
        }

    }
    
    public static MaclaurinModel getInstance(){
        return MaclaurinModelImp.Instance;
    }
    
    /**
     * By making basic constructor private class forces user to use getInstance method
     */
    private MaclaurinModelImp(){
    }
    
    /**
     * 
     * Method clears arguments and accuracy values.
     */
    
    @Override
    public void empty(){
        this.ArgumentsX = null;
        this.accuracy = 0;
    }
    
    /**
     * returns argument
     *
     * @return double value
     */
    @Override
    public final double getArgument() {
        return this.argumentX;
    }

    /**
     * returns accuracy
     *
     * @return int value
     */
    @Override
    public final int getAccuracy() {
        return this.accuracy;
    }

    /**
     * Sets Accuracy.
     *
     * @param accuracy int value
     * @throws Exception Method throws exception when accuracy is lower than
     * zero
     */
    @Override
    public void setAccuracy(final int accuracy) throws Exception {
        if (accuracy <= 0) {
            throw new Exception("ERROR: Accuracy can not be lower than zero");
        }
        this.accuracy = accuracy;
    }

    /**
     * Sets many arguments.
     *
     * @param arguments are double values
     *
     */
    @Override
    public void setManyArguments(double... arguments) {
        if(ArgumentsX == null)
            ArgumentsX = new Vector<Double>();
        
        
        for (double argument : arguments) {
            ArgumentsX.add(new Double(argument));
        }
    }

    /**
     * Sets many arguments.
     *
     * @param arguments are double values
     *
     */
    @Override
    public void setManyArguments(Vector<Double> arguments) {
        ArgumentsX = arguments;
    }

    /**
     * Compiuting result for every argument in collection
     *
     * @return Vector value ( results for every argument )
     */
    @Override
    public Vector<Double> getManyResults() throws Exception {
        if (this.ArgumentsX == null) {
            throw new Exception("ERROR: Arguments are not set");
        }
        if (this.accuracy == 0) {
            throw new Exception("ERROR: Accuracy is not set");
        }

        Vector<Double> result = new Vector<Double>();
        for (double argument : ArgumentsX) {
            this.setArgument(argument);
            result.add(this.computeEtoX());
        }
        return result;
    }

    /**
     * Sets argument.
     *
     * @param argumentX double value
     */
    private void setArgument(final double argumentX) {
        this.argumentX = argumentX;
    }

    /**
     * Method executing realize Maclaurin Method
     *
     * @return double value ( e^x function )
     * @throws ResultLowerThanZero if result is lower than zero
     */
    private double computeEtoX() throws ResultLowerThanZero {
        double result = 1;
        double argumentToX;
        double factorial;

        for (int iter = 1; iter <= this.accuracy; iter++) {
            argumentToX = Math.pow(this.argumentX, iter);
            factorial = this.computeFactorial(iter);
            result += argumentToX / factorial;
        }

        if (result < 0) {
            throw new ResultLowerThanZero(result);
        }

        return result;
    }

    /**
     * Calculates factorial value (argument!)
     *
     * @param argument argument of factorial function
     * @return int value, factorial result
     */
    private long computeFactorial(final int argument) {
        long factorial_result = 1;

        if (argument > 0) {
            for (int i = argument; i > 0; i--) {
                factorial_result *= i;
            }
        }
        return factorial_result;
    }
}
