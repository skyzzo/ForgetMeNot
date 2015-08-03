/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nuovo;

import java.io.Serializable;

public class MyException extends Exception implements Serializable{
    public MyException(String s){
        super(s);
    }
}
