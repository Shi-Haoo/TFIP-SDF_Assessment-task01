package your.sc1;

import java.io.Serializable;

public class Evaluate implements Serializable {

    private float sum = 0;
    private float count = 0;
    private float avg = 0;
    private float sumForSD = 0;
    private float convertedNum;
    float mean = 0;
    float sd = 0;

    public Evaluate(Float mean,Float sd) {
        this.mean = mean;
        this.sd = sd;
    }


    public void computeAvg(String[] listOfNums){

        for(String n : listOfNums){

            sum += Float.parseFloat(n);
            count++;
        }

        this.mean = sum/count;
        
        System.out.println(">>>"+mean);
    }

    public void computeSD(String[] numbers){

        for(String i : numbers){
            convertedNum = Float.parseFloat(i); 
            sumForSD += (Math.pow(convertedNum-mean, 2)); 
        }

        this.sd = (float) Math.sqrt(sumForSD/count);
    }
}
