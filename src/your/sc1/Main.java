package your.sc1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main{

    public static void main(String[] args) throws UnknownHostException,IOException{

        float mean = 0;
        float sd = 0;

        Socket sock = new Socket(args[0],Integer.parseInt(args[1]));

        OutputStream os = sock.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
             
        InputStream is = sock.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

        String numberList = ois.readUTF();
        System.out.println(numberList);
        String[] eachNum = numberList.split(",");
        Evaluate evaluated = new Evaluate(mean,sd);
        evaluated.computeAvg(eachNum);
        evaluated.computeSD(eachNum);


        oos.writeUTF("Tan Shi Hao");
        oos.writeUTF("tanshihao95@gmail.com");
        oos.writeFloat(evaluated.mean);
        oos.writeFloat(evaluated.sd);
        oos.flush();

        oos.close();
        ois.close();
       
    }
 
}
