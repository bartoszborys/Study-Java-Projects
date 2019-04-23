package pl.polsl.java.maclaurin;

import java.util.Vector;

/**
 * Contains problem logic. There is all computing.
 * 
 * @author Bartosz Borys
 * @version 2.1
 */

public class MaclaurinModelImp {
    
    private int accuracy = 0;
    private double argumentX = 0;
    private Vector<Double> ArgumentsX = new Vector<Double>();
    
    /**
     * Own defined exception thrown when algorithm result is lower than zero.
     */
    
    private class ResultLowerThanZero extends Exception{
        
        public ResultLowerThanZero(final double result){
           super( String.valueOf(result).concat(" is impossible result for e^x function!") );
        }
        
    }
    
    /**
     * returns argument
     * @return double value
     */
    
    public final double getArgument(){
        return this.argumentX;
    }
    
    /**
     * returns accuracy
     * @return int value
     */
    
    public final int getAccuracy(){
        return this.accuracy;
    }
    
    /**
     * Sets argument.
     * @deprecated User should use getManyResults() and setManyArguments()
     * @param argumentX double value
     */
    
    public void setArgument(final double argumentX){
        this.argumentX = argumentX;
    }
    
    /**
     * Sets Accuracy.
     * 
     * @param accuracy int value
     * @throws Exception Method throws exception when accuracy is lower than zero
     */
    
    public void setAccuracy(final int accuracy) throws Exception{
        if(accuracy<0){
            throw new Exception("Accuracy can not be lower than zero");
        }
        this.accuracy = accuracy;
    }
    
    /**
     * Sets many arguments.
     * 
     * @param arguments are double values
     * 
     */
    
    public void setManyArguments(double...arguments){
        for(double argument : arguments){
            ArgumentsX.add( new Double(argument) );
        }
    }
    
    /**
     * Compiuting result for every argument in collection 
     * 
     * @return Vector value ( results for every argument )
     */
    
    public Vector<Double> getManyResults() throws Exception{
        Vector<Double> Table = new Vector<Double>();
        for(double argument : ArgumentsX){
            this.setArgument(argument);
            Table.add( this.getResult() );
        }
        return Table;
    }
    
    /**
     * Return result of Maclaurin Algorithm 
     * @deprecated User should use getManyResults() and setManyArguments()
     * @return double value
     * @throws Exception thrown when result of the algorithm is below zero.
     */
    
    public double getResult() throws Exception{
        return this.computeEtoX();
    }
    
    /**
     * Method executing realize Maclaurin Method 
     * 
     * @return double value ( e^x function )
     * @throws ResultLowerThanZero if result is lower than zero
     */
    
    private double computeEtoX() throws ResultLowerThanZero{
        double result = 1;
        double argumentToX;
        double factorial;
        
        for(int iter=1; iter<=this.accuracy; iter++){
            argumentToX = Math.pow(this.argumentX, iter);
            factorial = this.computeFactorial(iter);
            result += argumentToX / factorial;
        }

        if(result < 0){
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
    
    private long computeFactorial(final int argument){        
        long factorial_result = 1;
        
        if(argument > 0){
            for(int i = argument; i>0; i--){
                factorial_result *= i;
            }
        }
        return factorial_result;
    }
}
