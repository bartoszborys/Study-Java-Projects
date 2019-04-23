package pl.polsl.java.maclaurin;

/**
 * Contains problem logic. There is all computing.
 * 
 * @author Bartosz Borys
 * @version 1.0
 */

public class MaclaurinModelImp {
    
    private int accuracy = 0;
    private double x_argument = 0;
    
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
        return this.x_argument;
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
     * @param x_argument double value
     */
    
    public void setArgument(final double x_argument){
        this.x_argument = x_argument;
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
     * Return result of Maclaurin Algorithm 
     * 
     * @return double value
     * @throws Exception thrown when result of the algorithm is below zero.
     */
    
    public double getResult() throws Exception{
        return this.computeEtoX();
    }
    
    /**
     * Method executing realize 8Maclaurin Method 
     * 
     * @return double value ( e^x function )
     * @throws pl.polsl.java.maclaurin.MaclaurinModelImp.ResultLowerThanZero 
     */
    
    private double computeEtoX() throws ResultLowerThanZero{
        double result = 1;
        double argumentToX;
        double factorial;
        
        for(int iter=1; iter<=this.accuracy; iter++){
            argumentToX = Math.pow(this.x_argument, iter);
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
